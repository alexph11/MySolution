package com.bluespurs.starterkit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 02/06/2016.
 */
@Service
public class WalmartServiceAPI {

        private static final String SEARCH_API = "http://api.walmartlabs.com/v1/search?"
                + "apiKey={apiKey}&query={query}&sort={sort}&order={order}&numItems={numItems}";

        @Value("${walmart-key}")
        private String key;

        public List<ProductObj> search(final String query, final String sortBy, final boolean ascending,
                                    final int numItems) {
            final RestTemplate restClient = new RestTemplate();
            final Map<String, Object> params = new HashMap<>();
            params.put("apiKey", key);
            params.put("query", query);
            params.put("sort", sortBy);
            params.put("order", ascending ? "asc" : "desc");
            params.put("numItems", numItems);
            List<ProductObj> items = restClient.getForObject(SEARCH_API, SearchResultWalmart.class, params).getItems();
            if (items == null) {
                items = Collections.emptyList();
            }
            return items;
        }
}
