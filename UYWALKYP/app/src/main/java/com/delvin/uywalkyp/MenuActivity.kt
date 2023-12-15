package com.delvin.uywalkyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        OpenMap()
        OpenProfile()
        showNameMenu()


        val btnCerrarSesion = findViewById<LinearLayout>(R.id.logoutIcon)
        btnCerrarSesion.setOnClickListener {
            cerrarSesion()
        }
    }

    private fun showNameMenu(){
        val extras = intent.extras
        if (extras != null) {
            val nombre = extras.getString("nombre")?.capitalize()
            val apellido = extras.getString("apellido")?.capitalize()

            val nombreCompleto = "$nombre $apellido"

            val txtName = findViewById<TextView>(R.id.txtNombre)
            txtName.text = nombreCompleto
        }
    }
    private fun cerrarSesion() {
        val sharedPref = getSharedPreferences("login_info", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()

        // Luego, redirigir a MainActivity
        val intent = Intent(this@MenuActivity, MainActivity::class.java)
        startActivity(intent)
        finish() // Cierra MenuActivity para que no vuelva atrás
    }

    private fun OpenMap(){
        val txtMap = findViewById<LinearLayout>(R.id.MapIcon)
        txtMap.setOnClickListener{
            val intent=Intent(this@MenuActivity,MapActivity::class.java)
            startActivity(intent)
        }
    }

    private fun OpenProfile(){
        val txtProfile = findViewById<LinearLayout>(R.id.ProfileIcon)
        txtProfile.setOnClickListener {
            val intent=Intent(this@MenuActivity,RegisterPaseadorActivity::class.java)
            startActivity(intent)
        }
    }
}