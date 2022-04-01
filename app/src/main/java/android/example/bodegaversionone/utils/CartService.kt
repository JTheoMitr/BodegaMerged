package android.example.bodegaversionone.utils

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CartService : Service() {

    private val binder = LocalBinder()

    private val cartTitles : MutableList<String> = mutableListOf()

    inner class LocalBinder : Binder() {
        fun getService() : CartService = this@CartService
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun getTitles(): MutableList<String> {
        return cartTitles
    }

    fun addTitle(title : String) {
        cartTitles.add(title)
    }

}