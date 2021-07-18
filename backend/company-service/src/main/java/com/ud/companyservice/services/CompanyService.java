package com.ud.companyservice.services;

import com.ud.companyservice.dtos.CompanyDto;
import com.ud.companyservice.entities.Company;
import com.ud.companyservice.entities.Sector;
import com.ud.companyservice.repositories.CompanyRepository;
import com.ud.companyservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private SectorRepository sectorRepository;

    public Company getCompanyById(Long companyId) {
        return this.companyRepository.findById(companyId).get();
    }

    // additional service methods not mentioned in project report

    public List<Company> getCompanyList() {
        return this.companyRepository.findAll();
    }

    public Company addCompany(CompanyDto companyDto) {
        Company company = DtotoEntity(companyDto);
        return this.companyRepository.save(company);
    }

    public Company updateCompany(CompanyDto companyDto) {
        Company company = DtotoEntity(companyDto);
        return this.companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        this.companyRepository.deleteById(companyId);
    }

    public Company DtotoEntity(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setTurnover(companyDto.getTurnover());
        company.setCeo(companyDto.getCeo());
        company.setBrief(companyDto.getBrief());
        company.setSector(this.sectorRepository.findById(companyDto.getSectorId()).get());

        return company;
    }

}
