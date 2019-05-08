package com.viewQwest.app.enums;

public enum TypesOfInitials {
    Mr("Mr."),
    Ms("Ms."),
    Mrs("Mrs."),
    Dr("Dr."),
    Prof("Prof.");

    private String initialType;

    TypesOfInitials(String initialType) {
        this.initialType = initialType;
    }

    public String getInitialType() {
        return initialType;
    }

    public void setInitialType(String initialType) {
        this.initialType = initialType;
    }
}
