package com.leticialima.workshopmongo.service;

import com.leticialima.workshopmongo.domain.Post;
import com.leticialima.workshopmongo.domain.User;
import com.leticialima.workshopmongo.dto.UserDTO;
import com.leticialima.workshopmongo.repository.PostRepository;
import com.leticialima.workshopmongo.repository.UserRepository;
import com.leticialima.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repo;

    public Post findById(String id) {

        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
