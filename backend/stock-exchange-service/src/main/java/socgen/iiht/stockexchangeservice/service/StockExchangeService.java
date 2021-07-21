package socgen.iiht.stockexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.stockexchangeservice.model.StockExchange;
import socgen.iiht.stockexchangeservice.repository.StockExchangeRepo;

import java.util.List;

@Service
public class StockExchangeService {
    @Autowired
    StockExchangeRepo stockExchangeRepo;

    public List<StockExchange> getAllExchanges(){
        return stockExchangeRepo.findAll();
    }

    public StockExchange getExchangeById(int id){
        return stockExchangeRepo.findStockExchangeById(id);
    }

    public void postStockExchange(StockExchange stockExchange){
        stockExchangeRepo.save(stockExchange);
    }

    public void updateStockExchange(StockExchange stockExchange){
        stockExchangeRepo.save(stockExchange);
    }

    public void deleteExchangeById(int id){
        stockExchangeRepo.deleteById(id);
    }
}
