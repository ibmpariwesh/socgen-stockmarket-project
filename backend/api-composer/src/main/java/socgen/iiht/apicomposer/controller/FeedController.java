package socgen.iiht.apicomposer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.apicomposer.dto.CompanyDTO;
import socgen.iiht.apicomposer.dto.StockExchange;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FeedController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get_se_string/{id}")
    public String getExString(@PathVariable int id){
        String str="";
        List<Integer> ls= restTemplate.getForObject("http://localhost:6063/er_maps/getExchangesForCompany/"+id, List.class);
        int itr=0;
        String temp;
        System.out.println(ls);
        for(int exId:ls){
            if(exId%2==0)continue;
            if(itr!=0 && itr<ls.size()) {
                str+=",";
            }
            if(exId==0)return str;
           temp=restTemplate.getForObject("http://localhost:6060/stock_exchange/getName/"+ exId, String.class);
//            System.out.println(temp);
            if(temp!=null){
                str+=temp;
            }
            itr++;
        }
        return str;
    }
    @GetMapping("/getCompForEx/{id}")
    public List<CompanyDTO> getCompanyForEx(@PathVariable String id){
        List<CompanyDTO> dtols=new ArrayList<>();
        List<Integer> ls= restTemplate.getForObject("http://localhost:6063/er_maps/getCompaniesForExchangeId/"+id, List.class);
        CompanyDTO companyDTO;
        System.out.println(ls);
        for(int cid:ls){

            companyDTO=restTemplate.getForObject("http://localhost:6061/company/getCompanyById/"+ cid, CompanyDTO.class);
            dtols.add(companyDTO);
        }
        return dtols;
    }
}
