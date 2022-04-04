package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class profile {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun welcomeTextTest(){
        val text= composeTestRule.activity.getString(R.id.welcomeText, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun resetBtnTest(){
        val text= composeTestRule.activity.getString(R.id.btnPasswordReset, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
    @Test
    fun image_avatar_Test(){
        val image= composeTestRule.activity.getString(R.id.imageAvatar, 0)
        composeTestRule.onNodeWithText(image).assertExists()

    }
    @Test
    fun image_basket_Test(){
        val image= composeTestRule.activity.getString(R.id.basketImage, 0)
        composeTestRule.onNodeWithText(image).assertExists()

    }
    @Test
    fun image_support_Test(){
        val image= composeTestRule.activity.getString(R.id.supportImage, 0)
        composeTestRule.onNodeWithText(image).assertExists()

    }




}