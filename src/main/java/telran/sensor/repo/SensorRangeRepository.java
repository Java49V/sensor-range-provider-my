package telran.sensor.repo;



import telran.sensor.model.SensorRange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRangeRepository extends MongoRepository<SensorRange, String> {
    SensorRange findBySensorId(String sensorId);
}

