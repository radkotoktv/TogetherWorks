package WebProj.Togetherworks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name="Posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idpost;
    @Column
    private String title;
    @Column
    private String author; //maybe make this of type volunteer?, in db then this would become author_id
    @Column
    private Date date; //which date type?
    @Column
    private String description; //?character type?
}
