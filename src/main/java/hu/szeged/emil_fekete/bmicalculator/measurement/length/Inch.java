package hu.szeged.emil_fekete.bmicalculator.measurement.length;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class Inch extends UnitOfMeasure {
    Inch(double value) {
        super("in", "inch", 0.0254, MeasureType.LENGTH, value);
    }

    Inch() {
        super("in", "inch", 0.0254, MeasureType.LENGTH);
    }
}
