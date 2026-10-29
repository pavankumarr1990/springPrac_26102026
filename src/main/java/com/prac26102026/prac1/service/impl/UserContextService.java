package com.prac26102026.prac1.service.impl;

import com.prac26102026.prac1.dto.CurrentUserDTO;
import com.prac26102026.prac1.entity.ApplicationUser;
import com.prac26102026.prac1.entity.Designation;
import com.prac26102026.prac1.repo.ApplicationUserRepository;
import com.prac26102026.prac1.repo.DesignationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserContextService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private  DesignationRepository designationRepository;

    public UserContextService(
            ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CurrentUserDTO getUser(String headerUserName) {

        if (headerUserName == null || headerUserName.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Missing SM_USER header");
        }

        ApplicationUser user = userRepository
                .findByUserName(headerUserName.trim())
                .or(() -> userRepository.findByUsername(
                        headerUserName.trim()))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Unknown user"));

        if (!Boolean.TRUE.equals(user.getActive())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "User is inactive");
        }

        String designation = null;

        if (user.getDesignationId() != null) {
            designation = designationRepository
                    .findById(user.getDesignationId())
                    .map(Designation::getDesignationName)
                    .orElse(null);
        }

        return new CurrentUserDTO(
                user.getUserId(),
                user.getUserName(),
                designation
        );
    }

    public CurrentUserDTO validateUser(String userName) {

        ApplicationUser user = userRepository
//                .findByUserName(userName) // ThiS WILL check for case sensitive also so to ignore the casesentisve used below line
                .findByUserNameIgnoreCase(userName)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "User not found"
                ));

        if (!Boolean.TRUE.equals(user.getActive())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "User is inactive"
            );
        }

        String designation = null;

        if (user.getDesignationId() != null) {
            designation = designationRepository
                    .findById(user.getDesignationId())
                    .map(Designation::getDesignationName)
                    .orElse(null);
        }

        return new CurrentUserDTO(
                user.getUserId(),
                user.getUserName(),
                designation
        );
    }
}
