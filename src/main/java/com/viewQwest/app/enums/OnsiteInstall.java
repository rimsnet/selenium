package com.viewQwest.app.enums;

public enum OnsiteInstall {
    PerTrip80("installationCharge_1_1Gbps"),
    PerTrip120("installationCharge_2_1Gbps"),
    PerTrip80Annual("installationCharge_2Gbps1"),
    PerTripFree("2gbps_1");

    private String installOnsite;

    public String getInstallOnsite() {
        return installOnsite;
    }

    public void setInstallOnsite(String installOnsite) {
        this.installOnsite = installOnsite;
    }

    OnsiteInstall(String installOnsite) {
        this.installOnsite = installOnsite;
    }
}
