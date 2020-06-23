package com.thiago.services;

import com.thiago.entities.Role;
import com.thiago.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    public List<Role> findAll(){
        return repository.findAll();
    }


}
