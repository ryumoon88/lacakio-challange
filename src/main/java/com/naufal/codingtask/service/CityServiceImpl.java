package com.naufal.codingtask.service;

import com.naufal.codingtask.dto.CityDTO;
import com.naufal.codingtask.entities.City;
import com.naufal.codingtask.mapper.CityMapper;
import com.naufal.codingtask.repositories.CityRepository;
import com.naufal.codingtask.utils.ScoreCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final ScoreCalculator scoreCalculator;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper, ScoreCalculator scoreCalculator) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
        this.scoreCalculator = scoreCalculator;
    }

    @Override
    public List<CityDTO> getSuggestions(String q, Double lat, Double lon) {
        List<City> cities = cityRepository.findByNameContainingIgnoreCaseOrAltNameContainingIgnoreCase(q, q);
        List<CityDTO> cityDTOS = cities.stream()
                .map(cityMapper::toDTO)
                .collect(Collectors.toList());
        if (lat != null && lon != null) {
            for (CityDTO city : cityDTOS) {
                city.setScore(scoreCalculator.calculateScoreFrom(lat, lon, cityMapper.toEntity(city)));
            }
            cityDTOS.sort((c1, c2) -> Double.compare(c2.getScore(), c1.getScore()));
        }

        return cityDTOS;
    }

}