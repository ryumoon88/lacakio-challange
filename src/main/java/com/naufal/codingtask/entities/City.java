package com.naufal.codingtask.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Locale;

@Entity(name = "cities")
public class City {

    @Id
    private String id;
    private String name;

    @Column(name = "alt_name", columnDefinition = "text")
    private String altName;
    private String admin1;
    private String country;
    private double latitude;
    private double longitude;

    public City() {}

    public City(String id, String name, String admin1, String country, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.admin1 = admin1;
        this.country = country;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        Locale locale = Locale.of("en", country);
        return name + ", " + admin1 + ", " + locale.getDisplayCountry();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
