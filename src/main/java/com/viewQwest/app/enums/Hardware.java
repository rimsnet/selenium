package com.viewQwest.app.enums;

public enum Hardware {
    NETGEAR_R6220_Router("R6220"),
    NETGEAR_Orbi_RBK40 ("RBK40"),
    NETGEAR_Nighthawk_X4S("X4S Smart Wi-Fi"),
    NETGEAR_Nighthawk_X8("X8 Tri-band Wi-Fi"),
    NETGEAR_Nighthawk_XR500("XR500");

    private String hardware;

    Hardware(String hardware) {
        this.hardware = hardware;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }
}
