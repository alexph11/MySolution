package com.bluespurs.starterkit.service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Alexander on 02/06/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductObj {

        private String nameDesc;
        private float salePriceItem;

        public String getNameDesc() {
            return nameDesc;
        }

        public void setNameDesc(String nameDesc) {
            this.nameDesc = nameDesc;
        }

        public float getSalePriceItem() {
            return salePriceItem;
        }

        public void setSalePrice(float salePriceItem) {
            this.salePriceItem = salePriceItem;
        }
}
