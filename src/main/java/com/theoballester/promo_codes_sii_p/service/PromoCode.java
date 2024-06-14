package com.theoballester.promo_codes_sii_p.service;

import java.util.Date;

public class PromoCode {
    private String name;
    private Date expDate;
    private float discount;
    private int usesLeft;
    private String currency;

    public PromoCode(String name, Date expDate, float discount, int usesLeft, String currency) {
        try {
            setName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.expDate = expDate;
        this.discount = discount;
        this.usesLeft = usesLeft;
        this.currency = currency;
    }

    public void use(){
        usesLeft-=1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length()>24) {
            throw new Exception("Invalid name: over 24 characters");
        }
        if(name.length()<3) {
            throw new Exception("Invalid name: under 3 characters");
        }
        else{
            this.name = name;
        }
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    public void setUsesLeft(int usesLeft) {
        if (usesLeft>0) {
            this.usesLeft = usesLeft;
        }
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "name='" + name + '\'' +
                ", expDate=" + expDate +
                ", discount=" + discount +
                ", usesLeft=" + usesLeft +
                ", currency='" + currency + '\'' +
                '}';
    }
}
