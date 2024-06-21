package com.me.scrollandgridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        var data = intent.getStringExtra("name");
        Log.e("TAG", "data ===>  $data");
    }
}