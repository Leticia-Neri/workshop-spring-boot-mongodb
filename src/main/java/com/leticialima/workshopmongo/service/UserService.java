package com.leticialima.workshopmongo.service;

import com.leticialima.workshopmongo.domain.User;
import com.leticialima.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
