package com.binaryveda.deviceInformation

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binaryveda.deviceInformation.model.DeviceInformation
import com.binaryveda.deviceInformation.utils.DeviceUtils
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference
        writeDataToFirebase(DeviceUtils().getDeviceInformation(this))
    }

    private fun writeDataToFirebase(deviceInformation: DeviceInformation) {
        database.child("users").child(deviceInformation.deviceId).setValue(deviceInformation)
            .addOnFailureListener {
                Toast.makeText(this, "Failed to update data in Firebase - ${it.message}", Toast.LENGTH_LONG).show()
            }.addOnSuccessListener {
            Toast.makeText(this, "Data written to Firebase", Toast.LENGTH_LONG).show()
        }
        findViewById<TextView>(R.id.textView).text = Gson().toJson(deviceInformation)
    }
}