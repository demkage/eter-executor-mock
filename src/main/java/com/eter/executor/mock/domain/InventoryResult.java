package com.eter.executor.mock.domain;

import com.eter.executor.mock.domain.recommendation.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by abosii on 5/30/2017.
 */
public class InventoryResult implements Serializable {
    private long productId;
    private double score;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Product productDetail;

    public InventoryResult() {
    }

    public InventoryResult(long productId, double score) {
        this.productId = productId;
        this.score = score;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setProductDetail(Product productDetail) {
        this.productDetail = productDetail;
    }

    public Product getProductDetail() {
        return productDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryResult that = (InventoryResult) o;

        return getProductId() == that.getProductId();

    }

    @Override
    public int hashCode() {
        return (int) (getProductId() ^ (getProductId() >>> 32));
    }
}
