package com.example.testbackend.testbackend.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Price {

    private Integer price_list;

    private LocalDateTime start_date;
    private LocalDateTime end_date;

    private Integer product_id;
    private Integer priority;

    private Double price;

    private String curr;


}
