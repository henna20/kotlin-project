package com.me.scrollandgridview

import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class BatteryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery)
        // Declare button, that will show battery percentage when clicked
        val btn = findViewById<Button>(R.id.showBtn)

        btn.setOnClickListener{

            // Call battery manager service
            val bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager

            // Get the battery percentage and store it in a INT variable
            val batLevel:Int = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

            // Display the variable using a Toast
            Toast.makeText(applicationContext,"Battery is $batLevel%", Toast.LENGTH_LONG).show()
        }
    }
}