package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
    }

    fun payment(view: View) {
        val paymentIntent = Intent(this, PaymentActivity::class.java)
        startActivity(paymentIntent)
    }
}