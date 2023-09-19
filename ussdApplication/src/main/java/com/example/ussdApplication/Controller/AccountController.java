package com.example.ussdApplication.Controller;

import com.example.ussdApplication.Dto.AccountDto;
import com.example.ussdApplication.Response.AccountResponse;
import com.example.ussdApplication.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ussdapplication")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    @PostMapping("addaccount")
    public AccountResponse addAccounnt (@RequestBody AccountDto request){
        return accountService.addAccount(request);
    }

    @PostMapping("deposit")
    public AccountResponse depositMoney(@RequestParam("phoneNo") String phoneNo, @RequestParam("amount")Double amount){
        return accountService.deposit(phoneNo, amount);
    }

    @PostMapping("redeposit")
    public AccountResponse redepositMoney(@RequestParam("phoneNo") String phoneNo, @RequestParam("amount") Double amount){
        return accountService.redeposit(phoneNo, amount);
    }

    @PostMapping("withdraw")
    public AccountResponse withdraw (@RequestParam("pin")String pin, @RequestParam("amount") Double amount){
        return accountService.withdraw(pin,amount);
    }

    @GetMapping("balance")
    public Double checkBalance(@RequestParam("phoneNo")String phoneNo){
        return accountService.checkBalance(phoneNo);
    }

}
