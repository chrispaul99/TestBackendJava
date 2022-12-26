package com.example.testbackend.testbackend.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="price_list")
    private Integer price_list;

    @Column(name="start_date")
    @NotNull(message = "Start Date es requerido")
    private LocalDateTime start_date;

    @Column(name="end_date")
    @NotNull(message = "End Date es requerido")
    private LocalDateTime end_date;

    @Column(name="product_id")
    @NotNull(message = "Product Id es requerido")
    private Integer product_id;

    @Column(name="priority")
    @NotNull(message = "Priority es requerido")
    private Integer priority;

    @Column(name="price")
    @Positive(message = "Precio no debe ser un número negativo o cero")
    private Double price;

    @Column(name="curr")
    @Size(min = 3, max = 3, message = "Curr debe contener máximo 3 caracteres")
    @NotBlank(message = "Curr no debe estar en blanco")
    private String curr;

    
    @NotNull(message = "Brand Id es requerido")
	@ManyToOne
    @JoinColumn(name="brand_id",referencedColumnName="id")
	private GroupEntity brand_id;
}
