package com.viewQwest.app.enums;

public enum Netflix {
    NETFLIX_USA("netflixUSA"),
    NETFLIX_Singapore("netflixSG");

    private String countryOfNetflix;

    public String getCountryOfNetflix() {
        return countryOfNetflix;
    }

    public void setCountryOfNetflix(String countryOfNetflix) {
        this.countryOfNetflix = countryOfNetflix;
    }

    Netflix(String countryOfNetflix) {
        this.countryOfNetflix = countryOfNetflix;
    }
}