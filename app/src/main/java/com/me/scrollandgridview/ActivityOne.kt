package com.me.scrollandgridview

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        val txtInfo = findViewById<View>(R.id.txtInfo) as TextView
        if (intent != null) {
            val info = intent.getStringExtra("info")
            txtInfo.text = info
        }
    }
}