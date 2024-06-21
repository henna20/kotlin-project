package com.me.scrollandgridview


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.me.scrollandgridview.databinding.ActivityContactBinding


class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainUpload.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@ContactActivity, UploadActivity::class.java)
            startActivity(intent)
            finish()
        })

        binding.mainUpdate.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@ContactActivity, UpdateActivity::class.java)
            startActivity(intent)
        })

        binding.mainDelete.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@ContactActivity, DeleteActivity::class.java)
            startActivity(intent)
        })

    }
}