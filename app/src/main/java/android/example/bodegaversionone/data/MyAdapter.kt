package android.example.bodegaversionone.data

import android.content.Context
import android.example.bodegaversionone.R
import android.example.bodegaversionone.models.Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_items.view.*



class MyAdapter(val context: Context, val userList: List<Product>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var description: TextView
        var image: ImageView

        init {
            title = itemView.title
            description = itemView.description
            image = itemView.imageProduct
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = userList[position].title.take(20)
        holder.description.text = userList[position].description

        val url = userList[position].image

        Glide.with(holder.image)
            .load(url)
            .into(holder.image)



    }

    override fun getItemCount(): Int {
        return userList.size
    }
}