package com.binaryveda.deviceInformation.model;

import java.util.ArrayList;

public class SimDataList {
    private ArrayList<SimData> simList;

    public SimDataList(ArrayList<SimData> simList) {
        this.simList = simList;
    }


    public ArrayList<SimData> getSimList() {
        return simList;
    }

    public void setSimList(ArrayList<SimData> simList) {
        this.simList = simList;
    }
}