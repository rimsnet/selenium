package com.viewQwest.app.enums;

public enum DataPlans {
    Gamer_Bundle_Monthly("1Gbps Raptor Gamer Bundle – Monthly"),
    Bundle_1GBMonthly("1Gbps Bundle - Monthly"),
    Bundle_1GBAnuual("1Gbps Bundle - Annual"),
    Bundle_2GBMonthly("2Gbps Bundle - Monthly"),
    Bundle_2GBAnnual("2Gbps Bundle - Annual")    ,
    New_OSP_24Months_2GBPS("2Gpbs Bundle - 24Months");

    private String plan;

    DataPlans(String plan) {
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }

    @Override
    public String toString() {
        return plan;
    }
}

