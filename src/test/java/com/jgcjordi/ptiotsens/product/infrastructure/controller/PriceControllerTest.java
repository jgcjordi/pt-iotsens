package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jgcjordi.ptiotsens.product.domain.Currency;
import com.jgcjordi.ptiotsens.product.infrastructure.controller.response.PriceProductResponse;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.BrandEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.BrandRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.PriceRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

        @Autowired
        private PriceRepository priceRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private BrandRepository brandRepository;

        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldReturnTheExpectedPrices() throws Exception {
            BrandEntity bandEntity = new BrandEntity(1L,"ACME");
            ProductEntity productEntity = new ProductEntity(35455L, "Elastic bed",1L);
            PriceEntity priceEntity1 =
                    new PriceEntity(
                            1L,
                            LocalDateTime.parse("2020-06-14T00:00:00"),
                            LocalDateTime.parse("2020-12-31T23:59:59"),
                            1,
                            1,
                            35.50,
                            Currency.EUR,
                            35455L
                    );
            PriceEntity priceEntity2 =
                    new PriceEntity(
                            2L,
                            LocalDateTime.parse("2020-06-14T15:00:00"),
                            LocalDateTime.parse("2020-06-14T18:30:00"),
                            2,
                            1,
                            25.45,
                            Currency.EUR,
                            35455L
                    );
            PriceEntity priceEntity3 =
                    new PriceEntity(
                            3L,
                            LocalDateTime.parse("2020-06-15T00:00:00"),
                            LocalDateTime.parse("2020-06-15T11:00:00"),
                            3,
                            1,
                            30.50,
                            Currency.EUR,
                            35455L
                    );
            PriceEntity priceEntity4 =
                    new PriceEntity(
                            4L,
                            LocalDateTime.parse("2020-06-15T16:00:00"),
                            LocalDateTime.parse("2020-12-31T23:59:59"),
                            4,
                            1,
                            38.95,
                            Currency.EUR,
                            35455L
                    );

            brandRepository.saveAndFlush(bandEntity);
            productRepository.saveAndFlush(productEntity);
            priceRepository.saveAndFlush(priceEntity1);
            priceRepository.saveAndFlush(priceEntity2);
            priceRepository.saveAndFlush(priceEntity3);
            priceRepository.saveAndFlush(priceEntity4);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            testPriceOnDate(objectMapper, "2020-06-14T10:00:00", 35.5);
            testPriceOnDate(objectMapper, "2020-06-14T16:00:00", 25.45);
            testPriceOnDate(objectMapper, "2020-06-14T21:00:00", 35.5);
            testPriceOnDate(objectMapper, "2020-06-15T10:00:00", 30.5);
            testPriceOnDate(objectMapper, "2020-06-16T21:00:00", 38.95);

            mockMvc.perform(
                            MockMvcRequestBuilders.get("/price/35455?applicationDate=2023-06-16T21:00:00")
                    )
                    .andExpect(status().isNotFound());
        }

    private void testPriceOnDate(ObjectMapper objectMapper, String date, double expectedPrice) throws Exception {
        String responseBody5 = mockMvc.perform(
                        MockMvcRequestBuilders.get("/price/35455?applicationDate="+date)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        PriceProductResponse priceProductResponse5 = objectMapper.readValue(responseBody5, PriceProductResponse.class);
        Assertions.assertThat(priceProductResponse5.getFinalPrice()).isEqualTo(expectedPrice);
    }
}