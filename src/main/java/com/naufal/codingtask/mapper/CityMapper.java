package com.naufal.codingtask.mapper;

import com.naufal.codingtask.dto.CityDTO;
import com.naufal.codingtask.entities.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setName(city.getName());
        dto.setLatitude(String.valueOf(city.getLatitude()));
        dto.setLongitude(String.valueOf(city.getLongitude()));
        return dto;
    }

    public City toEntity(CityDTO dto) {
        City city = new City();
        city.setName(dto.getName());
        city.setLatitude(Double.parseDouble(dto.getLatitude()));
        city.setLongitude(Double.parseDouble(dto.getLongitude()));
        return city;
    }
}
