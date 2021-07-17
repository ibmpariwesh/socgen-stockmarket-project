package com.ud.companyservice.services;

import com.ud.companyservice.entities.Company;
import com.ud.companyservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    public Company getCompanyById(Long companyId) {
        return this.companyRepository.getById(companyId);
    }

    // additional service methods not mentioned in project report
    public Company addCompany(Company company) {
        return this.companyRepository.save(company);
    }

    public Company updateCompany(Company company) {
        return this.companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        this.companyRepository.deleteById(companyId);
    }

}
