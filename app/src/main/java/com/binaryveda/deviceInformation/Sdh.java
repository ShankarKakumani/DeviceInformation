package com.binaryveda.deviceInformation;

import android.content.Context;

import com.google.gson.Gson;

public class Sdh {

    public static void main(String[] args) {
        DeviceUtils a = new DeviceUtils();
        a.getDeviceManufacturer();
    }

    public String getDeviceInformation(Context context) {
        DeviceUtils obj = new DeviceUtils();

        DeviceInformation info =  new DeviceInformation(
                obj.getDeviceManufacturer(),
                obj.getAppVersion(),
                obj.getOSVersion(),
                obj.getOSType(),
                obj.getAppVersion(),
                obj.getScreenResolution(),
                obj.getDeviceId(context),
                obj.isDeviceRooted()
        );

        return new Gson().toJson(info);
    }
}
