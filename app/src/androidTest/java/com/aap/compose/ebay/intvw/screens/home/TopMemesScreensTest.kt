package com.aap.compose.ebay.intvw.screens.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.aap.compose.ebay.intvw.testutils.hasClass
import com.aap.compose.ebay.intvw.ui.theme.EbayAssignmentTheme
import org.junit.Rule
import org.junit.Test



class TopMemesScreensTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifySpinnerIsShown() {
        composeTestRule.setContent {
            EbayAssignmentTheme {
                ShowSpinner()
            }
        }
        composeTestRule.hasClass("Continue").assertIsDisplayed()
    }


    @Test
    fun verifyListIsShown() {
    }

    @Test
    fun verifySingleGrid() {
    }
}