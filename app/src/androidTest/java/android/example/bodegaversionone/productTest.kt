package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class productTest {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun textViewTest(){
        val text= composeTestRule.activity.getString(R.id.tvProductViewTitle, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun descriptionTest(){
        val text= composeTestRule.activity.getString(R.id.tvProductViewDescription, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun imageTest(){
        val image= composeTestRule.activity.getString(R.id.imageView, 0)
        composeTestRule.onNodeWithText(image).assertExists()

    }
}