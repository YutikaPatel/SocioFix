package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Organization;
import com.socioFix.model.Sector;

public interface SectorRepository extends JpaRepository<Sector,Integer> {

}
