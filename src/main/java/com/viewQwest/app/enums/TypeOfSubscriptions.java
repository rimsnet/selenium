package com.viewQwest.app.enums;

public enum TypeOfSubscriptions {
    NewSubscriber("indexButtonOptionText1"),
    ExistingSubscriberReContract("indexButtonOptionText2");


    private String subscriptionsType;


    TypeOfSubscriptions(String subscriptionsType) {
        this.subscriptionsType = subscriptionsType;
    }

    public String getSubscriptionsType() {
        return subscriptionsType;
    }

    public void setSubscriptionsType(String subscriptionsType) {
        this.subscriptionsType = subscriptionsType;
    }
}
