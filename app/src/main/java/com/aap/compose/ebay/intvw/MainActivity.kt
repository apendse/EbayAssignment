package com.aap.compose.ebay.intvw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.aap.compose.ebay.intvw.navigation.NavigationGraph
import com.aap.compose.ebay.intvw.ui.theme.EbayAssignmentTheme
import com.aap.compose.ebay.intvw.ui.theme.Orange40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            EbayAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.background(Orange40),
                            title = { Text(text = stringResource(id = R.string.app_name)) })
                    }
                ) {

                    NavigationGraph(Modifier.padding(it), navController = navController)
                }
            }
        }
    }
}

