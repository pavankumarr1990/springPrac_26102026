package com.prac26102026.prac1.practice.TranscationalPrac.controller;

import com.prac26102026.prac1.practice.TranscationalPrac.service.WalletTransServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    private WalletTransServices walletService;
//    http://localhost:8080/pavan/transfer?senderId=1&receiverId=2&amount=100
    @PostMapping("/transfer")
    public String transfer(@RequestParam Long senderId,
                                 @RequestParam Long receiverId,
                                 @RequestParam Double amount) {
        try {
            walletService.transfer(senderId, receiverId, amount);
        } catch (Exception e) {
            return "Transfer failed: " + e.getMessage();
        }
        return "Amount transferred successfully!";
    }

}
