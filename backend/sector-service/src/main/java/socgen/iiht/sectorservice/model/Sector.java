package socgen.iiht.sectorservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 25)
    private String name;
    @Column(length = 100)
    private String description;

    public Sector(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
