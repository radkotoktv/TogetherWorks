package WebProj.Togetherworks.controllers;

import WebProj.Togetherworks.DTOs.PostDTO;
import WebProj.Togetherworks.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api.TogetherWorks/posts")
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService ps){
        this.postService =ps;
    }
    @GetMapping(path="/all")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.CREATED);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(postService.getById(id),HttpStatus.OK);
    }
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<PostDTO> deleteById(@PathVariable int id){
        return new ResponseEntity<>(postService.deletePostById(id),HttpStatus.OK);
    }


}
