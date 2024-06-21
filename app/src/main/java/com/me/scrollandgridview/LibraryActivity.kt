package com.me.scrollandgridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.me.adapter.ItemAdapter
import com.me.data.DataSource

class LibraryActivity : AppCompatActivity() {
    val theData = DataSource().loadFacts()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerFacts)

        recyclerView.adapter = ItemAdapter(this, theData)
    }
}