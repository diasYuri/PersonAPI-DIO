package com.dio.personapi.entities;

import com.dio.personapi.enums.PhoneType;
import lombok.Data;


@Data
public class Phone {

    private Long id;

    private String number;

    private PhoneType type;

}
