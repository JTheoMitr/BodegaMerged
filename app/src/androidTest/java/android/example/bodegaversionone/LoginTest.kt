package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class LoginTest {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun emailTextTest(){
        val text= composeTestRule.activity.getString(R.string.email, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun passwordTextTest(){
        val text= composeTestRule.activity.getString(R.string.password, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }

    @Test
    fun signinBtnTest(){
        val text= composeTestRule.activity.getString(R.string.sign_in, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
    @Test
    fun registerBtnTest(){
        val text= composeTestRule.activity.getString(R.string.register, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
}