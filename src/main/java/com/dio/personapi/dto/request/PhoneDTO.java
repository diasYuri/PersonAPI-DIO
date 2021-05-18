package com.dio.personapi.dto.request;

import com.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    private PhoneType type;

    private String number;

}
