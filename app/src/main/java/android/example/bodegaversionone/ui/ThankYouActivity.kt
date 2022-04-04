package android.example.bodegaversionone.ui

import android.example.bodegaversionone.R
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.GeoPoint

import kotlinx.android.synthetic.main.activity_payment.*
import java.io.IOException


class ThankYouActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }





    //sets location based off lat and long and adds marker

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val zoomLevel= 15f

        /* converts address to lat and long
        val addressForLatlong= editTextTextPostalAddress.text.toString()
        val geo= GeoApiContext.Builder().apiKey("AIzaSyDfJYsvnjGawBkwEIp8v172xYf866jNYs8").build()
        val latlngResults = GeocodingApi.geocode(geo, addressForLatlong).await()
        val homeAddress = (latlngResults[0].geometry.location)
        */


        // Add a marker at home and move the camera
        val homeAddress= LatLng( 32.7767, -96.7970)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeAddress, zoomLevel))
        map.addMarker(MarkerOptions().position(homeAddress).title("your delivery"))

        setPoiClick(map)



    }





    //shows info for buildings and landmarks on map
    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(MarkerOptions().position(poi.latLng).title(poi.name))
            poiMarker?.showInfoWindow()
        }
    }



}