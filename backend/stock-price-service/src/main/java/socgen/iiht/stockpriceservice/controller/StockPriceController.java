package socgen.iiht.stockpriceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.stockpriceservice.model.StockPrice;
import socgen.iiht.stockpriceservice.service.StockPriceService;

import java.util.List;

@RestController
@RequestMapping("/stockPrices")
public class StockPriceController {
    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping("/getAllStockPrices")
    public List<StockPrice> getAllStockPrices(){
        return stockPriceService.getAllStockPrices();
    }

    @PostMapping("/add-stock-price")
    public void addStockPrice(@RequestBody StockPrice stockPrice){
        stockPriceService.addStockPrice(stockPrice);
    }

}
