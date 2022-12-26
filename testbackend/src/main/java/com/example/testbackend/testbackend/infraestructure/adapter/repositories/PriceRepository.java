package com.example.testbackend.testbackend.infraestructure.adapter.repositories;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.testbackend.testbackend.domain.model.Price;
import com.example.testbackend.testbackend.domain.model.response.PriceGroup;
import com.example.testbackend.testbackend.domain.port.IPriceRepository;
import com.example.testbackend.testbackend.infraestructure.adapter.dao.IPriceCrudRepository;
import com.example.testbackend.testbackend.infraestructure.entity.PriceEntity;
import com.example.testbackend.testbackend.infraestructure.exceptions.ResourceNotFoundException;
import com.example.testbackend.testbackend.infraestructure.rest.mapper.PriceMapper;


@Repository
public class PriceRepository implements IPriceRepository {

    private final IPriceCrudRepository priceCrudRepository;
    
    @Autowired
    private PriceMapper priceMapper;

    public PriceRepository(IPriceCrudRepository priceCrudRepository) {
        this.priceCrudRepository = priceCrudRepository;
    }

    @Override
    public Iterable<Price> getPrices() {
        return this.priceMapper.toPrices(this.priceCrudRepository.findAll());
    }

    @Override
    public Optional<Price> getPrice(Integer id) {
        PriceEntity price = this.priceCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.priceMapper.toPrice(price));
    }

    @Override
    public Price savePrice(Price price) {
        PriceEntity priceEntity = this.priceMapper.toPriceEntity(price);
        return this.priceMapper.toPrice(this.priceCrudRepository.save(priceEntity));
    }

    @Override
    public void deletePriceById(Integer id) {
        PriceEntity priceEntity = this.priceCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.priceCrudRepository.deleteById(priceEntity.getPrice_list());
        
    }

    @Override
    public Optional<PriceGroup> getPriceInDate(String date, Integer product_id, Integer brand) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
        PriceEntity p = this.priceCrudRepository.getPriceInDate(product_id,brand,dateTime).orElseThrow(
            ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(new PriceGroup(p.getProduct_id(),brand,p.getCurr(),p.getStart_date(),p.getEnd_date(),p.getPrice()));

    }
}