package com.apper.theblogservice.service;
import com.apper.theblogservice.model.Blog;
import com.apper.theblogservice.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final BloggerService bloggerService;

    public BlogService(BlogRepository blogRepository, BloggerService bloggerService) {
        this.blogRepository = blogRepository;
        this.bloggerService = bloggerService;
    }

    public Blog createBlog(String title, String body, String bloggerId) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);
        blog.setBloggerId(bloggerService.getBlogger(bloggerId));

        return blogRepository.save(blog);

    }

    public Blog getBlog(String id) {
        Optional<Blog> bloggerResult = blogRepository.findById(id);
        return bloggerResult.get();
    }

    public List<Blog> getAllBlogs () {
        return (List<Blog>) blogRepository.findAll();
    }

    public Blog updateBlog(String id, String title, String body) {
        Blog blog = getBlog(id);
        blog.setTitle(title);
        blog.setBody(body);
        blog.setLastUpdated(blog.getLastUpdated());
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogsByBlogger (String id) {
        return blogRepository.findAllByBloggerId_Id(id);
    }
}
