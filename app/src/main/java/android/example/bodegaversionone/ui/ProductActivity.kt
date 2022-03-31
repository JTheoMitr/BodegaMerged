package android.example.bodegaversionone.ui

import android.example.bodegaversionone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
    }

    fun addToCart(view: View) {}
}