package com.example.blogging2.autore;

import com.example.blogging2.blog.Blog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataNascita;
    private String avatar;
    @OneToMany(mappedBy = "autore")
    @JsonIgnoreProperties("autore")
    private List<Blog> blogs;

    public Autore(String nome, Date dataNascita, String email, String cognome) {
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.email = email;
        this.cognome = cognome;
    }
}
