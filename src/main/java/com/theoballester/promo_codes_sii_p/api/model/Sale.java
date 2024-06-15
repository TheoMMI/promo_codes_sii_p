package com.theoballester.promo_codes_sii_p.api.model;

public class Sale {
    String currency;
    float totalAmnt;
    float totalDscnt;
    int nbPurchases;

    public Sale(String currency, float totalAmnt, float totalDscnt, int nbPurchases) {
        this.currency = currency;
        this.totalAmnt = totalAmnt;
        this.totalDscnt = totalDscnt;
        this.nbPurchases = nbPurchases;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getTotalAmnt() {
        return totalAmnt;
    }

    public void setTotalAmnt(float totalAmnt) {
        this.totalAmnt = totalAmnt;
    }

    public float getTotalDscnt() {
        return totalDscnt;
    }

    public void setTotalDscnt(float totalDscnt) {
        this.totalDscnt = totalDscnt;
    }

    public int getNbPurchases() {
        return nbPurchases;
    }

    public void setNbPurchases(int nbPurchases) {
        this.nbPurchases = nbPurchases;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "currency='" + currency + '\'' +
                ", totalAmnt=" + totalAmnt +
                ", totalDscnt=" + totalDscnt +
                ", nbPurchases=" + nbPurchases +
                '}';
    }
}
