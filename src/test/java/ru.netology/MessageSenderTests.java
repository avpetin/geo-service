package ru.netology;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoService;
import ru.netology.sender.MessageSenderImpl;

public class MessageSenderTests {
    @Test
    void MessageSenderImplWithMockito(){
        GeoService geoService = Mockito.mock(GeoService.class);
//        Mockito.when(geoService.byIp())
    }
}
