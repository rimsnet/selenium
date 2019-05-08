package com.viewQwest.app.enums;

public enum Promoters {
    CliffordZhang("Clifford Zhang"),
    HusainiAzmi("Husaini Azmi"),
    KartiniBteAriffin("Kartini Bte Ariffin"),
    KohZiliang("Koh Ziliang"),
    PearlyChow("Pearly Chow"),
    ShawnNorfor("Shawn Norfor"),
    TracyAnn("Tracy Ann"),
    Others("Others");

    private String promoter;

    public String getPromoter() {
        return promoter;
    }

    public void setPromoter(String promoter) {
        this.promoter = promoter;
    }

    Promoters(String promoter) {
        this.promoter = promoter;
    }
}
