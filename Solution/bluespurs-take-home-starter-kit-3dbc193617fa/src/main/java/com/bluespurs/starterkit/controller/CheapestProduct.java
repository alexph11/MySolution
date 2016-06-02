package com.bluespurs.starterkit.controller;

/**
 * Created by Alexander on 02/06/2016.
 */
public class CheapestProduct {

    private final String productDesc;
    private final String cheapPrice;
    private final String curr;
    private final String location;

        public CheapestProduct(final String productDesc, final float cheapPrice, final String curr,
                                final String location) {
            this.productDesc = productDesc;
            this.cheapPrice = String.format("%.2f", cheapPrice);
            this.curr = curr;
            this.location = location;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public String getCheapPrice() {
            return cheapPrice;
        }

        public String getCurrency() {
            return curr;
        }

        public String getLocation() {
            return location;
        }
}
