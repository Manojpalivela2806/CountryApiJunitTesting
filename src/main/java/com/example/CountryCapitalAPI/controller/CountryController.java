package com.example.CountryCapitalAPI.controller;

import com.example.CountryCapitalAPI.entity.Country;
import com.example.CountryCapitalAPI.service.AddResponse;
import com.example.CountryCapitalAPI.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping("/get")
    public List<Country>get()
    {
        return countryService.getAllCountries();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Country>getById(@PathVariable(value = "id")int id)
    {
        try {
            Country country= countryService.getCountryById(id);
            return new ResponseEntity<Country>(country, HttpStatus.FOUND);
        }
        catch(Exception e){
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("/get/countryName")
    public ResponseEntity<Country> getByName(@RequestParam(value = "name")String countryName)
    {
        try {
            Country country= countryService.getCountryByName(countryName);
            return new ResponseEntity<Country>(country, HttpStatus.FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public Country add(@RequestBody Country country)
    {
        return countryService.addCountry(country);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Country> update(@PathVariable(value = "id")int id, @RequestBody Country country)
    {
        try {
            Country existCountry=countryService.getCountryById(id);

            existCountry.setCountryName(country.getCountryName());
            existCountry.setCountryCapital(country.getCountryCapital());

            Country update_country=countryService.updateCountry(existCountry);
            return new ResponseEntity<Country>(update_country,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/delete/{id}")
    public AddResponse delete(@PathVariable(value = "id")int id)
    {
        return countryService.deleteCountry(id);
    }
}
