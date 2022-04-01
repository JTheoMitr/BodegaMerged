package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
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

        var title : String

        val cartList = findViewById<LinearLayout>(R.id.cartLayout)

        if (intent.extras != null) {
            // I'm sorry for this bad programming
            title = intent.getStringExtra("title").toString()
            if(title != null) {
                var tv = TextView(this)
                tv.textSize = 20f
                tv.text = title
                cartList.addView(tv)
            }
        }
    }

    fun checkout(view: View) {
        val checkoutIntent = Intent(this, CheckoutActivity::class.java)
        checkoutIntent.putExtra("title", intent.getStringExtra("title").toString())
        startActivity(checkoutIntent)
    }
}