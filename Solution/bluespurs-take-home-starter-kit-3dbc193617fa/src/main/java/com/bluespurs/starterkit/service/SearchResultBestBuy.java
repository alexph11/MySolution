package com.bluespurs.starterkit.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Alexander on 02/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultBestBuy {

        private List<ProductObj> products;

        public List<ProductObj> getProducts() {
            return products;
        }

        public void setProducts(List<ProductObj> products) {
            this.products = products;
        }
}
