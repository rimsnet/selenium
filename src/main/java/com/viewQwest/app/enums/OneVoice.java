package com.viewQwest.app.enums;

public enum OneVoice {
    MonthlySubscription("oneVoice_Monthly"),
    AnnualSubscription("oneVoice_Annual"),
    MonthlyNumberNonDisplay("numNonDisplay"),
    AnnualNumberNonDisplay("numNonDisplay"),
    NoThanks("noThanks");

    private String oneVoiceType;

    public String getOneVoiceType() {
        return oneVoiceType;
    }

    public void setOneVoiceType(String oneVoiceType) {
        this.oneVoiceType = oneVoiceType;
    }

    OneVoice(String oneVoiceType) {
        this.oneVoiceType = oneVoiceType;
    }
}