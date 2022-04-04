package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class New_Item_Test {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LoginActivity>()


    @Test
    fun edit_itemTest() {
        val text = composeTestRule.activity.getString(R.id.edit_item, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun saveBtnTest(){
        val text= composeTestRule.activity.getString(R.id.button_save, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
}