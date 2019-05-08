package com.viewQwest.app.enums;

public enum ReferenceNames {
    Google("Google"),
    WordOfMouth("Word of Mouth"),
    RetailOutlets("Retail Outlets"),
    Facebook("Facebook"),
    Web("Web"),
    Brochure("Brochure"),
    Tradeshow("Tradeshow"),
    Others("Others");

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    ReferenceNames(String reference) {
        this.reference = reference;
    }
}
