package telran.sensor.exceptions;

import java.io.Serializable;

public class RangeNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public RangeNotFoundException(String message) {
        super(message);
    }
}
