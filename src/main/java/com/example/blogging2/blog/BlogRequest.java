package com.example.blogging2.blog;

import com.example.blogging2.autore.Autore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
    @NotBlank(message = "la categoria è  obbligatoria")
    private String categoria;
    @NotBlank(message = "Il titolo è obbligatorio"  )
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    @NotNull (message = "L'autore è obbligatorio")
    private Long autoreId;
    private String avatar;

}
