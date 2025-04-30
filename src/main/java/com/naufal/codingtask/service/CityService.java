package com.naufal.codingtask.service;

import com.naufal.codingtask.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getSuggestions(String q, Double lat, Double lon);
}
