package com.prac26102026.prac1.practice.TranscationalPrac.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletTransServices {

    @Autowired
    private UserTransServices userTransServices;


//    Below annotation is used to ensure that the transfer operation is atomic,
//    meaning that either both debit and credit operations succeed, or neither does. This helps maintain data integrity in case of any failures during the transfer process.
    @Transactional
    public void transfer(Long senderId, Long receiverId, Double amount) {
//        // Fetch sender and receiver users
//        User sender = userTransServices.getUserById(senderId);
//        User receiver = userTransServices.getUserById(receiverId);
//
//        // Check if sender has enough balance
//        if (sender.getBalance() < amount) {
//            throw new RuntimeException("Insufficient balance in sender's wallet.");
//        }
//
//        // Perform the transfer
//        sender.setBalance(sender.getBalance() - amount);
//        receiver.setBalance(receiver.getBalance() + amount);
//
//        // Save the updated users
//        userTransServices.updateUser(sender);
//        userTransServices.updateUser(receiver);


        userTransServices.debitUser(senderId, amount);
        userTransServices.creditUser(receiverId, amount);

    }
}
