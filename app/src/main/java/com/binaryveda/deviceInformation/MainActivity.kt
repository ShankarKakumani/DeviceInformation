package com.binaryveda.deviceInformation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val utils = DeviceUtils()
        Log.d("TAG_INFO", "Manufacturer : " + utils.deviceManufacturer)
        Log.d("TAG_INFO", "Model : " + utils.deviceModel)
        Log.d("TAG_INFO", "OS/SDK Version : " + utils.osVersion)
        Log.d("TAG_INFO", "OS Type : " + utils.osType)
        Log.d("TAG_INFO", "App Version : " + utils.appVersion)
        Log.d("TAG_INFO", "Screen Resolution : " + utils.screenResolution)
        Log.d("TAG_INFO", "Device Id : " + utils.getDeviceId(this))
        Log.d("TAG_INFO", "isDevice rooted : " + (RootChecker().isDeviceRooted))

    }
}