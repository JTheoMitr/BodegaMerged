package android.example.bodegaversionone.data

import android.example.bodegaversionone.models.Rating

data class MyDataItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)