package android.example.bodegaversionone.ui

import android.example.bodegaversionone.R
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG = javaClass.simpleName

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

    fun addToCart(view: View) {}
}