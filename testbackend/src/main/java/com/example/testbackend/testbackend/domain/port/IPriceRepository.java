package com.example.testbackend.testbackend.domain.port;

import java.util.Optional;

import com.example.testbackend.testbackend.domain.model.Price;
import com.example.testbackend.testbackend.domain.model.response.PriceGroup;


public interface IPriceRepository {
    Iterable<Price> getPrices();
    Optional <Price> getPrice (Integer id);
    Price savePrice (Price price);
    void deletePriceById(Integer id);

    Optional <PriceGroup> getPriceInDate(String date,Integer product_id,Integer brand);

}
