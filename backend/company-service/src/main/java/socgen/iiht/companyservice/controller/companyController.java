package socgen.iiht.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.companyservice.dto.CompanyDTO;
import socgen.iiht.companyservice.model.Company;
import socgen.iiht.companyservice.service.CompanyService;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class companyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    WebClient.Builder webClientBuilder;

    RestTemplate restTemplate=new RestTemplate();
    @CrossOrigin
    @GetMapping("/get_companies")
    public List<CompanyDTO> getAllCompanies(){
        List<CompanyDTO> dtols=new ArrayList<>();
        List<Company> ls=companyService.getCompaniesList();

        for(Company comp:ls){
            String str =restTemplate.getForObject("http://localhost:8080/api/get_se_string/"+comp.getId(),String.class);
            dtols.add(new CompanyDTO(comp.getId(),comp.getName(),comp.getCeo(),comp.getDescription(), comp.getStockCode(), comp.getImageLink(),str));
        }
        return dtols;
    }


    @PostMapping("/add_company")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping("/deleteCompanyById/{id}")
    @Transactional
    public void deleteCompany(@PathVariable int id){
        companyService.deleteCompany(id);
        //cascade all relations
        try {
            webClientBuilder.build()
                    .delete()
                    .uri("http://RELATIONSHIP-SERVICE/er_maps/delete_cts_by_company_id/"+id)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block(Duration.ofMillis(500));

            webClientBuilder.build()
                    .delete()
                    .uri("http://RELATIONSHIP-SERVICE/er_maps/deleteCompanyToSectorByCompanyId/"+id)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block(Duration.ofMillis(500));

            webClientBuilder.build().
                    delete()
                    .uri("http://RELATIONSHIP-SERVICE/er_maps/deleteCompanyToBoardMemberByCompanyId/"+id)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block(Duration.ofMillis(500));
            webClientBuilder.build().
                    delete()
                    .uri("http://RELATIONSHIP-SERVICE/er_maps/deleteCompanyToIpoBycompanyId/"+id)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block(Duration.ofMillis(500));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @PostMapping("/update_company")
    public void updateCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }
}
