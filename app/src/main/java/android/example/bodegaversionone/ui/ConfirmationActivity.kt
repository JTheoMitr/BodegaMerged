package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val ticketBody = intent.getStringExtra("ticketBody")
        ticketText.text = lastName + ", " + firstName + ": "  + ticketBody

        val ticket = hashMapOf(
            "first" to firstName,
            "last" to lastName,
            "ticket" to ticketBody
        )

        // Add a new document with a generated ID
        db.collection("tickets")
            .add(ticket)
            .addOnSuccessListener { documentReference ->
                Log.d("db", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("db", "Error adding document", e)
            }

        btnAccount.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

}