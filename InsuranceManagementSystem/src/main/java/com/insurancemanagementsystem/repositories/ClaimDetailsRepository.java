package com.insurancemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemanagementsystem.entity.ClaimDetails;

public interface ClaimDetailsRepository extends JpaRepository<ClaimDetails, Integer> {

}
