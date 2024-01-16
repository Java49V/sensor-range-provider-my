package sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import sensor.dto.RangeDTO;
import sensor.model.SensorRange;
import sensor.repo.SensorRangeRepository;
@SpringBootApplication
@Service
public class SensorRangeService {

    @Autowired
    private SensorRangeRepository sensorRangeRepository;

    public RangeDTO getSensorRange(String sensorId) {
        SensorRange sensorRange = sensorRangeRepository.findBySensorId(sensorId);

        if (sensorRange == null) {
            return null;
        }

        RangeDTO rangeDTO = new RangeDTO();
        rangeDTO.setMin(sensorRange.getMin());
        rangeDTO.setMax(sensorRange.getMax());

        return rangeDTO;
    }
}

