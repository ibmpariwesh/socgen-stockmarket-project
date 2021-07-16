package com.ud.sectorservice.controllers;

import com.ud.sectorservice.entities.Company;
import com.ud.sectorservice.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    public List<Company> getCompanyListForASector(@RequestParam Long sectorId) {
        return this.sectorService.getCompanyListForASector(sectorId);
    }
}
