package com.delvin.uywalkyp

import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var mMap:GoogleMap?=null

    private lateinit var currentLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val permissionCode=101

    private var markerIcon: BitmapDescriptor?=null
    private var markerWalker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)

        markerIcon = getMarkerFromDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.iconwalker)!!)



        getCurrentLocationUser()
    }

    private fun getCurrentLocationUser() {
        if(ActivityCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),permissionCode)
            return
        }

        val getLocation=fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                location ->
            if (location != null){
                currentLocation=location
                Toast.makeText(applicationContext,currentLocation.latitude.toString()+" "+
                        currentLocation.longitude.toString(),Toast.LENGTH_LONG).show()

                val mapFragment=supportFragmentManager
                    .findFragmentById(R.id.map) as SupportMapFragment
                mapFragment.getMapAsync(this)

            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            permissionCode -> if(grantResults.isNotEmpty() && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED){
                getCurrentLocationUser()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap=googleMap
        mMap?.uiSettings?.isZoomControlsEnabled=true
        createMarker()
        mapStyle()
        /*googleMap?.isMyLocationEnabled=false
        googleMap?.isBuildingsEnabled=false*/
    }

    private fun createMarker(){
        val coordinates=LatLng(currentLocation.latitude,currentLocation.longitude)
        val marker=MarkerOptions().position(coordinates).title("Ubicacion actual")
        markerWalker?.remove()
        markerWalker=mMap?.addMarker(MarkerOptions().position(coordinates).anchor(0.5f,0.5f).flat(true).icon(markerIcon))
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates,17f))
    }

    private fun mapStyle(){
        try{
            val success = mMap?.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(this,R.raw.style)
            )
            if (!success!!){
                Log.d("MAPAS", "No se pudo encontrar el estilo")
            }
        }catch (e: Resources.NotFoundException){
            Log.d("MAPAS", "Error: ${e.toString()}")

        }
    }


    private fun addMarker(){
        val coordinates=LatLng(currentLocation.latitude,currentLocation.longitude)
        val drawable=ContextCompat.getDrawable(applicationContext,R.drawable.iconwalker)
        val markerIcon=getMarkerFromDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.iconwalker)!!)


        if (markerWalker == null) {
            markerWalker = mMap?.addMarker(
                MarkerOptions()
                    .position(coordinates)
                    .anchor(0.5f, 0.5f)
                    .flat(true)
                    .icon(markerIcon)
            )
        }

    }

    private fun getMarkerFromDrawable(drawable: Drawable): BitmapDescriptor {
        val canvas = Canvas()
        val bitmap = Bitmap.createBitmap(
            70,
            70,
            Bitmap.Config.ARGB_8888
        )
        canvas.setBitmap(bitmap)
        drawable.setBounds(0,0,70,70)
        drawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }



}