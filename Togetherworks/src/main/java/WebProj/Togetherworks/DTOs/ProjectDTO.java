package WebProj.Togetherworks.DTOs;


import lombok.Data;

import java.sql.Date;

@Data
public class ProjectDTO {

    private String name;

    private String owner;

    private Double money_needed;

    private Date start_date; //java.util.Date or java.sql.Date?

    private Date end_date;   //Ditto

    private String sponsor_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getMoney_needed() {
        return money_needed;
    }

    public void setMoney_needed(Double money_needed) {
        this.money_needed = money_needed;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }
}
