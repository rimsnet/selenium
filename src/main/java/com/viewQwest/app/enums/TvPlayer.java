package com.viewQwest.app.enums;

public enum TvPlayer {
    Player118("mediaPlayer");

    private String player;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    TvPlayer(String player) {
        this.player = player;
    }
}
