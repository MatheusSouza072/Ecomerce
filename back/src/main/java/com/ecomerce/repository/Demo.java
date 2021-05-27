package com.ecomerce.repository;

import com.ecomerce.entities.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Demo implements ApplicationRunner {

    private final UserRepository userRepository;

    public Demo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        var user = User.of("123456");
        userRepository.save(user);


        userRepository.findAll().forEach(it -> {
            System.out.printf("Tag - ID[%d], Password[%s]%n", it.getId(), it.getPassword());
        });
    }

}



