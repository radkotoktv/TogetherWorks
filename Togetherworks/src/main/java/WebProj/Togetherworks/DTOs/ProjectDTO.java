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
}
