package hu.szeged.emil_fekete.bmicalculator.measurement.length;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Centimetre extends UnitOfMeasure {
    public Centimetre(double value) {
        super("cm", "centimetre", 0.01, MeasureType.LENGTH, value);
    }

    public Centimetre() {
        super("cm", "centimetre", 0.01, MeasureType.LENGTH);
    }
}
