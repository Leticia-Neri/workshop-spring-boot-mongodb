package com.leticialima.workshopmongo.service;

import com.leticialima.workshopmongo.domain.User;
import com.leticialima.workshopmongo.dto.UserDTO;
import com.leticialima.workshopmongo.repository.UserRepository;
import com.leticialima.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){

        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
