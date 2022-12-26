package com.example.testbackend.testbackend.application.services.interfaces;

import java.util.Optional;

import com.example.testbackend.testbackend.domain.model.Price;
import com.example.testbackend.testbackend.domain.model.response.PriceGroup;


public interface IPriceService {
    Iterable<Price> getPrices();
    Price getPriceById (Integer id);
    Price savePrice (Price price);
    void deletePrice(Integer id);
    Optional <PriceGroup> getPriceInDate(String date,Integer product_id,Integer brand);
}
