package com.thiago.repositories;

import com.thiago.entities.Authorization;
import com.thiago.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    Authorization findByNameAuthorization(String authorization);

}
