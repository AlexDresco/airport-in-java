import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Mock
    Plane planeMock;

    @BeforeEach
    public void beforeEachTest(){
        Weather weatherPlane = mock(Weather.class);
        when(weatherPlane.isSunny()).thenReturn(true);
    }

    @Test
    public void airportStoresLandedPlane(){
        Airport airport = new Airport();
        airport.land(planeMock);
        assertEquals(planeMock, airport.storage.get(0));
    }

    @Test
    public void airportRecordsTakenOffPlane(){
        Airport airport = new Airport();
        airport.land(planeMock);
        airport.takeOff(planeMock);
        assertTrue(airport.storage.isEmpty());
    }

}