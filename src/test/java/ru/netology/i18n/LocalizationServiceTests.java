package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import java.util.stream.Stream;

public class LocalizationServiceTests {
    LocalizationServiceImpl sut = new LocalizationServiceImpl();

    @ParameterizedTest
    @MethodSource("addSourceLocale")
    public void testLocaleWithParameters(Country country, String expected) {
        var result = sut.locale(country);

        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> addSourceLocale() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome"),
                Arguments.of(Country.GERMANY, "Welcome")
        );
    }
}
