package com.eter.executor.mock.service.impl;

import com.eter.executor.mock.domain.*;
import com.eter.executor.mock.domain.recommendation.ProductRating;
import com.eter.executor.mock.service.AnalysisService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rusifer on 6/9/17.
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Override
    public double predictForUserIdAndProductId(int userId, int productId) {
        return 1.23;
    }

    @Override
    public List<ProductRating> recommendProductsForUser(int userId, int num) {
        List<ProductRating> productRatings = new ArrayList<>();

        for (int i = 0; i < num; ++i) {
            productRatings.add(new ProductRating(userId + i, i / num));
        }

        return productRatings;
    }

    @Override
    public List<ProductRating> topProducts(int num) {
        List<ProductRating> productRatings = new ArrayList<>();

        for (int i = 0; i < num; ++i) {
            productRatings.add(new ProductRating(i * 24, i / num));
        }
        return null;
    }

    @Override
    public double predictGroupForAge(int age) {
        return 2.0;
    }

    @Override
    public GroupStatistic predictStatisticsByAge(List<Integer> ages) {
        GroupStatistic groupStatistic = new GroupStatistic();
        groupStatistic.setGroupsCount(4);
        Map<String, Double> groups = new HashMap<>();
        Map<String, Double> centers = new HashMap<>();

        groups.put("0", 0.23684210526315788);
        groups.put("1", 0.2894736842105263);
        groups.put("2", 0.13157894736842105);
        groups.put("3", 0.34210526315789475);

        centers.put("0", 55.24603174603174);
        centers.put("1", 22.110726643598618);
        centers.put("2", 44.682403433476395);
        centers.put("3", 34.075221238938056);

        groupStatistic.setGroups(groups);
        groupStatistic.setCenters(centers);
        return groupStatistic;
    }

    @Override
    public GroupStatistic predictStatisticsByGender(List<String> genders) {
        GroupStatistic groupStatistic = new GroupStatistic();
        groupStatistic.setGroupsCount(2);
        Map<String, Double> groups = new HashMap<>();
        Map<String, Double> centers = new HashMap<>();

        groups.put("0", 0.5405405405405406);
        groups.put("1", 0.4594594594594595);

        centers.put("0", 0.0);
        centers.put("1", 1.0);

        groupStatistic.setGroups(groups);
        groupStatistic.setCenters(centers);
        return groupStatistic;
    }

    @Override
    public List<SaleResult> predictSales(List<SaleData> salesData) {
        List<SaleResult> saleResults = new ArrayList<>();

        Map<Integer, Double> sales = new HashMap<>();

        sales.put(12, 40.89814768841422);
        sales.put(21, 45.60185173361474);
        sales.put(11, 54.00000070815678);
        sales.put(30, 48.76641587895198);
        sales.put(15, 47.233584060331665);


        for (SaleData data : salesData) {
            Optional<Double> sale = Optional.ofNullable(sales.get(data.getDayOfMonth()));
            saleResults.add(new SaleResult(data.getDayOfWeek(), data.getDayOfMonth(), sale.orElse(23.344)));
        }

        return saleResults;
    }

    @Override
    public List<InventoryResult> predictInventory(List<InventoryData> inventoryData) {
        List<InventoryResult> inventoryResults = new ArrayList<>();

        Map<Integer, Double> scores = new HashMap<>();

        scores.put(1, 0.04);
        scores.put(4, 1.99);
        scores.put(365, 0.98);
        scores.put(255, 0.265);
        scores.put(125, 0.34);
        scores.put(23, 0.12);

        for(int i = 24; i < 125; ++i)
            scores.put(i, 1.0 - i);


        for (InventoryData data : inventoryData) {
            Optional<Double> score = Optional.ofNullable(scores.get(data.getLasSaleDayAgo()));
            inventoryResults.add(new InventoryResult(data.getProductId(), score.orElse(0.34)));
        }

        return inventoryResults;
    }
}
