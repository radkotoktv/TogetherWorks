package WebProj.Togetherworks.DTOs;

import WebProj.Togetherworks.models.Comment;
import WebProj.Togetherworks.models.Post;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Data
public class CommentDTO {
    private int idcomment;

    private String post_name;

    private String text;

    private String author; //maybe make this of type volunteer?, in db then this would become author_id

    private Date date; //which date type?


}
