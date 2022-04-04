package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class Form_Test {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<LoginActivity>()


    @Test
    fun headerTextTest(){
        val text= composeTestRule.activity.getString(R.id.ticketHeader, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun captionTextTest(){
        val text= composeTestRule.activity.getString(R.id.ticketCaption, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun firstname_TextTest(){
        val text= composeTestRule.activity.getString(R.id.editTextFirstName, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun lastname_TextTest(){
        val text= composeTestRule.activity.getString(R.id.editTextLastName, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun ticket_body_TextTest(){
        val text= composeTestRule.activity.getString(R.string.how_can_we_help_you, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun submitBtnTest(){
        val text= composeTestRule.activity.getString(R.id.btnFormSubmit, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }


}