package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class Recycler_View_Test {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun product_title_Test(){
        val text= composeTestRule.activity.getString(R.string.all_products, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }

    @Test
    fun recyclerview_products_Test(){
        val text= composeTestRule.activity.getString(R.id.recyclerview_products, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
}