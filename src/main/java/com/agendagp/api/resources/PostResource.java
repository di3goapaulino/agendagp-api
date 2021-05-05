package com.agendagp.api.resources;

import java.util.Date;
import java.util.List;

import com.agendagp.api.domain.Post;
import com.agendagp.api.resources.util.URL;
import com.agendagp.api.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Post>  findById(@PathVariable String id){
    
    Post post = service.findById(id);

    return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch" , method = RequestMethod.GET)
    public ResponseEntity<List<Post>>  findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
    title = URL.decodeParam(title);

    List<Post> listPost = service.findByTitle(title);

    return ResponseEntity.ok().body(listPost);
    }

    @RequestMapping(value = "/fullsearch" , method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) 
    {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> listPost = service.fullSearch(text, min, max);

        return ResponseEntity.ok().body(listPost);
    }
    
}
