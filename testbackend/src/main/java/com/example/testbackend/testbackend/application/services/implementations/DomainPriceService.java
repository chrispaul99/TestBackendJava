package com.example.testbackend.testbackend.application.services.implementations;

import java.util.Optional;

import com.example.testbackend.testbackend.application.services.interfaces.IPriceService;
import com.example.testbackend.testbackend.domain.model.Price;
import com.example.testbackend.testbackend.domain.model.response.PriceGroup;
import com.example.testbackend.testbackend.domain.port.IPriceRepository;

public class DomainPriceService implements IPriceService{

    private final IPriceRepository priceRepository;

    public DomainPriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Iterable<Price> getPrices() {
        return this.priceRepository.getPrices();
    }

    @Override
    public Price getPriceById(Integer id) {
        return this.priceRepository.getPrice(id).get();
    }

    @Override
    public Price savePrice(Price price) {
        return this.priceRepository.savePrice(price);
    }

    @Override
    public void deletePrice(Integer id) {
        this.priceRepository.deletePriceById(id);
        
    }

    @Override
    public Optional<PriceGroup> getPriceInDate(String date, Integer product_id, Integer brand) {
        return this.priceRepository.getPriceInDate(date, product_id, brand);
    }

    
}
