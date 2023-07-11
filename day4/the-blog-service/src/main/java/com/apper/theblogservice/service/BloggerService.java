package com.apper.theblogservice.service;

import com.apper.theblogservice.model.Blogger;
import com.apper.theblogservice.repository.BloggerRepository;
import org.springframework.stereotype.Service;

@Service
public class BloggerService {

    private final BloggerRepository bloggerRepository;

    public BloggerService(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    public Blogger createBlogger(String name, String email, String password) {
        Blogger blogger = new Blogger();
        blogger.setName(name);
        blogger.setEmail(email);
        blogger.setPassword(password);

        return bloggerRepository.save(blogger);
    }
}
