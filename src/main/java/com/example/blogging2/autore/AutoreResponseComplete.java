package com.example.blogging2.autore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreResponseComplete {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private Date dataNascita;
    private String avatar;
}
