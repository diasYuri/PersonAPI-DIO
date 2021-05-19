package com.dio.personapi.entities;

import com.dio.personapi.enums.PhoneType;
import lombok.Data;

import javax.persistence.*;


@Data
public class Phone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

}
