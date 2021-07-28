package socgen.iiht.stockexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.stockexchangeservice.model.StockExchange;
import socgen.iiht.stockexchangeservice.repository.StockExchangeRepo;
import socgen.iiht.stockexchangeservice.service.StockExchangeService;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/stock_exchange")
public class StockExchangeController {
    @Autowired
    private StockExchangeService stockExchangeService;
    @Autowired
    private StockExchangeRepo repo;
    @Autowired
    WebClient.Builder webClientBuilder;
    @GetMapping("/get_all")
    public List<StockExchange> getStockExchanges(){
        return stockExchangeService.getAllExchanges();
    }

    @GetMapping("/getById/{id}")
    public StockExchange getStockExchangebyId(@PathVariable int id){
        return stockExchangeService.getExchangeById(id);
    }

    @GetMapping("/getByName/{name}")
    public StockExchange getStockExchangeByName(@PathVariable String name){
        return repo.getStockExchangeByName(name);
    }

    @GetMapping("/getName/{id}")
    public String getName(@PathVariable int id){
        return repo.findStockExchangeById(id).getName();
    }

    @PostMapping("/add_exchange")
    public void addStockExchange(@RequestBody StockExchange stockExchange){
        stockExchangeService.postStockExchange(stockExchange);
    }

    @PostMapping("/update_exchange")
    public void updateStockExchange(@RequestBody StockExchange stockExchange){
        stockExchangeService.updateStockExchange(stockExchange);
    }

    @DeleteMapping("/deleteId/{id}")
    @Transactional
    public void deleteStockExchangeById(@PathVariable int id){
        webClientBuilder.build()
                .delete()
                .uri("http://localhost:6063/er_maps/delete_cts_by_exchange_id/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(Duration.ofSeconds(2));
        stockExchangeService.deleteExchangeById(id);
    }
}
