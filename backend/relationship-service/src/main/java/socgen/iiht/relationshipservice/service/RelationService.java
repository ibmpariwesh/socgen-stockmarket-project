package socgen.iiht.relationshipservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socgen.iiht.relationshipservice.model.CompanyToBoardMember;
import socgen.iiht.relationshipservice.model.CompanyToIpo;
import socgen.iiht.relationshipservice.model.CompanyToSector;
import socgen.iiht.relationshipservice.model.CompanyToStockExchange;
import socgen.iiht.relationshipservice.repository.CompanyToBoardMemberRepo;
import socgen.iiht.relationshipservice.repository.CompanyToIpoRepo;
import socgen.iiht.relationshipservice.repository.CompanyToSectorRepo;
import socgen.iiht.relationshipservice.repository.CompanyToStockExchangeRepo;

import java.util.List;

@Service
public class RelationService {
    @Autowired
    private CompanyToStockExchangeRepo companyToStockExchangeRepo;
    @Autowired
    private CompanyToSectorRepo companyToSectorRepo;
    @Autowired
    private CompanyToBoardMemberRepo companyToBoardMemberRepo;
    @Autowired
    private CompanyToIpoRepo companyToIpoRepo;
    //company-stock exchange service handling

    public List<CompanyToStockExchange> getAllCompanyToExchange(){
        return companyToStockExchangeRepo.findAll();
    }
    public void addCompanyToStockExchange(CompanyToStockExchange companyToStockExchange){
        companyToStockExchangeRepo.save(companyToStockExchange);
    }
    @Transactional
    public void deleteCompanyToStockExchangeByCompanyId(int id){
        companyToStockExchangeRepo.deleteAllByCompanyId(id);
    }
    @Transactional
    public void deleteCompanyToStockExchangeByStockExchangeId(int id){
        companyToStockExchangeRepo.deleteAllByStockId(id);
    }

    //company-sector service handling
    public List<CompanyToSector> getAllCompanyToSector(){
        return companyToSectorRepo.findAll();
    }

    public void addCompanyToSector(CompanyToSector companyToSector){
        companyToSectorRepo.save(companyToSector);
    }

    @Transactional
    public void deleteCompanyToSectorByCompanyId(int id){
        companyToSectorRepo.deleteAllByCompanyId(id);
    }

    @Transactional
    public void deleteCompanyToSectorBySectorId(int id){
        companyToSectorRepo.deleteAllBySectorId(id);
    }

    //company-boardMember-service Handling

    public List<CompanyToBoardMember> getAllCompanyToBoardMember(){
        return companyToBoardMemberRepo.findAll();
    }


    public void addCompanyToBoardMember(CompanyToBoardMember companyToBoardMember){
        companyToBoardMemberRepo.save(companyToBoardMember);
    }

    @Transactional
    public void deleteCompanyToBoardMemberByCompanyId(int id){
        companyToBoardMemberRepo.deleteAllByCompanyId(id);
    }

    //company-IPO-service Handling

    public List<CompanyToIpo> getAllCompanyToIpo(){
        return companyToIpoRepo.findAll();
    }

    public void addCompanyToIpo(CompanyToIpo companyToIpo){
        companyToIpoRepo.save(companyToIpo);
    }

    @Transactional
    public void deleteCompanyToIpoByCompanyId(int companyId){
        companyToIpoRepo.deleteAllByCompanyId(companyId);
    }
    @Transactional
    public void deleteCompanyToIpoByCompanyIdAndExchangeId(int companyId,int stockExchangeId){
        companyToIpoRepo.deleteAllByCompanyIdAndStockExchangeId(companyId,stockExchangeId);
    }

}
