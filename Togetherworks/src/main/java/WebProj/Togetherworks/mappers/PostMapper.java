package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.PostDTO;
import WebProj.Togetherworks.models.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    public PostDTO map2DTO(Post p);
    public Post mapDTO(PostDTO pdto);
}
