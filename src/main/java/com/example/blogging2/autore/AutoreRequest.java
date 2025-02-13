package com.example.blogging2.autore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutoreRequest {
    @NotNull
    @NotBlank(message = "Nome non può essere vuoto")
    private String nome;
    @NotBlank(message = "Cognome non può essere vuoto")
    @NotNull
    private String cognome;
    @Email(message = "Email non valida")
    private String email;
    @Past(message = "Data di nascita non può essere una data futura")
    private Date dataNascita;
    private String avatar;

}
