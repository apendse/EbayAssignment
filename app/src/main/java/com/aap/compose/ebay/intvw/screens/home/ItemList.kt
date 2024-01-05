package com.aap.compose.ebay.intvw.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aap.compose.ebay.intvw.R
import com.aap.compose.ebay.intvw.data.GenericDataVO
import com.aap.compose.ebay.intvw.repo.GenericResponse
import org.jetbrains.annotations.VisibleForTesting

@Composable
fun TopMemes(
    onMemeClick: (Int) -> Unit, viewModel: ItemListViewModel = hiltViewModel()
) {
    val memes = viewModel.memes.observeAsState()
    Log.d("YYYY", "in TopMemes")
    LaunchedEffect(key1 = Unit) {
        Log.d("YYYY", "Before fetch top memes")
        viewModel.fetchTopMemes()
        Log.d("YYYY", "After fetch top memes")
    }
    val context = LocalContext.current
    Log.d("YYYY", "Before when")
    when (memes.value) {
        is GenericResponse.GenericError -> {
            Toast.makeText(
                context,
                (memes.value as GenericResponse.GenericError).message,
                Toast.LENGTH_LONG
            ).show()
            Log.d("YYYY", "error")
        }

        is GenericResponse.GenericSuccess -> {
            Log.d("YYYY", "success")

            Log.d("YYYY", "after success")
        }

        null -> {
            Log.d("YYYY", "spinner")
            ShowSpinner()
        }
    }
}

@Composable
fun ShowSpinner() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@VisibleForTesting
@Composable
fun ShowMemesList(list: List<GenericDataVO>, onMemeClick: (Int) -> Unit, onDelete: (Int) -> Unit) {
    LazyVerticalGrid(
        //modifier = Modifier.animateItemPlacement,
        columns = GridCells.Fixed(2) //GridCells.Adaptive(minSize = 128.dp),

    ) {
        this.itemsIndexed(list, key = {_, meme -> meme.url}) {index, item ->
            RenderSingleGrid(item, index, onMemeClick, onDelete)
            Divider(color = Color.LightGray, thickness = 2.dp)
        }

    }
}

@Composable
fun RenderSingleGrid(
    genericDataVO: GenericDataVO,
    index: Int,
    onMemeClick: (Int) -> Unit,
    onDeleteMeme: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(genericDataVO.url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = genericDataVO.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                //.clip(CircleShape)
                .width(256.dp)
                .clickable {
                    onMemeClick(index)
                }
        )
        Button(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = {
                onDeleteMeme(index)
            },
            content = {
                Text(
                    text = stringResource(id = R.string.delete_meme),
                    fontSize = 10.sp,
                    color = Color.White
                )
            }
        )

    }

}

@Composable
private fun ShowMemesListOld(list: List<GenericDataVO>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(list.size) {
            RenderRow(list[it])
        }
    }
}

@Composable
private fun RenderRow(genericDataVO: GenericDataVO) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(genericDataVO.url)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = genericDataVO.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .width(48.dp)
                .height(48.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = genericDataVO.name)
    }
}