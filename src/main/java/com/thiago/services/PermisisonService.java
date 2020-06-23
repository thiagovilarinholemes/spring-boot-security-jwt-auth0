package com.thiago.services;

import com.thiago.entities.Permission;
import com.thiago.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisisonService {

    @Autowired
    PermissionRepository repository;

    public List<Permission> findAll(){
        return repository.findAll();
    }


}
