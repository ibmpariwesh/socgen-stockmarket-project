package socgen.iiht.relationshipservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.relationshipservice.model.CompanyToBoardMember;
import socgen.iiht.relationshipservice.model.CompanyToIpo;
import socgen.iiht.relationshipservice.model.CompanyToSector;
import socgen.iiht.relationshipservice.model.CompanyToStockExchange;
import socgen.iiht.relationshipservice.service.RelationService;

import java.util.List;

@RestController
@RequestMapping("/er_maps")
public class RelationController {
    @Autowired
    private RelationService relationService;

    //Handles company-stock exchange relation

    @GetMapping("/get_company_exchange")
    public List<CompanyToStockExchange> getAllCompanyToExchange(){
        return relationService.getAllCompanyToExchange();
    }

    @GetMapping("/getExchangesForCompany/{id}")
    public List<Integer> exchangesForCompId(@PathVariable int id){
        return relationService.getAllExchangeIdByCompId(id).stream().map((item)-> item.getStockId()).toList();
    }

    @GetMapping("/getCompaniesForExchangeId/{id}")
    public List<Integer> companiesForExchangeId(@PathVariable int id){
        return relationService.getAllCompanyByExchangeId(id).stream().map((item)->item.getCompanyId()).toList();
    }

    @PostMapping("/add_company_exchange")
    public void addCompanyToExchange(@RequestBody CompanyToStockExchange companyToStockExchange){
        relationService.addCompanyToStockExchange(companyToStockExchange);
    }

    @DeleteMapping("/delete_cts_by_company_id/{id}")
    public void deleteCTSByCompanyId(@PathVariable int id){
        relationService.deleteCompanyToStockExchangeByCompanyId(id);
    }

    @DeleteMapping("/delete_cts_by_exchange_id/{id}")
    public void deleteCTSByExchangeId(@PathVariable int id){
        relationService.deleteCompanyToStockExchangeByStockExchangeId(id);
    }

    //handles company to sector relationship

    @GetMapping("/getAllCompanytoSector")
    public List<CompanyToSector> getAllCompanyToSector(){
        return relationService.getAllCompanyToSector();
    }

    @PostMapping("/addCompanyToSector")
    public void addCompanyToSector(@RequestBody CompanyToSector companyToSector){
        relationService.addCompanyToSector(companyToSector);
    }

    @DeleteMapping("/deleteCompanyToSectorByCompanyId/{id}")
    public void deleteCompanyToSectorByCompanyId(@PathVariable int id){
        relationService.deleteCompanyToSectorByCompanyId(id);
    }

    @DeleteMapping("/deleteCompanyToSectorBySectorId/{id}")
    public void deleteCompanyToSectorBySectorId(@PathVariable int id){
        relationService.deleteCompanyToSectorBySectorId(id);
    }

    //handles company to BoardMember relationship

    @GetMapping("/getAllCompanytoBoardMember")
    public List<CompanyToBoardMember> getAllCompanyToBoardMember(){
        return relationService.getAllCompanyToBoardMember();
    }
    @PostMapping("/addCompanyToBoardMember")
    public void addCompanyToBoardMember(@RequestBody CompanyToBoardMember companyToBoardMember){
        relationService.addCompanyToBoardMember(companyToBoardMember);
    }

    @DeleteMapping("/deleteCompanyToBoardMemberByCompanyId/{id}")
    public void deleteCompanyToBoardMemberByCompanyId(@PathVariable int id){
        relationService.deleteCompanyToBoardMemberByCompanyId(id);
    }

    //handles company to Ipo relationship

    @GetMapping("/getAllCompanyToIpo")
    public List<CompanyToIpo> getAllCompanyToIpo(){
        return relationService.getAllCompanyToIpo();
    }

    @PostMapping("/addCompanyToIpo")
    public void addCompanyToIpo(@RequestBody CompanyToIpo companyToIpo){
        relationService.addCompanyToIpo(companyToIpo);
    }

    @DeleteMapping("/deleteCompanyToIpoByIds/{companyId}/{stockExchangeId}")
    public void deleteCompanyToIpoByIds(@PathVariable int companyId,@PathVariable int stockExchangeId){
        relationService.deleteCompanyToIpoByCompanyIdAndExchangeId(companyId,stockExchangeId);
    }

    @DeleteMapping("/deleteCompanyToIpoByCompanyId/{companyId}")
    public void deleteCompanyToIpoByCompanyId(@PathVariable int companyId){
        relationService.deleteCompanyToIpoByCompanyId(companyId);
    }

}
