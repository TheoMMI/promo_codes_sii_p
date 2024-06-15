package com.theoballester.promo_codes_sii_p.api.controller;

import com.theoballester.promo_codes_sii_p.api.model.Main;
import com.theoballester.promo_codes_sii_p.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SaleController {
    Main main = new Main();

    @PutMapping
    public void createProduct(@RequestParam String name, Float price, String currency){
        main.addProduct(name, price, currency);
    }

    @GetMapping
    public ArrayList<Product> getProducts(){
        return main.getProducts();
    }

    @PutMapping
    public void updateProduct(@RequestParam String name, float price, String currency, String desc){
        main.getProducts().

    }
}
