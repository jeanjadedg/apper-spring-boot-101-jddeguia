package com.apper.theblogservice;

import com.apper.theblogservice.model.Blog;
import com.apper.theblogservice.model.Blogger;
import com.apper.theblogservice.payload.*;
import com.apper.theblogservice.service.BlogService;
import com.apper.theblogservice.service.BloggerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogApi {

    private final BlogService blogService;
    private final BloggerService bloggerService;

    public BlogApi(BlogService blogService, BloggerService bloggerService) {
        this.blogService = blogService;
        this.bloggerService = bloggerService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBlogResponse createBlog(@RequestBody @Valid CreateBlogRequest request) {
        Blog createdBlog = blogService.createBlog(request.getTitle(), request.getTitle(), request.getBloggerId());

        CreateBlogResponse response = new CreateBlogResponse();
        response.setId(createdBlog.getId());
        response.setBloggerId(createdBlog.getBloggerId().getId());
        response.setDateCreated(createdBlog.getCreatedAt());
        response.setLastUpdated(createdBlog.getCreatedAt());

        return response;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogDetails blogDetails(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);

        BlogDetails blogDetails = new BlogDetails();
        blogDetails.setBloggerId(blog.getBloggerId().getId());
        blogDetails.setTitle(blog.getTitle());
        blogDetails.setBody(blog.getBody());
        blogDetails.setCreatedDate(blog.getCreatedAt());
        blogDetails.setUpdatedDate(blog.getLastUpdated());
        return blogDetails;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BlogDetails> getAllDetails () {
        List<Blog> blogList = blogService.getAllBlogs();
        List<BlogDetails> blogDetails = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogDetails response = new BlogDetails();
            response.setTitle(blog.getTitle());
            response.setBody(blog.getBody());
            response.setBloggerId(blog.getBloggerId().getId());
            response.setCreatedDate(blog.getCreatedAt());
            response.setUpdatedDate(blog.getLastUpdated());
            blogDetails.add(response);
        }
        return blogDetails;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CreateBlogResponse blogResponse(@PathVariable String id, @RequestBody @Valid UpdateBlogRequest request) {
        System.out.println(request);
        Blog blog = blogService.updateBlog(id, request.getTitle(), request.getBody());
        CreateBlogResponse response = new CreateBlogResponse();
        response.setId(blog.getId());
        response.setBloggerId(blog.getBloggerId().getId());
        response.setDateCreated(blog.getCreatedAt());
        response.setLastUpdated(LocalDateTime.now());
        return response;
    }

    @GetMapping("blogger/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BlogBloggerDetails> getAllDetails (@PathVariable String id) {
        List<Blog> blogList = blogService.getAllBlogsByBlogger(id);

        List<BlogBloggerDetails> blogDetails = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogBloggerDetails blogBloggerDetails = new BlogBloggerDetails();
            blogBloggerDetails.setTitle(blog.getTitle());
            blogBloggerDetails.setBody(blog.getBody());
            blogBloggerDetails.setCreatedDate(blog.getCreatedAt());
            blogBloggerDetails.setUpdatedDate(blog.getLastUpdated());
            blogDetails.add(blogBloggerDetails);
        }
        return blogDetails;
    }
}
