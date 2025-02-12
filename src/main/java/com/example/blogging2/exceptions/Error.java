package com.example.blogging2.exceptions;

import lombok.Data;

@Data
public class Error {
    private String message;
    private int status;
    private String details;
}
