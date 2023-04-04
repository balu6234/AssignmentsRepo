package com.insurancemanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancemanagementsystem.entity.ClientDetails;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Integer> {

}
