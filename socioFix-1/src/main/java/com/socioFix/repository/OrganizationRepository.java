package com.socioFix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,String> {

}
