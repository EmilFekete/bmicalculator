package hu.szeged.emil_fekete.bmicalculator.measurement.mass;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Kilogram extends UnitOfMeasure {
    Kilogram(double value) {
        super("kg", "kilogram", 1.0, MeasureType.MASS, value);
    }

    Kilogram() {
        super("kg", "kilogram", 1.0, MeasureType.MASS);
    }
}
