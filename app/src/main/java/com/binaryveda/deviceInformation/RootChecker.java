package com.binaryveda.deviceInformation;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class RootChecker {

    public Boolean isDeviceRooted() {
        return checkRootMethodOne() && checkRootMethodTwo();
    }

    public Boolean checkRootMethodOne() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    public Boolean checkRootMethodTwo() {
        List<String> list = Arrays.asList(
                "/system/app/Superuser.apk",
                "/sbin/su",
                "/system/bin/su",
                "/system/xbin/su",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su",
                "/su/bin/su"
        );

        for (int i = 0; i <= list.size(); i++) {
            if (new File(list.get(i)).exists()) return true;
        }
        return false;

    }

}
