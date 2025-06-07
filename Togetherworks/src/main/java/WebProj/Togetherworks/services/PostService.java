package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.PostDTO;
import WebProj.Togetherworks.mappers.PostMapper;
import WebProj.Togetherworks.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private PostMapper postMapper;
    @Autowired
    public PostService(PostRepository ps, PostMapper pm){
        this.postRepository = ps;
        this.postMapper =pm;
    }
    public void createPost(PostDTO pdto){
        postRepository.save(postMapper.mapDTO(pdto));
    }
    public  PostDTO deletePostById(int id){
        return postMapper.map2DTO(postRepository.deleteById(id));
    }
    public List<PostDTO> getAllPosts(){
        return postRepository.findAll().stream().map(postMapper::map2DTO).toList();
    }
    public PostDTO getById(int id){
        return postMapper.map2DTO(postRepository.getById(id));
    }
}
