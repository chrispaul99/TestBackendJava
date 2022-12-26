package com.example.testbackend.testbackend.infraestructure.rest.mapper;


import com.example.testbackend.testbackend.domain.model.Price;

import com.example.testbackend.testbackend.infraestructure.entity.PriceEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    @Mappings({
        @Mapping(source = "price_list", target = "price_list"),
        @Mapping(source = "start_date", target = "start_date"),
        @Mapping(source = "end_date", target = "end_date"),
        @Mapping(source = "product_id", target = "product_id"),
        @Mapping(source = "priority", target = "priority"),
        @Mapping(source = "price", target = "price"),
        @Mapping(source = "curr", target = "curr"),
    }
)
Price toPrice(PriceEntity price);
Iterable<Price> toPrices(Iterable<PriceEntity> priceEntity);

@InheritInverseConfiguration
PriceEntity toPriceEntity (Price price);

}
