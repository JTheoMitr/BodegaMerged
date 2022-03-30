package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // Adding onClickListener to submit Form Data
        btnFormSubmit.setOnClickListener {
            sendFormData()
        }

        }

    private fun sendFormData() {
        val intent = Intent(this, ConfirmationActivity::class.java)
        val firstName: String = editTextFirstName.text.toString()
        val lastName: String = editTextLastName.text.toString()
        val ticketBody: String = ticketBody.text.toString()
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("ticketBody", ticketBody)
        startActivity(intent)
    }
}