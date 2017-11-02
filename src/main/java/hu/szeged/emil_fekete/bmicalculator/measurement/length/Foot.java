package hu.szeged.emil_fekete.bmicalculator.measurement.length;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Foot extends UnitOfMeasure {
    public Foot(double value) {
        super("ft", "foot", 0.3048, MeasureType.LENGTH, value);
    }

    public Foot() {
        super("ft", "foot", 0.3048, MeasureType.LENGTH);
    }
}
