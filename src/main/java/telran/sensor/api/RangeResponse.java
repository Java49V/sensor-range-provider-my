package telran.sensor.api;

import java.io.Serializable;

public class RangeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private int min;
    private int max;
    private String description;

    public RangeResponse() {
        // Default constructor for serialization
    }

    public RangeResponse(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    @Override
    public String toString() {
        return "RangeResponse{" +
                "min=" + min +
                ", max=" + max +
                ", description='" + description + '\'' +
                '}';
    }
}
