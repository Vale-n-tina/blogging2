package com.example.blogging2.autore;

import com.example.blogging2.blog.Blog;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor

public class AutoreController {
    private final AutoreService autoreService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoreService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AutoreResponseComplete findById(@PathVariable Long id) {
        return autoreService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreResponseId create(@RequestBody AutoreRequest request) {
        return autoreService.create(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AutoreResponseComplete update(@PathVariable Long id, @RequestBody AutoreRequest request) {
        return autoreService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
