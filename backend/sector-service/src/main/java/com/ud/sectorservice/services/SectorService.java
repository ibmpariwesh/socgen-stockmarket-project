package com.ud.sectorservice.services;

import com.ud.sectorservice.entities.Company;
import com.ud.sectorservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanyListForASector(Long sectorId) {
        return this.companyRepository.findCompaniesBySector_Id(sectorId);
    }

}
