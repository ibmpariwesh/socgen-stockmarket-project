package socgen.iiht.stockpriceservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int companyId;
    private int exchangeId;
    private float price;
    private LocalDateTime dateTime;

    public StockPrice(int companyId, int exchangeId, float price, LocalDateTime dateTime) {
        this.companyId = companyId;
        this.exchangeId = exchangeId;
        this.price = price;
        this.dateTime = dateTime;
    }
}
