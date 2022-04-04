package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ConfirmationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<LoginActivity>()


    @Test
    fun ticketconfirm_Test() {
        val text = composeTestRule.activity.getString(R.string.ticket_confirmed, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun ticketnum_Test() {
        val text = composeTestRule.activity.getString(R.string.ticket_number_placeholder, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun results_saved_Test() {
        val text = composeTestRule.activity.getString(R.string.ticket_response, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun placeholder_Test() {
        val text = composeTestRule.activity.getString(R.string.placeholder, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun returnbtn_Test() {
        val text = composeTestRule.activity.getString(R.id.btnAccount, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }
    @Test
    fun checkbox_imageTest(){
        val image= composeTestRule.activity.getString(R.id.checkboxImage, 0)
        composeTestRule.onNodeWithText(image).assertExists()
    }
}