package WebProj.Togetherworks.models;

import WebProj.Togetherworks.enums.Gender;
import WebProj.Togetherworks.enums.Preference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Volunteers")
@Data
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idvolunteer;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private Gender gender;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Preference preference;
    @JoinColumn(name = "project_id")
    @ManyToOne
    private Project project;
    public String getProjectName(){ //null safe get name method
        if (project == null){
            return "none";
        }

        return project.getName();
    }

}
