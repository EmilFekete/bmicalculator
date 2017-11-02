package hu.szeged.emil_fekete.bmicalculator.measurement.length;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Inch extends UnitOfMeasure {
    public Inch(double value) {
        super("in", "inch", 0.0254, MeasureType.LENGTH, value);
    }

    public Inch() {
        super("in", "inch", 0.0254, MeasureType.LENGTH);
    }
}
