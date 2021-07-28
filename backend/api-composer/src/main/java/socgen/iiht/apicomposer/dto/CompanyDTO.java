package socgen.iiht.apicomposer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    private int id;
    private String name;
    private String ceo;
    private String description;
    private String stockCode;
    private String imageLink;
    private String fetchedSE;

    public CompanyDTO(int id, String name, String ceo, String description, String stockCode, String imageLink, String fetchedSE) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
        this.description = description;
        this.stockCode = stockCode;
        this.imageLink = imageLink;
        this.fetchedSE = fetchedSE;
    }

}
