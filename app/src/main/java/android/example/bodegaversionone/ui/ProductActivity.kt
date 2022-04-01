package android.example.bodegaversionone.ui

import android.content.Intent
import android.content.SharedPreferences
import android.example.bodegaversionone.MainActivity
import android.example.bodegaversionone.R
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import android.example.bodegaversionone.utils.Preferences


class ProductActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName

    private val activity : MainActivity = MainActivity()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)


        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val image = intent.getParcelableExtra<Bitmap>("image")


        val tvTitle = findViewById<TextView>(R.id.tvProductViewTitle)
        val tvDesc = findViewById<TextView>(R.id.tvProductViewDescription)
        val img = findViewById<ImageView>(R.id.imageView)

        tvTitle.text = title
        tvDesc.text = description
        img.setImageBitmap(image)

    }

    fun addToCart(view: View) {
        val prefs = Preferences(this)
        var item = intent.getStringExtra("title").toString()
        prefs.editor.putString(intent.getStringExtra("title").toString(),item).apply()

        val cartIntent = Intent(this, CartActivity::class.java)
        cartIntent.putExtra("title", intent.getStringExtra("title").toString())
        startActivity(cartIntent)
    }
}