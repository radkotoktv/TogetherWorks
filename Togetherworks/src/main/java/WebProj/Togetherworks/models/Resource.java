package WebProj.Togetherworks.models;

import WebProj.Togetherworks.enums.Type;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Resources")
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idresource;
    @Column
    private Type type;
    @Column
    private int quantity;
    @OneToOne
    @JoinColumn(name ="project_id")
    private Project project;
    public String getProjectName(){ //null safe get name method
        if (project == null){
            return "none";
        }

        return project.getName();
    }
}
