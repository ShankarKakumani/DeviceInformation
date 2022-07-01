package com.binaryveda.deviceInformation.model;

public class SimData {
    private String mobileNumber;
    private String carrierName;
    private Integer subscriptionId;
    private String iccId;
    private Integer simSlotIndex;
    private String displayName;
    private Integer dataRoaming;
    private String countryISO;

    public SimData(
            String mobileNumber,
            String carrierName,
            Integer subscriptionId,
            String iccId,
            Integer simSlotIndex,
            String displayName,
            Integer dataRoaming,
            String countryISO
    ) {
        this.mobileNumber = mobileNumber;
        this.carrierName = carrierName;
        this.subscriptionId = subscriptionId;
        this.iccId = iccId;
        this.simSlotIndex = simSlotIndex;
        this.displayName = displayName;
        this.dataRoaming = dataRoaming;
        this.countryISO = countryISO;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getIccId() {
        return iccId;
    }

    public void setIccId(String iccId) {
        this.iccId = iccId;
    }

    public Integer getSimSlotIndex() {
        return simSlotIndex;
    }

    public void setSimSlotIndex(Integer simSlotIndex) {
        this.simSlotIndex = simSlotIndex;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getDataRoaming() {
        return dataRoaming;
    }

    public void setDataRoaming(Integer dataRoaming) {
        this.dataRoaming = dataRoaming;
    }

    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }
}