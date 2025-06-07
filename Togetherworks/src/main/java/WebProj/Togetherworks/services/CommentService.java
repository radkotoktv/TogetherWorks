package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.CommentDTO;
import WebProj.Togetherworks.mappers.CommentMapper;

import WebProj.Togetherworks.repositories.CommentRepository;

import WebProj.Togetherworks.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private CommentMapper commentMapper;
    private PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository cr, CommentMapper cm, PostRepository ps){
        this.commentMapper = cm;
        this.commentRepository = cr;
        this.postRepository = ps;
    }
    public CommentDTO getById(int id){
        return commentMapper.map2DTO(commentRepository.getById(id));
    }
    public void createComment(CommentDTO cdto,int idpost, int idparent){
        commentRepository.save(commentMapper.mapDTO(cdto,postRepository.getById(idpost),commentRepository.getById(idparent)));
    }
    public CommentDTO updateComment(CommentDTO cdto){
        return commentMapper.map2DTO(commentRepository.save(commentMapper.mapDTO(cdto,commentRepository.getPostByCommentId(cdto.getIdcomment()),commentRepository.getParentByCommentId(cdto.getIdcomment()))));
    }
    public CommentDTO deleteComment(int id){
        return commentMapper.map2DTO(commentRepository.deleteById(id));
    }
    public List<Integer> getidOfDirectChildren(int id){
        return commentRepository.getChildren(id);
    }
}
