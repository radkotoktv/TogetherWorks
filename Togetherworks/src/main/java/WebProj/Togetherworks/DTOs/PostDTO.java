package WebProj.Togetherworks.DTOs;


import lombok.Data;

import java.sql.Date;

@Data
public class PostDTO {
    private int idpost;

    private String title;

    private String author;

    private Date date; //which date type?

    private String description;
}
