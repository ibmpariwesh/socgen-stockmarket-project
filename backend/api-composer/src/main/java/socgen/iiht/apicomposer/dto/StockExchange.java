package socgen.iiht.apicomposer.dto;

import lombok.Getter;

@Getter
public class StockExchange {
    private int id;
    private String name;
    private String brief;
    private Address address;
    private String remarks;
}
