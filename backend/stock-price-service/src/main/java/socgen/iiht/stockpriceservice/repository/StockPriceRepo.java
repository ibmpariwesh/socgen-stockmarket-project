package socgen.iiht.stockpriceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.stockpriceservice.model.StockPrice;

@Repository
public interface StockPriceRepo extends JpaRepository<StockPrice,Integer> {

}
