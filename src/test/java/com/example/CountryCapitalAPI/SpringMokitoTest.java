package com.example.CountryCapitalAPI;

import com.example.CountryCapitalAPI.entity.Country;
import com.example.CountryCapitalAPI.repository.CountryRepo;
import com.example.CountryCapitalAPI.service.CountryService;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {SpringMokitoTest.class})
public class SpringMokitoTest
{
    @Mock
    CountryRepo countryRepo;
    @InjectMocks
    CountryService countryService;

    @Test
    @Order(1)
    public void Test_getAll()
    {
        List<Country> mycountries=new ArrayList<>();
        mycountries.add(new Country(1,"japan","tokyo"));
        mycountries.add(new Country(2,"italy","rome"));
        Mockito.when(countryRepo.findAll()).thenReturn(mycountries);//Mocking
        Assertions.assertEquals(2,countryService.getAllCountries().size());
    }
    @Test
    @Order(2)
    public void Test_getById()
    {
        List<Country> mycountries=new ArrayList<Country>();
        mycountries.add(new Country(1,"japan","tokyo"));
        mycountries.add(new Country(2,"italy","rome"));
        int countryId=1;
        Mockito.when(countryRepo.findAll()).thenReturn(mycountries);//mocking
        Assertions.assertEquals(countryId,countryService.getCountryById(countryId).getId());
    }
    @Test
    @Order(3)
    public void Test_getByName()
    {
        List<Country> mycountries=new ArrayList<Country>();
        mycountries.add(new Country(1,"japan","tokyo"));
        mycountries.add(new Country(2,"italy","rome"));
        String countryName="japan";
        Mockito.when(countryRepo.findAll()).thenReturn(mycountries);//mocking
        Assertions.assertEquals(countryName,countryService.getCountryByName(countryName).getCountryName());
    }
    @Test
    @Order(4)
    public void Test_add()
    {
        Country country = new Country(3,"Germany","Berlin");
        Mockito.when(countryRepo.save(country)).thenReturn(country);
        Assertions.assertEquals(country,countryService.addCountry(country));
    }
    @Test
    @Order(5)
    public void Test_update()
    {
        Country country = new Country(3,"Germany","Berlin");
        Mockito.when(countryRepo.save(country)).thenReturn(country);
        Assertions.assertEquals(country,countryService.updateCountry(country));
    }
    @Test
    @Order(6)
    public void Test_delete()
    {
        Country country = new Country(3,"Germany","Berlin");
        countryService.deleteCountry(country);
        Mockito.verify(countryRepo,Mockito.times(1)).delete(country);
    }


}
