package com.me.scrollandgridview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.me.scrollandgridview.databinding.ActivityUpdateBinding


class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referencePhone = binding.referencePhone.text.toString()
            val updateName = binding.updateName.text.toString()

            val updateLocation = binding.updateLocation.text.toString()

            updateData(referencePhone,updateName,updateLocation)
        }
    }

    private fun updateData(phone: String, name: String, location: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "name" to name,
            "location" to location
        )

        database.child(phone).updateChildren(user).addOnSuccessListener {

            binding.referencePhone.text.clear()
            binding.updateName.text.clear()
            binding.updateLocation.text.clear()
            Toast.makeText(this,"Successfully Updated",Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()
        }}
}