package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import android.example.bodegaversionone.utils.Preferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        val cartList = findViewById<LinearLayout>(R.id.cartLayout)

        var prefs : Preferences = Preferences(this)
        prefs.getList()?.forEach {
            var tv = TextView(this)
            tv.textSize = 20f
            tv.text = it
            cartList.addView(tv)
        }


    }

    fun checkout(view: View) {
        val checkoutIntent = Intent(this, CheckoutActivity::class.java)
        checkoutIntent.putExtra("title", intent.getStringExtra("title").toString())
        startActivity(checkoutIntent)
    }
}