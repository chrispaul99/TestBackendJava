package com.example.testbackend.testbackend.infraestructure.adapter.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.testbackend.testbackend.infraestructure.entity.PriceEntity;

public interface IPriceCrudRepository extends CrudRepository<PriceEntity, Integer> {
    
    @Query(value = "select top 1 *from prices where product_id= ?1 and brand_id= ?2 and ?3>=start_date and ?3<=end_date order by priority desc", nativeQuery = true)
    Optional<PriceEntity> getPriceInDate(Integer product,Integer brand,LocalDateTime date);
    
}
