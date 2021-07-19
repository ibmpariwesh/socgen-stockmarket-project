package socgen.iiht.relationshipservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyToIpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int companyId;
    private int ipoId;
    private int stockExchangeId;

    public CompanyToIpo(int companyId, int ipoId, int stockExchangeId) {
        this.companyId = companyId;
        this.ipoId = ipoId;
        this.stockExchangeId = stockExchangeId;
    }

}
