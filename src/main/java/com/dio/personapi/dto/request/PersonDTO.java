package com.dio.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String fistName;

    private String lastName;

    private String cpf;

    private String birthDate;

    private List<PhoneDTO> phones = new ArrayList<>();

}
