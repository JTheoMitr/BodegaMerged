package android.example.bodegaversionone

import android.app.Activity
import android.content.Intent
import android.example.bodegaversionone.data.*
import android.example.bodegaversionone.models.Product
import android.example.bodegaversionone.models.Rating
import android.example.bodegaversionone.ui.CartActivity
import android.example.bodegaversionone.ui.LoginActivity
import android.example.bodegaversionone.ui.NewItemActivity
import android.example.bodegaversionone.ui.ProfileActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels


import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://fakestoreapi.com/"



class MainActivity : AppCompatActivity() {

    private lateinit var aut : FirebaseAuth
    lateinit var myAdapter: ProductAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    private val newItemActivityRequestCode = 1

    // DEREK's CODE
    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ItemApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // John's code for firebase authorization
        aut = FirebaseAuth.getInstance()

        // Just added to get recycler view working for Room with a View
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_products)
        val response : List<Product> = emptyList()
        val adapter = ProductAdapter(baseContext, response)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerview_products.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_products.layoutManager = linearLayoutManager

        getMyData()


        // observer for data changes with LiveData
        itemViewModel.allItems.observe(this, Observer {
                items -> items?.let {
            //adapter.submitList(items)
        }
        })

        // sets up button for adding new items
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // John's code for Crashlytics
        // Creates a button that mimics a crash when pressed

//        val crashButton = Button(this)
//        crashButton.text = "Test Crash"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newItemActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewItemActivity.EXTRA_REPLY)?.let { reply ->
                val item = Product("", "", 0, "", 0.0, Rating(0, 0.0), reply)
                itemViewModel.insert(item)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }


    // John's Code for RETROFIT
    private fun getMyData() {

        progressBar.visibility = View.VISIBLE

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Product>?> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = ProductAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_products.adapter = myAdapter
                progressBar.visibility = View.GONE


            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }

    //JOHNS CODE FOR MENU OPTIONS
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.SignOut) {
            aut.signOut()
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
            finish()
        } else if (item.itemId == R.id.UserProfile) {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }





}