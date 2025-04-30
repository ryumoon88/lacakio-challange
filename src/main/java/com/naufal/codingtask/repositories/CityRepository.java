package com.naufal.codingtask.repositories;

import com.naufal.codingtask.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, String> {

    Iterable<City> findCitiesByNameContainsIgnoreCase(String name);

    List<City> findByNameContainingIgnoreCase(String name);

    List<City> findByNameContainingIgnoreCaseOrAltNameContainingIgnoreCase(String name, String altName);
}
