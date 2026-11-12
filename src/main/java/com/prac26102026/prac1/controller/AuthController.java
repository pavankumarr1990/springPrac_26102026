package com.prac26102026.prac1.controller;

import com.prac26102026.prac1.dto.CurrentUserDTO;
import com.prac26102026.prac1.service.impl.UserContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserContextService userContextService;
//    http://localhost:8080/pavan/api/auth/me
    @GetMapping("/me")
    public ResponseEntity<CurrentUserDTO> getCurrentUser(
            @RequestHeader("SM_USER") String userName) {

        CurrentUserDTO currentUser =
                userContextService.validateUser(userName);

        return ResponseEntity.ok(currentUser);
    }
}
