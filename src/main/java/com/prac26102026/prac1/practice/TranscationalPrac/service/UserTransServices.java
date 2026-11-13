package com.prac26102026.prac1.practice.TranscationalPrac.service;


import com.prac26102026.prac1.practice.TranscationalPrac.entity.UserTransPrac1;
import com.prac26102026.prac1.practice.TranscationalPrac.repository.UserRepoTranscational;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransServices {

    @Autowired
    private UserRepoTranscational userRepoTranscational;

    public void debitUser(Long userId, double amount) {
        UserTransPrac1 user = (UserTransPrac1) userRepoTranscational.findById(userId).orElseThrow();
        user.setBalance(user.getBalance() - amount);
        userRepoTranscational.save(user);
    }

    public void creditUser(Long userId, double amount) {
        UserTransPrac1 user = (UserTransPrac1) userRepoTranscational.findById(userId).orElseThrow();
        user.setBalance(user.getBalance() + amount);
        userRepoTranscational.save(user);
    }


}
