package com.example.blogging2.autore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    public Autore save(Autore autore){
        return autoreRepository.save(autore);
    }



}
