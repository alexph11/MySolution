package com.bluespurs.starterkit.controller;

/**
 * Created by Alexander on 02/06/2016.
 */

import com.bluespurs.starterkit.service.BestBuyAPIService;
import com.bluespurs.starterkit.service.WalmartServiceAPI;
import com.bluespurs.starterkit.service.ProductObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final WalmartServiceAPI walmartServiceAPI;
    private final BestBuyAPIService bestBuyServiceAPI;

    @Autowired
    public ProductController(final WalmartServiceAPI walmartServiceAPI, final BestBuyAPIService bestBuyApiService) {
            this.walmartServiceAPI = walmartServiceAPI;
            this.bestBuyServiceAPI = bestBuyApiService;
    }

    /**
     * Returns the product of the lowest price.
     */
    @RequestMapping(value = "search", method = RequestMethod.GET, params = "name")
    public Object search(@RequestParam("name") final String name) {
        final List<ProductObj> wps = walmartServiceAPI.search(name, "price", true, 1);
        final List<ProductObj> bbps = bestBuyServiceAPI.search(name, "salePrice.asc", 1, 1);
        ProductObj wp = null;
        ProductObj bbp = null;
        if (!wps.isEmpty()) {
            wp = wps.get(0);
        }
        if (!bbps.isEmpty()) {
            bbp = bbps.get(0);
        }
        if (wp != null && (bbp == null || wp.getSalePriceItem() < bbp.getSalePriceItem())) {
            return new CheapestProduct(wp.getNameDesc(), wp.getSalePriceItem(), "USD", "Walmart");
        }
        if (bbp != null) {
            return new CheapestProduct(bbp.getNameDesc(), bbp.getSalePriceItem(), "USD", "BestBuy");
        }
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
