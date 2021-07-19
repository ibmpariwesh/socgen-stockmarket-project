package socgen.iiht.companyservice.model;

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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String ceo;
    @Column(length = 200)
    private String description;
    @Column(length = 10)
    private String stockCode;

    public Company(String name, String ceo, String description, String stockCode) {
        this.name = name;
        this.ceo = ceo;
        this.description = description;
        this.stockCode = stockCode;
    }
}
