package com.theoballester.promo_codes_sii_p.api.model;

import java.util.ArrayList;
import java.util.Objects;

public class Sale {
    private String currency;
    private float totalAmnt;
    private float totalDscnt;
    private ArrayList<Product> products = new ArrayList<Product>();
    private PromoCode promoCode;
    private boolean notSold = true;

    public Sale(String currency, Product product) {
        this.currency = currency;
        this.totalAmnt = product.getPrice();
        products.add(product);
    }
    public Sale(String currency, ArrayList<Product> products) {
        this.currency = currency;
        for(Product p: products){
            this.totalAmnt += p.getPrice();
        }
        this.products.addAll(products);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if(notSold) {this.currency = currency;}
    }

    public float getTotalAmnt() {
        return totalAmnt;
    }

    public void setTotalAmnt(float totalAmnt) {
        if(notSold) {this.totalAmnt = totalAmnt;}
    }

    public float getTotalDscnt() {
        return totalDscnt;
    }

    public void setTotalDscnt(float totalDscnt) {
        if(notSold) {this.totalDscnt = totalDscnt;}
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if(notSold) {
            this.products.add(product);
        }
    }

    public PromoCode getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromoCode promoCode){
        if(notSold){
            this.promoCode = promoCode;
        }
    }

    public void calcTotalAmnt(){
        if (Objects.isNull(promoCode)){
            throw new NullPointerException("there is no promo code to apply");
        }
        float price = 0.0f;
        for(Product p: products){
            price+=p.getPrice();
        }
        totalAmnt = price;
        price *= (100.0f - promoCode.getDiscount());
        price /= 100.0f;
        totalDscnt = price;
    }

    public float getTotalPrice(){
        calcTotalAmnt();
        return totalDscnt;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "currency='" + currency + '\'' +
                ", totalAmnt=" + totalAmnt +
                ", totalDscnt=" + totalDscnt +
                '}';
    }
}
