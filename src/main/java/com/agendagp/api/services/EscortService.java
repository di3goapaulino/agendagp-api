package com.agendagp.api.services;

import java.util.List;
import java.util.Optional;

import com.agendagp.api.domain.Escort;
import com.agendagp.api.dto.EscortDTO;
import com.agendagp.api.repository.EscortRepository;
import com.agendagp.api.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscortService {

    @Autowired
    private EscortRepository repository;

    public List<Escort> findAll(){
        return repository.findAll();
    };

    public Escort findById(String id) {
        Optional<Escort> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Escort insert (Escort escort){
        return repository.insert(escort);
    }

    public void delete (String id){
        findById(id);
        repository.deleteById(id);
    }

    public Escort update(Escort escort) {
        Escort newEscort = findById(escort.getId());
        updateData(newEscort, escort);
        return repository.save(newEscort);
    }

    private void updateData(Escort newEscort, Escort escort) {
        newEscort.setName(escort.getName());
        newEscort.setAge(escort.getAge());
    }

    public Escort fromDTO(EscortDTO objDTO) {
        return new Escort(
                  objDTO.getId()
                , objDTO.getName()
                , objDTO.getAge()
                , objDTO.getHourCost()
                , objDTO.getProfileImagePath()
                , objDTO.getStatus()
                , objDTO.getCityPlace());
    }
    
}
