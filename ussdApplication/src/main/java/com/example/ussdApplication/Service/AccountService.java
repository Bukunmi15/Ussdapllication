package com.example.ussdApplication.Service;

import com.example.ussdApplication.Dto.AccountDto;
import com.example.ussdApplication.Response.AccountResponse;
import com.example.ussdApplication.Model.Accounts;
import com.example.ussdApplication.Repository.AccountRepo;
import com.example.ussdApplication.Utils.AccountUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepo accountRepo;
    private final ModelMapper modelMapper;

    public AccountResponse addAccount (AccountDto request){
        Accounts accounts = new Accounts();
        accounts.setFullName(request.getFirstName() +" "+ request.getLastName());
        accounts.setEmail(request.getEmail());
        accounts.setGender(request.getGender());
        accounts.setNationality(request.getNationality());
        accounts.setPhoneNo(request.getPhoneNo());
        accounts.setPin(request.getPin());
        accounts.setResidentialAddress(request.getResidentialAddress());
        accounts.setAccountType(request.getAccountType());
        accounts.setAccountNumber(AccountUtil.generateAccountNumber());
        accounts.setBalanceBefore(0.00);
        accounts.setBalanceAfter(0.00);
        accounts.setDateCreated(new Date());
        accountRepo.save(accounts);
       return modelMapper.map(accounts,AccountResponse.class);
    }



    public AccountResponse deposit(String phoneNo, Double amount){
        Optional<Accounts> optionalAccounts = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccounts.isEmpty()){
            throw new RuntimeException("Account not found");
        }else {
            Accounts accounts = optionalAccounts.get();
            accounts.setBalanceAfter(accounts.getBalanceBefore() + amount);
            accountRepo.save(accounts);
            return  modelMapper.map(accounts,AccountResponse.class);
        }
    }



    public AccountResponse redeposit(String phoneNo, Double amount){
        Optional<Accounts> optionalAccounts = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccounts.isEmpty()){
            throw new RuntimeException("Account not found");
        }else {
            Accounts accounts = optionalAccounts.get();
            accounts.setBalanceBefore(accounts.getBalanceAfter());
            accounts.setBalanceAfter(accounts.getBalanceBefore() + amount);
            accountRepo.save(accounts);
            return  modelMapper.map(accounts,AccountResponse.class);
        }
    }



    public AccountResponse withdraw(String pin, Double amount){
        Optional<Accounts> optionalAccounts = accountRepo.findByPin(pin);
        if(optionalAccounts.isEmpty()){
            throw new RuntimeException("Account Not Found");
        }else{
            Accounts accounts = optionalAccounts.get();
            accounts.setWithdrawAmount(amount);
            accounts.setBalanceAfter(accounts.getBalanceAfter() - amount);
            accountRepo.save(accounts);
            return modelMapper.map(accounts,AccountResponse.class);
        }
    }


    public Double checkBalance (String phoneNo){
        Optional<Accounts> optionalAccounts = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccounts.isEmpty()){
            throw new RuntimeException("Account Not Found");
        }else{
            Accounts accounts = optionalAccounts.get();
            Double balance = accounts.getBalanceAfter();
            return balance;
        }

    }
}