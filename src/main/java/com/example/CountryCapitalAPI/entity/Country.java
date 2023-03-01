package com.example.CountryCapitalAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
    @Id
    private int id;
    private String countryName;
    private String countryCapital;

    public Country(int id, String countryName, String countryCapital) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCapital='" + countryCapital + '\'' +
                '}';
    }
}
