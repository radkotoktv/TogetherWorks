package WebProj.Togetherworks.DTOs;

import WebProj.Togetherworks.enums.Gender;
import WebProj.Togetherworks.enums.Preference;

import lombok.Data;

@Data
public class VolunteerDTO {

    private String first_name;

    private String last_name;

    private Gender gender;

    private String email;

    private String username;

    private Preference preference; //might just change this to string(only in the dto)

    private String project_name;
}
