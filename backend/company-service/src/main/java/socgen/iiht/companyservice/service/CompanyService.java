package socgen.iiht.companyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.companyservice.model.Company;
import socgen.iiht.companyservice.repository.CompanyRepo;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> getCompaniesList(){
        return companyRepo.findAll();
    }

    public void addCompany(Company company){
        companyRepo.save(company);

    }

    public void deleteCompany(int id){
        companyRepo.deleteCompanyById(id);
    }
}
