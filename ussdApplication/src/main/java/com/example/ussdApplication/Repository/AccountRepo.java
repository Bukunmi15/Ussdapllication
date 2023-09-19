package com.example.ussdApplication.Repository;

import com.example.ussdApplication.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByPhoneNo(String phoneNumber);



    Optional<Accounts> findByPin (String pin);


}
