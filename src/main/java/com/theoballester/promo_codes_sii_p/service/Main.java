package com.theoballester.promo_codes_sii_p.service;

import com.theoballester.promo_codes_sii_p.api.model.Product;
import com.theoballester.promo_codes_sii_p.api.model.PromoCode;
import com.theoballester.promo_codes_sii_p.api.model.Sale;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Main {
    private ArrayList<PromoCode> promocodes = new ArrayList<PromoCode>();
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Sale> sales = new ArrayList<Sale>();

    public Main(){}

    public void addPromocode(String name, Date expDate, float discount, int usesLeft, String currency){
        promocodes.add(new PromoCode(name, expDate, discount, usesLeft, currency));
    }

    public void addPromocode(PromoCode promoCode){
        promocodes.add(promoCode);
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

    public ArrayList<PromoCode> getPromocodes() {
        return promocodes;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(String name, Float price, String currency){
        products.add(new Product(name, price, currency));
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public int getProduct(String name){
        int toReturn = Integer.MAX_VALUE;
        for(Product p: products){
            if(Objects.equals(p.getName(), name)){
                toReturn = products.indexOf(p);
                break;
            }
        }
        return toReturn;
    }

    public void addSale(Sale sale){
        sales.add(sale);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }


}
