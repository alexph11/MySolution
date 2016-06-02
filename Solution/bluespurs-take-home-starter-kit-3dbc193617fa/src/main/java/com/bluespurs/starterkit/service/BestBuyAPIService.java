package com.bluespurs.starterkit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alexander on 02/06/2016.
 */
@Service
public class BestBuyAPIService {

        private static final String SEARCH_API = "http://api.bestbuy.com/v1/products(name={query})?"
                + "format=json&sort={sort}&show=name,salePrice&apiKey={apiKey}&page={page}&pageSize={pageSize}";

        @Value("${bestbuy-key}")
        private String key;

        public List<ProductObj> search(final String query, final String sortBy, final int pageNum, final int pageSize) {
            final RestTemplate restClient = new RestTemplate();
            final Map<String, Object> params = new HashMap<>();
            params.put("apiKey", key);
            params.put("query", query + '*');
            params.put("sort", sortBy);
            params.put("page", pageNum);
            params.put("pageSize", pageSize);
            return restClient.getForObject(SEARCH_API, SearchResultBestBuy.class, params).getProducts();
        }
}
