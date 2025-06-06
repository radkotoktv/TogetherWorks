package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.ResourceDTO;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResourceMapper {
    @Mapping(target = "project_name",expression = "java(r.getProjectName())")
    public ResourceDTO map2DTO(Resource r);
    @Mapping(target = "project",source = "p")
    public Resource mapDTO(ResourceDTO rdto, Project p);
}
