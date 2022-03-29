package android.example.bodegaversionone

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle


class SearchResultsActivity:Activity (){

    //Searches for item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(intent)
    }
    override fun onNewIntent(intent:Intent){
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH== intent.action){
            val query= intent.getStringExtra(SearchManager.QUERY)
            //uses query to search data
        }
    }

}