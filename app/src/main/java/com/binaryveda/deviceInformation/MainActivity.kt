package com.binaryveda.deviceInformation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.binaryveda.deviceInformation.model.DeviceInformation
import com.binaryveda.deviceInformation.utils.DeviceUtils
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private val permissionContract =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if(it) {
                writeDataToFirebase()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(havePermission(Manifest.permission.READ_PHONE_STATE)) {
            database = Firebase.database.reference
            writeDataToFirebase()
        } else {
            permissionContract.launch(Manifest.permission.READ_PHONE_STATE)
        }

    }

    private fun writeDataToFirebase() {
        val deviceInformation = DeviceUtils().getDeviceInformation(this)
        database.child("users").child(deviceInformation.deviceId).setValue(deviceInformation)
            .addOnFailureListener {
                Toast.makeText(this, "Failed to update data in Firebase - ${it.message}", Toast.LENGTH_LONG).show()
            }.addOnSuccessListener {
            Toast.makeText(this, "Data written to Firebase", Toast.LENGTH_LONG).show()
        }
        findViewById<TextView>(R.id.textView).text = Gson().toJson(deviceInformation)
    }

    fun Context.havePermission(permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }
}