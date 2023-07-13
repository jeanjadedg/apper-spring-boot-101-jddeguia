package com.apper.theblogservice.service;
import com.apper.theblogservice.exception.BloggerNotFoundException;
import com.apper.theblogservice.exception.EmailAlreadyRegisteredException;
import com.apper.theblogservice.model.Blogger;
import com.apper.theblogservice.repository.BloggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloggerService {

    private final BloggerRepository bloggerRepository;

    public BloggerService(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    public Blogger createBlogger(String email, String name, String password) throws EmailAlreadyRegisteredException {

        if (bloggerRepository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredException("Email is already registered");
        }
        Blogger blogger = new Blogger();
        blogger.setEmail(email);
        blogger.setName(name);
        blogger.setPassword(password);

        return bloggerRepository.save(blogger);
    }

    public Blogger getBlogger(String id) throws BloggerNotFoundException {
        Optional<Blogger> bloggerResult = bloggerRepository.findById(id);
        return bloggerResult.orElseThrow(() -> new BloggerNotFoundException("Blogger with this ID does not exist"));
    }

    public List<Blogger> getAllBlogger() {
        return (List<Blogger>) bloggerRepository.findAll();
    }

}