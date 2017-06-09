package com.eter.executor.mock.domain.recommendation;

import java.io.Serializable;

/**
 * Created by rusifer on 6/9/17.
 */
public class ProductRating implements Serializable {
    private int product;
    private double rating;

    public ProductRating() {
    }

    public ProductRating(int product, double rating) {
        this.product = product;
        this.rating = rating;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
