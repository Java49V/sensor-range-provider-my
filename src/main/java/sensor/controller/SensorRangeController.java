package sensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sensor.api.RangeResponse;
import sensor.dto.RangeDTO;
import sensor.exceptions.RangeNotFoundException;
import sensor.service.*;

@RestController
@RequestMapping("/sensor")
public class SensorRangeController {

    @Autowired
    private SensorRangeService sensorRangeService;

    @GetMapping("/{sensorId}/range")
    public ResponseEntity<RangeResponse> getSensorRange(@PathVariable String sensorId) {
        RangeDTO rangeDTO = sensorRangeService.getSensorRange(sensorId);

        if (rangeDTO == null) {
            throw new RangeNotFoundException("Range not found for sensor ID: " + sensorId);
        }

        RangeResponse rangeResponse = new RangeResponse();
        rangeResponse.setMin(rangeDTO.getMin());
        rangeResponse.setMax(rangeDTO.getMax());

        return ResponseEntity.ok(rangeResponse);
    }
}
