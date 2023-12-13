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