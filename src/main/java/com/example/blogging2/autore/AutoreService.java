package com.example.blogging2.autore;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public Autore save(Autore autore) {

        return autoreRepository.save(autore);
    }

    public List<Autore> findAll() {
        return autoreRepository.findAll();

    }

//    public Autore findByIdd(Long id) {
//        return autoreRepository.findById(id).get();
//    }

    public AutoreResponseComplete findById(Long id) {
        if(!autoreRepository.existsById(id) ){
            throw new EntityNotFoundException("Autore not found" );
        }
        Autore autore = autoreRepository.findById(id).get();
        AutoreResponseComplete autoreResponseComplete = new AutoreResponseComplete();
        BeanUtils.copyProperties(autore, autoreResponseComplete);
        return autoreResponseComplete;
    }

    public AutoreResponseId create(AutoreRequest request) {
        if(autoreRepository.existsByNomeIgnoreCase(request.getNome()) ){
            throw new EntityExistsException("Autore already exists" );
        }
        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        AutoreResponseId autoreResponseId = new AutoreResponseId();
        BeanUtils.copyProperties(autore, autoreResponseId);
        return autoreResponseId;
    }

    public AutoreResponseComplete update(Long id, AutoreRequest request) {
        if(!autoreRepository.existsById(id) ){
            throw new EntityNotFoundException("Autore not found" );
        }
       Autore autore = autoreRepository.findById(id).get();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        AutoreResponseComplete autoreResponseComplete = new AutoreResponseComplete();
        BeanUtils.copyProperties(autore, autoreResponseComplete);
        return autoreResponseComplete;
    }

    public void delete(Long id) {
        if(!autoreRepository.existsById(id) ){
            throw new EntityNotFoundException("Autore not found" );
        }
        autoreRepository.deleteById(id);
    }
}
