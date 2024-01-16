package sensor.repo;



import org.springframework.data.mongodb.repository.MongoRepository;

import sensor.model.SensorRange;

public interface SensorRangeRepository extends MongoRepository<SensorRange, String> {
    SensorRange findBySensorId(String sensorId);
}

