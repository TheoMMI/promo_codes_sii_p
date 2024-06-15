package com.theoballester.promo_codes_sii_p.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Main {
    private ArrayList<PromoCode> promocodes = new ArrayList<PromoCode>();
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Sale> Sales = new ArrayList<Sale>();

    public void addPromocode(String name, Date expDate, float discount, int usesLeft, String currency){
        promocodes.add(new PromoCode(name, expDate, discount, usesLeft, currency));
    }

    public PromoCode getPromocode(String name){
        boolean exists;
        PromoCode thePromocode = null;
        for(PromoCode p: promocodes){
            if (Objects.equals(p.getName(), name)){
                exists=true;
                thePromocode = p;
                break;
            }
        }
        return thePromocode;
    }

    public void applyCode(PromoCode pc, Product pd, Sale s){
        if (Objects.equals(pc.getCurrency(), pd.getCurrency())){

        }
    }

    public ArrayList<PromoCode> getPromocodes() {
        return promocodes;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Sale> getSales() {
        return Sales;
    }
}
