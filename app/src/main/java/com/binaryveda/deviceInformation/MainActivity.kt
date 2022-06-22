package com.binaryveda.deviceInformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG_INFO", "Manufacturer : " + DeviceUtils.getDeviceManufacturer())
        Log.d("TAG_INFO", "Model : " + DeviceUtils.getDeviceModel())
        Log.d("TAG_INFO", "OS/SDK Version : " + DeviceUtils.getOSVersion())
        Log.d("TAG_INFO", "OS Type : " + DeviceUtils.getOSType())
        Log.d("TAG_INFO", "App Version : " + DeviceUtils.getAppVersion())
        Log.d("TAG_INFO", "Screen Resolution : " + DeviceUtils.getScreenResolution())
        Log.d("TAG_INFO", "Device Id : " + DeviceUtils.getDeviceId(this))
        Log.d("TAG_INFO", "isDevice rooted : " + (RootChecker.isDeviceRooted()))

    }
}