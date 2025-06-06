package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.CommentDTO;
import WebProj.Togetherworks.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "post_name",expression = "java(c.getPost().getTitle())")
    public CommentDTO map2DTO(Comment c );

}
