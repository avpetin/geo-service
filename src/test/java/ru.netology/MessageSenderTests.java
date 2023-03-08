package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class MessageSenderTests {
    @Test
    void MessageSenderImplWithMockito(){
        GeoService geoServiceMock = Mockito.mock(GeoService.class);
        Mockito.when(geoServiceMock.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService preferenceLocalization = Mockito.mock(LocalizationService.class);
        Mockito.when(preferenceLocalization.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoServiceMock, preferenceLocalization);
        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "96.44.183.149");
        String returned = messageSender.send(headers);
        String expected = "Welcome";

        Assertions.assertEquals(expected, returned);
    }
}