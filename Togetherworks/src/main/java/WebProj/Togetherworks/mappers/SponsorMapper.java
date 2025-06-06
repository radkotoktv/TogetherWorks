package WebProj.Togetherworks.mappers;

import WebProj.Togetherworks.DTOs.SponsorDTO;
import WebProj.Togetherworks.models.Sponsor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SponsorMapper {
    public SponsorDTO map2DTO(Sponsor s);
    public Sponsor mapDTO(SponsorDTO sdto);
}
