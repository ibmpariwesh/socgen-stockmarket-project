package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
