package com.agendagp.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.agendagp.api.domain.Post;
import com.agendagp.api.repository.PostRepository;
import com.agendagp.api.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title){
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

        return repository.fullSearch(text, minDate, maxDate);
    }
    
}
