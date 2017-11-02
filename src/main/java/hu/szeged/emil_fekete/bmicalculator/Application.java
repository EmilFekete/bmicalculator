package hu.szeged.emil_fekete.bmicalculator;

import hu.szeged.emil_fekete.bmicalculator.bmi.BMICategory;
import hu.szeged.emil_fekete.bmicalculator.bmi.BodyMassIndexCalculator;
import hu.szeged.emil_fekete.bmicalculator.io.InputHandler;
import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Centimetre;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Foot;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Inch;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Metre;
import hu.szeged.emil_fekete.bmicalculator.measurement.mass.Kilogram;
import hu.szeged.emil_fekete.bmicalculator.measurement.mass.Pound;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Josy on 2017.11.02..
 */
public class Application {
    InputHandler inputHandler;
    private Set<UnitOfMeasure> massMeasurementUnits;
    private Set<UnitOfMeasure> lengthMeasurementUnits;
    private UnitOfMeasure mass;
    private UnitOfMeasure length;

    Application() {
        this.massMeasurementUnits = new HashSet<>();
        massMeasurementUnits.add(new Kilogram());
        massMeasurementUnits.add(new Pound());
        this.lengthMeasurementUnits = new HashSet<>();
        lengthMeasurementUnits.add(new Metre());
        lengthMeasurementUnits.add(new Inch());
        lengthMeasurementUnits.add(new Foot());
        lengthMeasurementUnits.add(new Centimetre());
        inputHandler = new InputHandler(massMeasurementUnits, lengthMeasurementUnits);
    }

    public void run() {
        inputHandler.greet();
        mass = inputHandler.handleMass();
        length = inputHandler.handleLength();
        double bmi = BodyMassIndexCalculator.calculateBMI(mass, length);
        BMICategory category = BMICategory.getBMICategory(bmi);
        System.out.println("Your bmi is: " + bmi + " with a category of: " + category.name);
    }
}
