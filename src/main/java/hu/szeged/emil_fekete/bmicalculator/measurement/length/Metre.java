package hu.szeged.emil_fekete.bmicalculator.measurement.length;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Metre extends UnitOfMeasure {
    public Metre(double value) {
        super("m", "metre", 1.0, MeasureType.LENGTH, value);
    }

    public Metre() {
        super("m", "metre", 1.0, MeasureType.LENGTH);
    }
}
