package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="regions")
@Data
@NoArgsConstructor
public class Region {
    @Id
    @Column(name="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;
    private String region;
    private String country;
}
