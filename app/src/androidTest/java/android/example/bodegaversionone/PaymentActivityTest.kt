package android.example.bodegaversionone

import android.example.bodegaversionone.ui.LoginActivity
import android.example.bodegaversionone.ui.PaymentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class PaymentActivityTest {
    @get:Rule
    val composeTestRule= createAndroidComposeRule<PaymentActivity>()


    @Test
    fun payshipinfoTextTest(){
        val text= composeTestRule.activity.getString(R.string.pay_shipping, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }

    @Test
    fun fullnameTextTest(){
        val text= composeTestRule.activity.getString(R.string.first_name,R.string.last_name, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }

    @Test
    fun emailTextTest(){
        val text= composeTestRule.activity.getString(R.string.email, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun phoneNumTextTest(){
        val text= composeTestRule.activity.getString(R.string.phone_num, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }
    @Test
    fun addressTextTest(){
        val text= composeTestRule.activity.getString(R.string.address, 0)
        composeTestRule.onNodeWithText(text).assertExists()

    }

    @Test
    fun purchaseBtnTest(){
        val text= composeTestRule.activity.getString(R.string.purchase, 0)
        composeTestRule.onNodeWithText(text).assertExists()
        composeTestRule.onNodeWithText(text).performClick()
    }
}