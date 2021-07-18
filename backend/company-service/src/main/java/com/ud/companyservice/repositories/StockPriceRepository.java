package com.ud.companyservice.repositories;

import com.ud.companyservice.entities.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
