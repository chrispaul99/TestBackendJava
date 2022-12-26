package com.example.testbackend.testbackend.infraestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    @Size(min = 3, message = "Nombre debe contener máximo 3 caracteres")
    @NotBlank(message = "Nombre no debe estar en blanco")
    private String name;

    //@OneToMany(mappedBy="brand_id",fetch=FetchType.LAZY)
	//private List<PriceEntity> prices;

}
