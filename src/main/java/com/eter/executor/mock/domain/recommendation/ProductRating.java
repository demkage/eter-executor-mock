package com.eter.executor.mock.domain.recommendation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by rusifer on 5/14/17.
 */
public class ProductRating implements Serializable {
    private int product;
    private double rating;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Product productDetail;

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

    public Product getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Product productDetail) {
        this.productDetail = productDetail;
    }
}
