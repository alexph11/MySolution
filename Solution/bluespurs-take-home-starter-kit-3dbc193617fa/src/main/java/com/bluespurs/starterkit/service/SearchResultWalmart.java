package com.bluespurs.starterkit.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Alexander on 02/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultWalmart {

        private List<ProductObj> items;

        public List<ProductObj> getItems() {
            return items;
        }

        public void setItems(List<ProductObj> items) {
            this.items = items;
        }
}
