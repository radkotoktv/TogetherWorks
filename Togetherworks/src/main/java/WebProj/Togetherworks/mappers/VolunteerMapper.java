package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.VolunteerDTO;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Volunteer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VolunteerMapper {

    @Mapping(target = "project_name", expression = "java(v.getProjectName())")
    public VolunteerDTO map2DTO(Volunteer v);
    @Mapping(target = "project",source = "p")
    public Volunteer mapDTO(VolunteerDTO vdto, Project p);
}
