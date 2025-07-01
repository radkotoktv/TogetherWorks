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
    private String preference;
    @JoinColumn(name = "project_id")
    @ManyToOne
    private Project project;
    public String getProjectName(){ //null safe get name method
        if (project == null){
            return "none";
        }

        return project.getName();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
