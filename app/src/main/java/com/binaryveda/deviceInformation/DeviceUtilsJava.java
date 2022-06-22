package com.binaryveda.deviceInformation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

public class DeviceUtilsJava {

    public String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getOSType() {
        return "Android";
    }

    public String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public String getScreenResolution() {
        return getScreenWidth() + " W X " + getScreenHeight() + " H";
    }

    public String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public Boolean isDeviceRooted() {
        return RootChecker.INSTANCE.isDeviceRooted();
    }

    /** Returns the consumer friendly device name */
    public String getDeviceManufacturerWithModel() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }



}
