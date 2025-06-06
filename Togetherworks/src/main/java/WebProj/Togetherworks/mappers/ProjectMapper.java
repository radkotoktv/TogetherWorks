package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.ProjectDTO;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Sponsor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Mapping(target="sponsor_name",expression = "java(p.getSponsorName())")
    public ProjectDTO map2DTO(Project p);
    @Mapping(target = "sponsor",source = "s")
    public Project mapDTO(ProjectDTO pdto, Sponsor s);
}
