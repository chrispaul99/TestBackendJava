package com.example.testbackend.testbackend.infraestructure.rest.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testbackend.testbackend.application.services.interfaces.IPriceService;
import com.example.testbackend.testbackend.domain.model.Price;
import com.example.testbackend.testbackend.domain.model.response.PriceGroup;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final IPriceService priceService;

    public PriceController(IPriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Price>> getPrices(){
        return new ResponseEntity<>(this.priceService.getPrices(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Price> savePrice(@RequestBody Price Price){
        return new ResponseEntity<>(this.priceService.savePrice(Price), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPrice (@PathVariable Integer id){
        return new ResponseEntity<>(this.priceService.getPriceById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePrice(@PathVariable Integer id){
        this.priceService.deletePrice(id);
    }

    @GetMapping("/getPriceInDate")
    public ResponseEntity<Optional<PriceGroup>>  getPriceInDate(@RequestParam("date")String date,@RequestParam("product")Integer product, @RequestParam("brand") Integer brand){
        return new ResponseEntity<>(this.priceService.getPriceInDate(date,product,brand), HttpStatus.OK);
    }

}
