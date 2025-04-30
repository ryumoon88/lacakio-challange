package com.naufal.codingtask.utils;

import com.naufal.codingtask.entities.City;
import org.springframework.stereotype.Component;

@Component
public class ScoreCalculator {

    public double calculateScoreFrom(double latitude, double longitude, City city) {
        final int R = 6371;
        final double maxDistance = 40075.0;

        double phi1 = Math.toRadians(city.getLatitude());
        double phi2 = Math.toRadians(latitude);
        double deltaPhi = Math.toRadians(latitude - city.getLatitude());
        double deltaLambda = Math.toRadians(longitude - city.getLongitude());

        // Haversine formula
        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2)
                + Math.cos(phi1) * Math.cos(phi2)
                * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c;

        return 1 - (distance / maxDistance);
    }
}
