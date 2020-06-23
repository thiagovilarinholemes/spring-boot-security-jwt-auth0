package com.thiago.services;

import com.thiago.entities.Authorization;
import com.thiago.repositories.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    AuthorizationRepository repository;

    public List<Authorization> findAll(){
        return repository.findAll();
    }

}
