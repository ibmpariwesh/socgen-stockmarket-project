package socgen.iiht.stockpriceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.stockpriceservice.model.StockPrice;
import socgen.iiht.stockpriceservice.repository.StockPriceRepo;

import java.util.List;

@Service
public class StockPriceService {
    @Autowired
    private StockPriceRepo stockPriceRepo;

    public List<StockPrice> getAllStockPrices(){
        return stockPriceRepo.findAll();
    }

    public void addStockPrice(StockPrice stockPrice){
        stockPriceRepo.save(stockPrice);
    }

}
