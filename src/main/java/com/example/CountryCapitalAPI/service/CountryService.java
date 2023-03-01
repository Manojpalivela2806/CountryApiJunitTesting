package com.example.CountryCapitalAPI.service;

import com.example.CountryCapitalAPI.entity.Country;
import com.example.CountryCapitalAPI.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;
    public List getAllCountries()
    {
       return countryRepo.findAll();
    }
    public Country getCountryById(int id)
    {
        List<Country> countries=countryRepo.findAll();
        Country country= null;
        for(Country con:countries)
        {
            if(con.getId()==id)
                country=con;
        }
        return country;
    }
    public Country getCountryByName(String countryName)
    {
        List<Country> countries=countryRepo.findAll();
        Country country= null;
        for(Country con:countries)
        {
            if(con.getCountryName().equalsIgnoreCase(countryName))
                country=con;
        }
        return country;
    }
    public Country addCountry(Country country)
    {
        country.setId(getMaxId());
        countryRepo.save(country);
        return country;
    }
    public int getMaxId()
    {
        return countryRepo.findAll().size()+1;
    }
    public Country updateCountry(Country country)
    {
        countryRepo.save(country);
        return country;
    }
    public AddResponse deleteCountry(int id)
    {
        countryRepo.deleteById(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMessage("Country deleted");
        addResponse.setId(id);
        return addResponse;
    }
}
