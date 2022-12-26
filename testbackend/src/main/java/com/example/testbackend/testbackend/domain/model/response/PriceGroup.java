package com.example.testbackend.testbackend.domain.model.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceGroup {

    private Integer product_id;
    private Integer brand_id;
    private String curr;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Double price;
    
    public PriceGroup(Integer product_id, Integer brand_id, String curr, LocalDateTime start_date, LocalDateTime end_date,
            Double price) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.curr = curr;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
    }
    
    

}
