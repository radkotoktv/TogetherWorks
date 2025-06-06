package WebProj.Togetherworks.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "Sponsors")
@Data
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idsponsor;
    @Getter
    @Column
    private String name;
    @Column
    private Double amount;
}
