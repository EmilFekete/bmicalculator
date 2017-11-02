package hu.szeged.emil_fekete.bmicalculator.measurement.mass;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Pound extends UnitOfMeasure {
    public Pound(double value) {
        super("lb", "pound", 0.45359237, MeasureType.MASS, value);
    }

    public Pound() {
        super("lb", "pound", 0.45359237, MeasureType.MASS);
    }
}
