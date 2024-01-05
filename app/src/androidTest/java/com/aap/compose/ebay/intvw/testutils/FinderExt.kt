package com.aap.compose.ebay.intvw.testutils

import android.util.Log
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider

fun SemanticsNodeInteractionsProvider.hasClass(className: String): SemanticsNodeInteraction {
    return onNode(SemanticsMatcher("class is $className") { node ->
        Log.d("YYYY", "node $node layoutinfo: ${node.layoutInfo}")
        false
    }, false)
}


