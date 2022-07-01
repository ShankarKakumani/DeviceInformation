package com.binaryveda.deviceInformation.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;

import androidx.core.app.ActivityCompat;

import com.binaryveda.deviceInformation.BuildConfig;
import com.binaryveda.deviceInformation.model.DeviceInformation;
import com.binaryveda.deviceInformation.model.SimData;
import com.binaryveda.deviceInformation.model.SimDataList;

import java.util.ArrayList;
import java.util.List;

public class DeviceUtils {

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
        return new RootChecker().isDeviceRooted();
    }

    /**
     * Returns the consumer friendly device name
     */
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


    public List<SimData> getSimDatList(Context context) {
        SubscriptionManager sm = context.getSystemService(SubscriptionManager.class);
        ArrayList<SimData> simList = new ArrayList<>();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {

            List<SubscriptionInfo> list = sm.getActiveSubscriptionInfoList();
            for (int i = 0; i < list.size(); i++) {
                simList.add(parseSimCardInfo(list.get(i)));
            }

        }
        return simList;
    }

    private SimData parseSimCardInfo(SubscriptionInfo info) {
        return new SimData(
                info.getNumber(),
                info.getCarrierName().toString(),
                info.getSubscriptionId(),
                info.getIccId(),
                info.getSimSlotIndex(),
                info.getDisplayName().toString(),
                info.getDataRoaming(),
                info.getCountryIso()
        );
    }

    public DeviceInformation getDeviceInformation(Context context) {
        return new DeviceInformation(
                getDeviceManufacturer(),
                getDeviceModel(),
                getOSVersion(),
                getOSType(),
                getAppVersion(),
                getScreenResolution(),
                getDeviceId(context),
                isDeviceRooted(),
                getSimDatList(context)
        );

    }

}
