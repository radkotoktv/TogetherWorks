package WebProj.Togetherworks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcomment;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
    @Column
    private String text;
    @Column
    private String author; //maybe make this of type volunteer?, in db then this would become author_id
    @Column
    private Date date; //which date type?
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

}
