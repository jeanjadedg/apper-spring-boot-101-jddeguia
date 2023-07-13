package com.apper.theblogservice.service;
import com.apper.theblogservice.exception.BlogNotFoundException;
import com.apper.theblogservice.exception.BloggerNotFoundException;
import com.apper.theblogservice.model.Blog;
import com.apper.theblogservice.repository.BlogRepository;
import com.apper.theblogservice.repository.BloggerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final BloggerService bloggerService;
    private final BloggerRepository bloggerRepository;

    public BlogService(BlogRepository blogRepository, BloggerService bloggerService, BloggerRepository bloggerRepository) {
        this.blogRepository = blogRepository;
        this.bloggerService = bloggerService;
        this.bloggerRepository = bloggerRepository;
    }

    public Blog createBlog(String title, String body, String bloggerId) throws BloggerNotFoundException {
        if(!blogRepository.existsById(bloggerId)) {
            throw new BloggerNotFoundException("Blogger with this ID does not exist");
        }
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);
        blog.setBloggerId(bloggerService.getBlogger(bloggerId));

        return blogRepository.save(blog);

    }

    public Blog getBlog(String id) throws BlogNotFoundException {
        Optional<Blog> bloggerResult = blogRepository.findById(id);
        return bloggerResult.orElseThrow(() -> new BlogNotFoundException("Blog with this ID does not exist"));
    }

    public List<Blog> getAllBlogs () {
        return (List<Blog>) blogRepository.findAll();
    }

    public Blog updateBlog(String id, String title, String body) throws BlogNotFoundException {
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
