package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;


public class GeoServiceTests {
    GeoService sut = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("addSourceIp")
    public void testByIpWithParameters(String testIp, Country expected) {
        var result = sut.byIp(testIp).getCountry();

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> addSourceIp() {
        return Stream.of(
                Arguments.of("127.0.0.1", null),
                Arguments.of("172.0.32.1", Country.RUSSIA),
                Arguments.of("96.44.183.1", Country.USA)
        );
    }

    @ParameterizedTest
    @MethodSource("addSourceCoordinates")
    public void testByCoordinates(double latitude, double longitude) {
        var result = RuntimeException.class;
        Executable expected = () -> sut.byCoordinates(latitude, longitude) ;

        Assertions.assertThrows(result, expected);
    }

    public static Stream<Arguments> addSourceCoordinates() {
        return Stream.of(
                Arguments.of(47.51, 35.21)
        );
    }
}