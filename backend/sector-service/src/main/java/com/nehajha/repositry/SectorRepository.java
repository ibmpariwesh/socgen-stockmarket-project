package com.nehajha.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nehajha.entity.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

}