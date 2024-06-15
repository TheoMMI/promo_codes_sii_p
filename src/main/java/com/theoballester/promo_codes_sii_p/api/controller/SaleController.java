package com.theoballester.promo_codes_sii_p.api.controller;

import com.theoballester.promo_codes_sii_p.service.Main;
import com.theoballester.promo_codes_sii_p.api.model.Product;
import com.theoballester.promo_codes_sii_p.api.model.PromoCode;
import com.theoballester.promo_codes_sii_p.api.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@RestController
public class SaleController {

    private Main main;

    @Autowired
    public SaleController(Main main){
        this.main = main;
    }

    @PostMapping("/product")
    public void createProduct(@RequestParam String name, Float price, String currency){
        main.addProduct(name, price, currency);
    }

    @GetMapping("/products")
    public ArrayList<Product> getProducts(){
        return main.getProducts();
    }

    @PutMapping("/product")
    public void updateProduct(@RequestParam String name, float price, String currency, String desc) throws Exception {
        int index = Integer.MAX_VALUE;
        index = main.getProduct(name);
        if (index == Integer.MAX_VALUE){
            throw new Exception("Product was not found");
        }
        main.getProducts().get(index).setCurrency(currency);
        main.getProducts().get(index).setPrice(price);
        main.getProducts().get(index).setDesc(desc);
    }

    @PostMapping("/promocode")
    public void createPromoCode(@RequestParam String name, Date expDate, float discount, int usesLeft, String currency){
        main.addPromocode(new PromoCode(name , expDate, discount, usesLeft, currency));
    }

    @GetMapping("/promocodes")
    public ArrayList<PromoCode> getPromocodes(){
        return main.getPromocodes();
    }

    @GetMapping("/promocode")
    public String getPromocode(@RequestParam String name){
        return main.getPromocode(name).toString();
    }

    @GetMapping("/discount")
    public float getDiscountPrice(Product product, PromoCode promoCode){
        float price = 0.0f;
        Sale sale = null;
        if(main.getProducts().contains(product)){
            if(main.getPromocodes().contains(promoCode)) {
                if (Objects.equals(product.getCurrency(), promoCode.getCurrency())) {
                    sale = new Sale(product.getCurrency(), product, promoCode);
                }
                else{
                    // Throw a ResponseStatusException with a 400 status
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Currencies do not match");
                }
            }
            else {
                // Throw a ResponseStatusException with a 404 status
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Promo Code not found");
            }
        }
        else {
            // Throw a ResponseStatusException with a 404 status
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        price = sale.getTotalDscnt();
        return price;
    }

    @PutMapping("/purchase")
    public void purchase(Product product, PromoCode promoCode){
        Sale sale = null;
        if (main.getProducts().contains(product)) {
            if (main.getPromocodes().contains(promoCode)){
                if(Objects.equals(product.getCurrency(), promoCode.getCurrency())) {
                    sale = new Sale(product.getCurrency(), product, promoCode);
                }
            }
            else {
                // Throw a ResponseStatusException with a 404 status
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Promo Code not found");
            }
        }
        else {
            // Throw a ResponseStatusException with a 404 status
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        if (sale != null) {
            sale.sold();
            main.addSale(sale);
        }
    }

    public void purchase(Product product){
        Sale sale = null;
        if(main.getProducts().contains(product)){
            sale = new Sale(product.getCurrency(), product);
        }
        sale.sold();
        main.addSale(sale);
    }
}
