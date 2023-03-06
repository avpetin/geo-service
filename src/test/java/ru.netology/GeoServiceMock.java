package ru.netology;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {
    private Country country;
    @Override
    public Location byIp(String ip) {
        return new Location(null, country, null, 0);
    }

    public void setLocation(Country country){
        this.country = country;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}
