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
        val currentUserEmail = auth.currentUser!!.email.toString()
        welcomeText.text = currentUserEmail

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

    // John's Code for PASSWORD RESET

//    val email = "example@gmail.com"
//    val password = "demoPassword"
//    FirebaseAuth.getInstance().setLanguageCode("en") // Set to English
//    FirebaseAuth.getInstance()
//    .sendPasswordResetEmail(email)
//    .addOnCompleteListener(this, { task: Task<AuthResult> ->
//        // Receive response from Firebase Console
//    })
//    .addOnSuccessListener(this, { authResult: AuthResult? ->
//        // Reset password email has been successfully sent to the email
//    })
//    .addOnFailureListener(this, { exception: Exception ->
//        // Reset password request is failed with an exception
//    })
}