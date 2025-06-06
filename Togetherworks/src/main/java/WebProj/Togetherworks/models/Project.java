package WebProj.Togetherworks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idproject;
    @Column
    private String name;
    @Column
    private String owner;
    @Column
    private Double money_needed;
    @Column
    private Date start_date; //java.util.Date or java.sql.Date?
    @Column
    private Date end_date;   //Ditto
    @ManyToOne
    @JoinColumn(name="sponsor")
    private Sponsor sponsor;
    public String getSponsorName(){ //null safe get name method
        if (sponsor == null){
            return "none";
        }

        return sponsor.getName();
    }

}
