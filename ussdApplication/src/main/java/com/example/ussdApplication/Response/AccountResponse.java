package com.example.ussdApplication.Response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class AccountResponse {
    private String fullName;

    private String gender;

    private String email;

    private String residentialAddress;

    private String nationality;

    private String accountType;

    private String phoneNo;

    private String pin;

    private int accountNumber;

    private Double balanceBefore;

    private Double balanceAfter;

    private Double withdrawAmount;

    private Date dateCreated;
}
