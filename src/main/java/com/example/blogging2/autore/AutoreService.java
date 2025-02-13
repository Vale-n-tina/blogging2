package com.example.blogging2.autore;

import com.example.blogging2.mail.EmailService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class AutoreService {
    private final AutoreRepository autoreRepository;
    private final EmailService emailService;

    public Autore save(Autore autore) {

        return autoreRepository.save(autore);
    }

    public Page<Autore> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);

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

    public AutoreResponseId create(@Valid AutoreRequest request) {
        if(autoreRepository.existsByNomeIgnoreCase(request.getNome()) ){
            throw new EntityExistsException("Autore already exists" );
        }
        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        try {emailService.sendEmail(request.getEmail(), "Welcome to our blog", "Your account has been created");}
        catch (Exception e) {
            throw new RuntimeException("Error sending email", e);
        }

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
