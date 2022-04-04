package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class Row_Item_Test {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun title_Test(){
        val text= composeTestRule.activity.getString(R.id.title, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun description_Test(){
        val text= composeTestRule.activity.getString(R.id.description, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun product_imageTest(){
        val image= composeTestRule.activity.getString(R.id.imageProduct, 0)
        composeTestRule.onNodeWithText(image).assertExists()

    }
}