package com.eter.executor.mock.service;


import com.eter.executor.mock.domain.*;
import com.eter.executor.mock.domain.recommendation.ProductRating;

import java.util.List;

/**
 * Created by rusifer on 5/13/17.
 */
public interface AnalysisService {
    double predictForUserIdAndProductId(String customer, int userId, int productId);

    List<ProductRating> recommendProductsForUser(String customer, int userId, int num, boolean detailed);

    List<ProductRating> topProducts(String customer, int num, boolean detailed);

    double predictGroupForAge(String customer, int age);

    GroupStatistic predictStatisticsByAge(String customer);

    GroupStatistic predictStatisticsByAge(String customer, List<Integer> ages);

    GroupStatistic predictStatisticsByGender(String customer);

    GroupStatistic predictStatisticsByGender(String customer, List<String> genders);

    List<SaleResult> predictSales(String customer, List<SaleData> salesData);

    List<InventoryResult> predictInventory(String customer, List<InventoryData> inventoryData, boolean detailed);
}
