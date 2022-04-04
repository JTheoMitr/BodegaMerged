package android.example.bodegaversionone.ui

import android.content.Intent
import android.example.bodegaversionone.R
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
//import com.google.maps.GeoApiContext
//import com.google.maps.GeocodingApi
import kotlinx.android.synthetic.main.activity_payment.*
import java.util.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


    }


        fun thankYou(view: View) {
            val thanksIntent = Intent(this, ThankYouActivity::class.java)
            startActivity(thanksIntent)
       }
   }




