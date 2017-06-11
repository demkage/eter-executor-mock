package com.eter.executor.mock.controller;

import com.eter.executor.mock.domain.*;
import com.eter.executor.mock.domain.recommendation.ProductRating;
import com.eter.executor.mock.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rusifer on 6/9/17.
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    private AnalysisService analysisService;

    @Autowired
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @RequestMapping("/als/{userId}/{productId}")
    public double alsForUserIdAndProductId(@PathVariable("userId") int userId,
                                           @PathVariable("productId") int productId) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return analysisService.predictForUserIdAndProductId("none", userId, productId);
    }

    @RequestMapping("/als/recommend/user/{userId}")
    public List<ProductRating> alsRecommendForUser(@PathVariable("userId") int userId) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return analysisService.recommendProductsForUser("none", userId, 5, false);
    }

    @RequestMapping("/als/recommend/user/{userId}/{num}")
    public List<ProductRating> alsRecommendForUser(@PathVariable("userId") int userId,
                                                   @PathVariable("num") int num) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return analysisService.recommendProductsForUser("none", userId, num, false);
    }

    @RequestMapping("/als/top/{num}")
    public List<ProductRating> topProducts(@PathVariable("num") int num) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return analysisService.topProducts("none", num, false);
    }

    @RequestMapping("/kmean/age/group/{age}")
    public double kmeanAgeGroupForAge(@PathVariable("age") int age) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictGroupForAge("none", age);
    }

    @RequestMapping(value = "/kmean/age/statistic", method = RequestMethod.POST)
    public GroupStatistic kmeanAgeStatistic(@RequestBody List<Integer> ages) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByAge("none", ages);
    }

    @RequestMapping(value = "/kmean/gender/statistic", method = RequestMethod.POST)
    public GroupStatistic kmeanGenderStatistic(@RequestBody List<String> genders) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByGender("none", genders);
    }

    @RequestMapping(value = "/sales", method = RequestMethod.POST)
    public List<SaleResult> salesAnalysis(@RequestBody List<SaleData> saleData) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictSales("none", saleData);
    }

    @RequestMapping(value = "/invetory", method = RequestMethod.POST)
    public List<InventoryResult> inventoryAnalysis(@RequestBody List<InventoryData> inventories) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictInventory("none", inventories, false);
    }
}