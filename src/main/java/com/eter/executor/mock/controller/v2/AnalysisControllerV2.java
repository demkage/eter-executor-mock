package com.eter.executor.mock.controller.v2;


import com.eter.executor.mock.domain.*;
import com.eter.executor.mock.domain.recommendation.ProductRating;
import com.eter.executor.mock.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rusifer on 6/10/17.
 */
@RestController
@RequestMapping("/v2/customer/{customer}/")
public class AnalysisControllerV2 {
    private AnalysisService analysisService;

    @Autowired
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @RequestMapping("/rating/user/{userId}/product/{productId}")
    public double alsForUserIdAndProductId(@PathVariable("customer") String customer,
                                           @PathVariable("userId") int userId,
                                           @PathVariable("productId") int productId) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictForUserIdAndProductId(customer, userId, productId);
    }

    @RequestMapping("/recommend/user/{userId}")
    public List<ProductRating> alsRecommendForUser(@PathVariable("customer") String customer,
                                                   @PathVariable("userId") int userId) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.recommendProductsForUser(customer, userId, 5, false);
    }

    @RequestMapping("/recommend/user/{userId}/detailed")
    public List<ProductRating> detailedAlsRecommendForUser(@PathVariable("customer") String customer,
                                                           @PathVariable("userId") int userId) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.recommendProductsForUser(customer, userId, 5, true);
    }

    @RequestMapping("/recommend/user/{userId}/{num}")
    public List<ProductRating> alsRecommendForUser(@PathVariable("customer") String customer,
                                                   @PathVariable("userId") int userId,
                                                   @PathVariable("num") int num) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.recommendProductsForUser(customer, userId, num, false);
    }

    @RequestMapping("/recommend/user/{userId}/{num}/detailed")
    public List<ProductRating> detailedAlsRecommendForUser(@PathVariable("customer") String customer,
                                                           @PathVariable("userId") int userId,
                                                           @PathVariable("num") int num) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.recommendProductsForUser(customer, userId, num, true);
    }

    @RequestMapping("/rating/top/{num}")
    public List<ProductRating> topProducts(@PathVariable("customer") String customer,
                                           @PathVariable("num") int num) {
        return analysisService.topProducts(customer, num, false);
    }

    @RequestMapping("/rating/top/{num}/detailed")
    public List<ProductRating> detailedTopProducts(@PathVariable("customer") String customer,
                                                   @PathVariable("num") int num) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.topProducts(customer, num, true);
    }

    @RequestMapping("/group/age/{age}")
    public double kmeanAgeGroupForAge(@PathVariable("customer") String customer,
                                      @PathVariable("age") int age) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictGroupForAge(customer, age);
    }

    @RequestMapping(value = "/group/age/statistic", method = RequestMethod.GET)
    public GroupStatistic getKmeanAgeStatistic(@PathVariable("customer") String customer) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByAge(customer);
    }

    @RequestMapping(value = "/group/age/statistic", method = RequestMethod.POST)
    public GroupStatistic kmeanAgeStatistic(@PathVariable("customer") String customer,
                                            @RequestBody List<Integer> ages) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByAge(customer, ages);
    }

    @RequestMapping(value = "/group/gender/statistic", method = RequestMethod.GET)
    public GroupStatistic getKmeanGenderStatistic(@PathVariable("customer") String customer) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByGender(customer);
    }

    @RequestMapping(value = "/group/gender/statistic", method = RequestMethod.POST)
    public GroupStatistic kmeanGenderStatistic(@PathVariable("customer") String customer,
                                               @RequestBody List<String> genders) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictStatisticsByGender(customer, genders);
    }

    @RequestMapping(value = "/sales", method = RequestMethod.POST)
    public List<SaleResult> salesAnalysis(@PathVariable("customer") String customer,
                                          @RequestBody List<SaleData> saleData) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictSales(customer, saleData);
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public List<InventoryResult> inventoryAnalysis(@PathVariable("customer") String customer,
                                                   @RequestBody List<InventoryData> inventories) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictInventory(customer, inventories, false);
    }

    @RequestMapping(value = "/inventory/detailed", method = RequestMethod.POST)
    public List<InventoryResult> detailedInventoryAnalysis(@PathVariable("customer") String customer,
                                                           @RequestBody List<InventoryData> inventories) {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return analysisService.predictInventory(customer, inventories, true);
    }
}
