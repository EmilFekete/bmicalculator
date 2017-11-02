package hu.szeged.emil_fekete.bmicalculator.bmi;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

/**
 * Created by Josy on 2017.11.02..
 */
public class BodyMassIndexCalculator {
    public static double calculateBMI(UnitOfMeasure mass, UnitOfMeasure height) {
        if (mass == null || height == null) {
            throw new IllegalArgumentException("Parameters cannot be null!");
        }
        if (mass.getType() != UnitOfMeasure.MeasureType.MASS) {
            throw new IllegalArgumentException("The first parameter should be type of mass measurement unit!");
        }
        if (height.getType() != UnitOfMeasure.MeasureType.LENGTH) {
            throw new IllegalArgumentException("The second parameter should be type of length measurement unit!");
        }
        double massInKg = mass.getValue() * mass.getMetricEquivalentWithoutPrefix();
        double heightInM = height.getValue() * height.getMetricEquivalentWithoutPrefix();
        return massInKg / (heightInM * heightInM);
    }
}
