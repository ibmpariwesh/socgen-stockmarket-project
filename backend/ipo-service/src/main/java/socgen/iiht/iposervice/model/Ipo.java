package socgen.iiht.iposervice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float pricePerShare;
    private int totalShares;
    private LocalDateTime dateTime;
    private String description;

    public Ipo(float pricePerShare, int totalShares, LocalDateTime dateTime, String description) {
        this.pricePerShare = pricePerShare;
        this.totalShares = totalShares;
        this.dateTime = dateTime;
        this.description = description;
    }
}
