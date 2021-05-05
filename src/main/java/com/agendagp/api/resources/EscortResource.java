package com.agendagp.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.agendagp.api.domain.Escort;
import com.agendagp.api.dto.EscortDTO;
import com.agendagp.api.services.EscortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/escorts")
public class EscortResource {

    @Autowired
    private EscortService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EscortDTO>>  findAll(){
    
    List<Escort> list = service.findAll();

    List<EscortDTO> listDto = list.stream().map(es -> new EscortDTO(es)).collect(Collectors.toList());

    return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<EscortDTO>  findById(@PathVariable String id){
    
    Escort escort = service.findById(id);

    return ResponseEntity.ok().body(new EscortDTO(escort));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void>  insert(@RequestBody EscortDTO escortDTO){
    
    Escort escort = service.fromDTO(escortDTO);
    escort = service.insert(escort);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(escort.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<EscortDTO> delete(@PathVariable String id){
    
    service.delete(id);

    return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Void> uddate(@RequestBody EscortDTO escortDTO, @PathVariable String id){
    
    Escort escort = service.fromDTO(escortDTO);
    escort.setId(id);
    escort = service.update(escort);

	return ResponseEntity.noContent().build();
    }
    
}
