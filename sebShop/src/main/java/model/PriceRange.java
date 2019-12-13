package model;

import java.io.Serializable;

public class PriceRange implements Serializable {

    private static final long serialVersionUID = 6009226220211548256L;
    private double min;
    private double max;

    public PriceRange(){}

    public PriceRange(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
