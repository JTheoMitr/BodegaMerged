package android.example.bodegaversionone.data

import android.example.bodegaversionone.models.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getData(): Call<List<Product>>
}