package telran.sensor.test;

import telran.sensor.api.RangeResponse;
import telran.sensor.controller.SensorRangeController;
import telran.sensor.exceptions.RangeNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SensorRangeController.class)
public class SensorRangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SensorRangeController sensorRangeController;

    @Test
    public void testGetSensorRange_Success() throws Exception {
        given(sensorRangeController.getSensorRange("123"))
                .willReturn(ResponseEntity.ok(new RangeResponse()));

        mockMvc.perform(get("/sensor/123/range"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.min").value(10))
                .andExpect(jsonPath("$.max").value(100));
    }

    @Test
    public void testGetSensorRange_NotFound() throws Exception {
        given(sensorRangeController.getSensorRange(anyString()))
                .willThrow(new RangeNotFoundException("Range not found for sensor ID: 123"));

        mockMvc.perform(get("/sensor/123/range"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Range not found for sensor ID: 123"));
    }
}
