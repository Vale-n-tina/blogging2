package com.example.blogging2.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogPost")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog findById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseId save(@RequestBody BlogRequest request) {
        return blogService.save(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogResponseComplete modifica(@PathVariable Long id,@RequestBody BlogRequest request){
        return blogService.modifica(id, request);
    }
   @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        blogService.deleteById(id);

   }
}
