package socgen.iiht.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import socgen.iiht.companyservice.model.Company;
import socgen.iiht.companyservice.service.CompanyService;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/company")
public class companyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/get_companies")
    public List<Company> getAllCompanies(){
        return companyService.getCompaniesList();
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
        webClientBuilder.build()
                .delete()
                .uri("http://localhost:6063/er_maps/delete_cts_by_company_id/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(Duration.ofSeconds(2));

        webClientBuilder.build()
                .delete()
                .uri("http://localhost:6063/er_maps/deleteCompanyToSectorByCompanyId/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(Duration.ofSeconds(2));

        webClientBuilder.build().
                delete()
                .uri("http://localhost:6063/er_maps/deleteCompanyToBoardMemberByCompanyId/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(Duration.ofSeconds(2));
        webClientBuilder.build().
                delete()
                .uri("http://localhost:6063/er_maps/deleteCompanyToIpoBycompanyId/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(Duration.ofSeconds(2));

    }
}
