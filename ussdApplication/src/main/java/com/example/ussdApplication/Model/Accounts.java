package com.example.ussdApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ussd_accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id" , nullable = false)
    private Long accountId;

    @Basic
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Basic
    @Column(name = "gender", nullable = false)
    private String gender;

    @Basic
    @Column(name = "email", nullable = false)
    private String email;

    @Basic
    @Column(name = "residential_address", nullable = false)
    private String residentialAddress;

    @Basic
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Basic
    @Column(name = "pin", nullable = false)
    private String pin;

    @Basic
    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Basic
    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Basic
    @Column(name = "account_number", nullable = false)
    private int accountNumber;

    @Basic
    @Column(name = "balance_before", nullable = false)
    private Double balanceBefore;

    @Basic
    @Column(name = "balance_after", nullable = false)
    private Double balanceAfter;


    @Basic
    @Column(name = "withdraw_amount", nullable = false)
    private Double withdrawAmount;

    @Basic
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;
}
