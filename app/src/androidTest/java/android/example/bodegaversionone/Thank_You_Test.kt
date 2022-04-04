package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class Thank_You_Test {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun thanksTextTest(){
        val text= composeTestRule.activity.getString(R.string.order_onthe_way, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun mapTest(){
        val map= composeTestRule.activity.getString(R.id.mapView, 0)
        composeTestRule.onNodeWithText(map).assertExists()

    }
}