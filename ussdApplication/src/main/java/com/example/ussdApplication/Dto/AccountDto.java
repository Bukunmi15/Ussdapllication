package com.example.ussdApplication.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    private String firstName;
    private String lastName;
    private String gender;

    private String email;

    private String phoneNo;

    private String pin;

    private String residentialAddress;

    private String nationality;

    private String accountType;

}
