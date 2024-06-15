package com.theoballester.promo_codes_sii_p.api.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class PromoCode {
    private String name;
    private LocalDate expDate;
    private float discount;
    private int usesLeft;
    private String currency;

    public PromoCode(String name, LocalDate expDate, float discount, int usesLeft, String currency) {
        try {
            setName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.expDate = expDate;
        this.setDiscount(discount);
        this.setUsesLeft(usesLeft);
        this.setCurrency(currency);
    }

    public void use(){
        if (usesLeft>0) {
            usesLeft--;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.length()>24) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Promo code name is too long (>24 characters)");
        }
        if(name.length()<3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Promo code name is too short (<3 characters)");
        }
        else{
            this.name = name.toUpperCase();
        }
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
    public void setExpDate(int d,int m,int y) {

        this.expDate = LocalDate.of(y,m,d);
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    public void setUsesLeft(int usesLeft) {
        if (usesLeft>0) {
            this.usesLeft = usesLeft;
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number of uses cannot be negative");
        }
    }

    public float getDiscount() {
        usesCheck();
        if (expDate.isAfter(LocalDate.now())) {
            return discount;
        }
        else{
            return 0.0f;
        }
    }

    public void setDiscount(float discount) {
        if (discount>=0.0f) {
            if (discount<=100.0f) {
                this.discount = discount;
                System.out.println(discount);
            }
            else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Discount cannot be over a 100%");
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Discount cannot be negative");
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency.toUpperCase();
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

    private void usesCheck(){
        if(usesLeft<=0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Promo code has exhausted it's number of uses");
        }
    }

}
