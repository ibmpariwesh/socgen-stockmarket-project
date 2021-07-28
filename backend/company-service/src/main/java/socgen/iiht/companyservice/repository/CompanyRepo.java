package socgen.iiht.companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.companyservice.model.Company;

import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    public List<Company> findAll();
    public void deleteCompanyById(int id);
    Company findCompanyByName(String name);
    Company findCompanyById(int id);
}
