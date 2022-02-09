package com.leticialima.workshopmongo.repository;

import com.leticialima.workshopmongo.domain.UsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {

    public Optional<UsuarioModel> findByLogin(String login);
}
