package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser!!.email.toString()
        welcomeText.text = "Welcome, ${currentUser}"

    }

    //JOHNS CODE FOR MENU OPTIONS
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.SignOut) {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java )
            startActivity(intent)
            finish()
        } else if (item.itemId == R.id.EditProfile) {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}