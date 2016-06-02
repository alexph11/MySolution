package com.bluespurs.starterkit.controller;

import com.bluespurs.starterkit.UnitTest;
import com.bluespurs.starterkit.service.BestBuyAPIService;
import com.bluespurs.starterkit.service.WalmartServiceAPI;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Alexander on 02/06/2016.
 */
@Category(UnitTest.class)
public class ProductControllerUnitTest extends UnitTest {

        private MockMvc mockMvc;
        private WalmartServiceAPI walmartApiService;
        private BestBuyAPIService bestBuyApiService;

        @Before
        public void setUp() {
            super.setUp();
            walmartApiService = new WalmartServiceAPI();
            bestBuyApiService = new BestBuyAPIService();
            mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(walmartApiService, bestBuyApiService)).build();
        }

        /**
         * Test the product search.
         *
         * @see ProductController#search(String)
         */
        @Test
        public void testSearch() throws Exception {
            mockMvc.perform(get("/product/search?name=apple")).andExpect(status().isOk());
            mockMvc.perform(get("/product/search?name=aappppllee")).andExpect(status().isNoContent());
        }
}
