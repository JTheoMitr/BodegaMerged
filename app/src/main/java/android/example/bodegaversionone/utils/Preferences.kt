package android.example.bodegaversionone.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context : Context) {

    private val cart : String = "CART_PREFS"
    private val preferences : SharedPreferences = context.getSharedPreferences(cart, Context.MODE_PRIVATE)

    val editor : SharedPreferences.Editor = preferences.edit()

    public fun getList(): MutableSet<String>? = preferences.getStringSet(cart, null)
    public fun setList(value : MutableSet<String>?) {
        editor.putStringSet(cart, value)
        editor.apply()
    }
}