import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class AirportTest {

    @Mock
    Plane planeMock;

    @Mock
    Weather weather;

    @InjectMocks
    Airport airport;

    int capacity = 20;


    @BeforeEach
    void beforeEachTest(){
        airport = new Airport();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void airportStoresLandedPlane(){
        when(weather.isSunny()).thenReturn(true);
        airport.land(planeMock);
        assertEquals(planeMock, airport.storage.get(0));
    }

    @Test
    void airportRecordsTakenOffPlane(){
        when(weather.isSunny()).thenReturn(true);
        airport.land(planeMock);
        airport.takeOff(planeMock);
        assertTrue(airport.storage.isEmpty());
    }

    @Test
    void planeCantLandBadWeather(){
        when(weather.isSunny()).thenReturn(false);
        assertEquals("Plane can't land", airport.land(planeMock));
    }

    @Test
    void planeCantTakeOffBadWeather(){
        when(weather.isSunny()).thenReturn(false);
        assertEquals("Plane can't take off", airport.takeOff(planeMock));
    }

    @Test
    void airportReachedCapacity(){
        when(weather.isSunny()).thenReturn(true);
        int i = 0;
        while (i < capacity){
            airport.land(planeMock);
            i++;
        }
        assertEquals("Plane can't land", airport.land(planeMock));
        assertEquals( 20, airport.storage.size() );
    }
}