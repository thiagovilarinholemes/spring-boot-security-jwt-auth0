package com.thiago.db.seeds;

import com.thiago.entities.*;
import com.thiago.entities.enums.UserStatus;
import com.thiago.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
public class UserSeed implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Insert Permissions
        permissionRepository.deleteAll();
        Permission p1 = new Permission(null, "/test1");
        Permission p2 = new Permission(null, "/test2");
        Permission p3 = new Permission(null, "/test3");
        Permission p4 = new Permission(null, "/users");
        Permission p5 = new Permission(null, "/reports");
        permissionRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Insert Roles
        roleRepository.deleteAll();
        Role r1 = new Role(null, "ADMIN");
        Role r2 = new Role(null, "MANAGER");
        Role r3 = new Role(null, "USER");
        roleRepository.saveAll(Arrays.asList(r1, r2, r3));

        // Created association Role and Permission
        r1.getPermissions().add(p1);
        r1.getPermissions().add(p2);
        r1.getPermissions().add(p3);
        r1.getPermissions().add(p4);
        r1.getPermissions().add(p5);
        r2.getPermissions().add(p2);
        r2.getPermissions().add(p5);
        r3.getPermissions().add(p1);
        roleRepository.saveAll(Arrays.asList(r1, r2));

        // Insert User
        userRepository.deleteAll();
        User u1 = new User(null, "Thiago V.", "thiago", passwordEncoder.encode("123"), UserStatus.ACTIVE, r1);
        User u2 = new User(null, "Carina V.", "carina", passwordEncoder.encode("123"), UserStatus.ACTIVE, r2);
        User u3 = new User(null, "Spack Rella", "spack", passwordEncoder.encode("123"), UserStatus.ACTIVE, r3);
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        // Insert Authorization
        authorizationRepository.deleteAll();
//        Authorization a1 = new Authorization(null, "/users");
//        Authorization a2 = new Authorization(null, "/test2");
//        Authorization a3 = new Authorization(null, "/test3");
        Authorization a4 = new Authorization(null, "ACCESS_REPORTS");
        authorizationRepository.saveAll(Arrays.asList(a4));

        // Created association Authorization User
        a4.getUsers().add(u1);
        authorizationRepository.saveAll(Arrays.asList(a4));
    }
}
