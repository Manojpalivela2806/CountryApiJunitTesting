package com.example.CountryCapitalAPI.repository;

import com.example.CountryCapitalAPI.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Integer>
{

}
