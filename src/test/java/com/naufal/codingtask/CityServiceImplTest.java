package com.naufal.codingtask;

import com.naufal.codingtask.dto.CityDTO;
import com.naufal.codingtask.entities.City;
import com.naufal.codingtask.repositories.CityRepository;
import com.naufal.codingtask.service.CityServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class CityServiceImplTest {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityServiceImpl cityServiceImpl;

    @BeforeEach
    public void setup(){
        // Clear out the database before each test
        cityRepository.deleteAll();

        // Add some sample data to the database for testing
        City city1 = new City("4298960", "London", "KY", "US", 51.5074, -0.1278);
        City city2 = new City("6058560","London", "ON", "Canada", 42.98339, -81.23304);
        cityRepository.save(city1);
        cityRepository.save(city2);
    }

    @Test
    public void testGetSuggestions_WithLatLon() {
        // When
        List<CityDTO> suggestions = cityServiceImpl.getSuggestions("Londo", 43.70011, -79.4163);

        // Then
        assertNotNull(suggestions);
        assertEquals(2, suggestions.size());
        assertTrue(suggestions.get(0).getScore() > suggestions.get(1).getScore());
    }

    @Test
    public void testGetSuggestions_WithoutLatLon() {
        // When
        List<CityDTO> suggestions = cityServiceImpl.getSuggestions("Londo", null, null);

        // Then
        assertNotNull(suggestions);
        assertEquals(2, suggestions.size());
        assertNull(suggestions.get(0).getScore());
        assertNull(suggestions.get(1).getScore());
    }

    @Test
    public void testGetSuggestions_NoMatches() {
        // When
        List<CityDTO> suggestions = cityServiceImpl.getSuggestions("SomeRandomCityInTheMiddleOfNowhere", null, null);

        // Then
        assertNotNull(suggestions);
        assertTrue(suggestions.isEmpty());
    }
}
