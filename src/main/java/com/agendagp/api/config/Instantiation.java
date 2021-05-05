package com.agendagp.api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.agendagp.api.domain.Escort;
import com.agendagp.api.domain.Post;
import com.agendagp.api.domain.User;
import com.agendagp.api.repository.EscortRepository;
import com.agendagp.api.repository.PostRepository;
import com.agendagp.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.agendagp.api.dto.AuthorDTO;
import com.agendagp.api.dto.CommentDTO;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private PostRepository postReposiroty;

    @Autowired
    private EscortRepository escortRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepository.deleteAll(); 
        postReposiroty.deleteAll();

        Escort escort1 = new Escort(null, "Aline Fernandes",  "30 anos", 200.0, "https://as1.ftcdn.net/jpg/01/84/81/64/500_F_184816468_sXO2m7Xhy2xqENls5YxrKlmFg3Ii82Mr.jpg", true, "Jundiaí-SP");
        Escort escort2 = new Escort(null, "Akemi Hamasaki",  "20 anos", 200.0, "https://as1.ftcdn.net/jpg/01/84/81/64/500_F_184816468_sXO2m7Xhy2xqENls5YxrKlmFg3Ii82Mr.jpg", true, "São Paulo-SP");

        escortRepository.saveAll(Arrays.asList(escort1, escort2));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria)); 
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

        postReposiroty.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }
    
}
