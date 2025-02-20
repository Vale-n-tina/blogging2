package com.example.blogging2.blog;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class BlogService {
    private final BlogRepository blogRepository;
//
//    public Blog savee(Blog blog){
//        return blogRepository.save(blog);
//    }

    public BlogResponseId save(@Valid BlogRequest request) {
        if (blogRepository.existsByTitolo(request.getTitolo())) {
            throw new EntityExistsException("Titolo già presente");
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(request, blog);


        blogRepository.save(blog);
        BlogResponseId response = new BlogResponseId();

        BeanUtils.copyProperties(blog, response);
        return response;
    }


    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new EntityNotFoundException("Blog non trovato");
        }
        return blogRepository.findById(id).get();
    }

    public BlogResponseComplete modifica(Long id, BlogRequest request) {
        Blog blog = findById(id);
        BeanUtils.copyProperties(request, blog);
        blogRepository.save(blog);
        BlogResponseComplete response = new BlogResponseComplete();
        BeanUtils.copyProperties(blog, response);
        return response;


    }

    public void deleteById(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new EntityNotFoundException("Blog non trovato");

        }
        Blog blog = findById(id);
        blogRepository.deleteById(id);

    }

}
