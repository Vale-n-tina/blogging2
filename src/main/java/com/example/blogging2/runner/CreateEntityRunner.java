package com.example.blogging2.runner;

import com.example.blogging2.autore.AutoreService;
import com.example.blogging2.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateEntityRunner implements CommandLineRunner {
    private final AutoreService autoreService;
    private final BlogService blogService;

    @Override
    public void run(String... args) throws Exception {

//        Blog blog = new Blog("Gossip", "falsissimo", "contenuto interessante", 6);
//
//        Blog blog1 = new Blog("Segreto Esclusivo", "sensazionalista", "Un famoso cantante sta per rivelare un segreto che potrebbe cambiare il mondo della musica. Chissà di cosa si tratta?", 9);
//        Blog blog2 = new Blog("Storie Incredibili", "rumoroso", "Secondo voci non confermate, una popolare star dei social media è stata vista in compagnia di una persona misteriosa. Chi sarà?", 7);
//        Blog blog3 = new Blog("Retroscena Curiosi", "incredibile", "I fan sono scossi dopo aver appreso che una delle celebrità più amate sta per abbandonare il suo lavoro per una nuova carriera.", 6);
//        Blog blog4 = new Blog("Dietro le Quinte", "spettacolare", "Un grande attore di Hollywood sarebbe coinvolto in una controversia legale. Le informazioni ufficiali sono ancora scarse.", 8);
//        Blog blog5 = new Blog("Tendenze Segrete", "polemico", "Un famoso marchio di moda ha lanciato una collezione misteriosa, ma nessuno sa cosa ci sia davvero dietro. Possibile collaborazione segreta?", 10);
//        blogService.save(blog);
//        blogService.save(blog1);
//        blogService.save(blog2);
//        blogService.save(blog3);
//        blogService.save(blog4);
//        blogService.save(blog5);
//
//
//        Autore autore1 = new Autore("Marco", new Date(1990, 5, 15), "marco.email@example.com", "Rossi");
//        Autore autore2 = new Autore("Lucia", new Date(1985, 7, 30), "lucia.email@example.com", "Bianchi");
//        Autore autore3 = new Autore("Giovanni", new Date(1992, 11, 22), "giovanni.email@example.com", "Verdi");
//        Autore autore4 = new Autore("Sara", new Date(1988, 3, 10), "sara.email@example.com", "Neri");
//        Autore autore5 = new Autore("Alessandro", new Date(1983, 9, 5), "alessandro.email@example.com", "Gialli");
//        autoreService.save(autore1);
//        autoreService.save(autore2);
//        autoreService.save(autore3);
//        autoreService.save(autore4);
//        autoreService.save(autore5);

    }


}