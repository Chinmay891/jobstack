package com.jobstack.jobstack.controller;

import com.jobstack.jobstack.model.Application;
import com.jobstack.jobstack.repos.PostRepository;
import com.jobstack.jobstack.model.Post;
import com.jobstack.jobstack.repos.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")                       //Route with a get request
    private List<Post> getAllPosts()
    {
        return repo.findAll();
    }

    @PostMapping("/post")
    private Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    private List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }
}
