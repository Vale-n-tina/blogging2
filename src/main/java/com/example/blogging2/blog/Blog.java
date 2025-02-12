package com.example.blogging2.blog;


import com.example.blogging2.autore.Autore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover="https://picsum.photo/200/300";
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JsonIgnoreProperties("blogs")
    private Autore autore;

    public Blog(String categoria, String titolo, String contenuto, int tempoDiLettura, Autore autore) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.autore = autore;
    }
}
