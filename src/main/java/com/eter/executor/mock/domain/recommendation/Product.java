package com.eter.executor.mock.domain.recommendation;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by rusifer on 6/11/17.
 */
public class Product {
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;
    private Double price;
    private Integer stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
