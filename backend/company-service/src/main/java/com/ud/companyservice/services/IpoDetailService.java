package com.ud.companyservice.services;

import com.ud.companyservice.entities.IpoDetail;
import com.ud.companyservice.repositories.IpoDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// this is additional (not given in requirements)  used to give crud functionality

@Service
public class IpoDetailService {

    @Autowired
    private IpoDetailRepository ipoDetailRepository;

    public List<IpoDetail> getIpoDetailList() {
        return this.ipoDetailRepository.findAll();
    }
}
