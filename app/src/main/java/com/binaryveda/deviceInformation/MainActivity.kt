package com.binaryveda.deviceInformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.binaryveda.deviceInformation.DeviceUtilsJava

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG_INFO", "Manufacturer : " + DeviceUtilsJava.getDeviceManufacturer())
        Log.d("TAG_INFO", "Model : " + DeviceUtilsJava.getDeviceModel())
        Log.d("TAG_INFO", "OS/SDK Version : " + DeviceUtilsJava.getOSVersion())
        Log.d("TAG_INFO", "OS Type : " + DeviceUtilsJava.getOSType())
        Log.d("TAG_INFO", "App Version : " + DeviceUtilsJava.getAppVersion())
        Log.d("TAG_INFO", "Screen Resolution : " + DeviceUtilsJava.getScreenResolution())
        Log.d("TAG_INFO", "Device Id : " + DeviceUtilsJava.getDeviceId(this))
        Log.d("TAG_INFO", "isDevice rooted : " + (RootChecker.isDeviceRooted()))

    }
}