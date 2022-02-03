package com.leticialima.workshopmongo.config;


import com.leticialima.workshopmongo.domain.Post;
import com.leticialima.workshopmongo.domain.User;
import com.leticialima.workshopmongo.dto.AuthorDTO;
import com.leticialima.workshopmongo.dto.CommentDTO;
import com.leticialima.workshopmongo.repository.PostRepository;
import com.leticialima.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo.Abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Vou viajar para São Paulo.Abraços", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.save(post1);
        postRepository.save(post2);

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);


    }


}
