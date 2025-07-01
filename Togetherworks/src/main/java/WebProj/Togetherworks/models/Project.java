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
    private int id;
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

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setMoney_needed(Double money_needed) {
        this.money_needed = money_needed;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
