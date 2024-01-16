package telran.sensor.test;

import telran.sensor.dto.RangeDTO;
import telran.sensor.model.SensorRange;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import telran.sensor.repo.SensorRangeRepository;
import telran.sensor.service.SensorRangeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class SensorRangeServiceTest {

    @Mock
    private SensorRangeRepository sensorRangeRepository;

    @InjectMocks
    private SensorRangeService sensorRangeService;

    @Test
    public void testGetSensorRange_Success() {
        SensorRange sensorRange = new SensorRange();
        sensorRange.setSensorId("123");
        sensorRange.setMin(10);
        sensorRange.setMax(100);

        given(sensorRangeRepository.findBySensorId(anyString())).willReturn(sensorRange);

        RangeDTO result = sensorRangeService.getSensorRange("123");

        assertEquals(10, result.getMin());
        assertEquals(100, result.getMax());
    }

    @Test
    public void testGetSensorRange_NotFound() {
        given(sensorRangeRepository.findBySensorId(anyString())).willReturn(null);

        RangeDTO result = sensorRangeService.getSensorRange("123");

        assertEquals(null, result);
    }
}

