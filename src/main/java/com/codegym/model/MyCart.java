package com.codegym.model;

import java.util.ArrayList;

public class MyCart {
    private ArrayList<Product> productCart = new ArrayList<>();

    public MyCart() {
    }

    public MyCart(ArrayList<Product> productCart) {
        this.productCart = productCart;
    }

    public Iterable<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(ArrayList<Product> productCart) {
        this.productCart = productCart;
    }

    public void addToCart(Product product) {
        productCart.add(product);
    }
}
