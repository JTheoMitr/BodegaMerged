package android.example.bodegaversionone.data

import android.content.Context
import android.example.bodegaversionone.R
import android.example.bodegaversionone.models.Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_items.view.*

class ProductAdapter(context : Context, val productList : List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(productView : View) : RecyclerView.ViewHolder(productView) {

        var title: TextView
        var description: TextView
        var image: ImageView

        init {
            title = productView.title
            description = productView.description
            image = productView.imageProduct
        }

        companion object {
            fun create(parent : ViewGroup) : ProductViewHolder {
                val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false)
                return ProductViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int) : ProductViewHolder {
        return ProductAdapter.ProductViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        
        holder.title.text = productList[position].title.take(20)
        holder.description.text = productList[position].description
        val url = productList[position].image

        Glide.with(holder.image)
            .load(url)
            .into(holder.image)
    }


    override fun getItemCount(): Int {
        return productList.size
    }

    
}