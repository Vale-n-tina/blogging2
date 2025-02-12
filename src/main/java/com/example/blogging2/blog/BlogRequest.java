package com.example.blogging2.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;

}
