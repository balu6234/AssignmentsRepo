package com.insurancemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemanagementsystem.entity.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

}
