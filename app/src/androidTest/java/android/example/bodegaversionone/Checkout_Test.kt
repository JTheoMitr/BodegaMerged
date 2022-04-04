package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import org.junit.Rule
import org.junit.Test

class Checkout_Test {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LoginActivity>()


    @Test
    fun textViewTest() {
        val text = composeTestRule.activity.getString(R.id.tvCartTitle, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun scrollTest() {
        val scroll = composeTestRule.activity.getString(R.id.scrollView2, 0)
        composeTestRule.onNodeWithText(scroll).performScrollTo()
    }
    @Test
    fun checkoutBtnTest(){
        val text= composeTestRule.activity.getString(R.id.btnCheckout, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
}