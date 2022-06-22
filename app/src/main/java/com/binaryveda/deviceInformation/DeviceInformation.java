package com.binaryveda.deviceInformation;

public class DeviceInformation {
    String deviceManufacturer;
    String deviceModel;
    int osVersion;
    String osType;
    String appVersion;
    String screenResolution;
    String deviceId;
    Boolean isDeviceRooted;

    public DeviceInformation(
            String deviceManufacturer,
            String deviceModel,
            int osVersion,
            String osType,
            String appVersion,
            String screenResolution,
            String deviceId,
            Boolean isDeviceRooted
    ) {
        this.deviceManufacturer = deviceManufacturer;
        this.deviceModel = deviceModel;
        this.osVersion = osVersion;
        this.osType = osType;
        this.appVersion = appVersion;
        this.screenResolution = screenResolution;
        this.deviceId = deviceId;
        this.isDeviceRooted = isDeviceRooted;
    }

    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public int getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(int osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getIsDeviceRooted() {
        return isDeviceRooted;
    }

    public void setIsDeviceRooted(Boolean isDeviceRooted) {
        this.isDeviceRooted = isDeviceRooted;
    }
}

