package socgen.iiht.stockexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockExchange {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(length = 28,unique = true)
    private String name;
    @Column(length = 28)
    private String brief;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @Column(length = 50)
    private String remarks;

    public StockExchange(String name, String brief, Address address, String remarks) {
        this.name = name;
        this.brief = brief;
        this.address = address;
        this.remarks = remarks;
    }
}
