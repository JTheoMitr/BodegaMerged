package android.example.bodegaversionone.data

import android.example.bodegaversionone.data.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getData(): Call<List<MyDataItem>>
}