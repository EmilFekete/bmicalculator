package hu.szeged.emil_fekete.bmicalculator.io;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

import java.util.Scanner;
import java.util.Set;

/**
 * Created by Josy on 2017.11.02..
 */
public class InputHandler {
    private Scanner scanner;
    private Set<UnitOfMeasure> massMeasurementUnits;
    private Set<UnitOfMeasure> lengthMeasurementUnits;

    public InputHandler(Set<UnitOfMeasure> massMeasurementUnits, Set<UnitOfMeasure> lenghtMeasurementUnits) {
        this.massMeasurementUnits = massMeasurementUnits;
        this.lengthMeasurementUnits = lenghtMeasurementUnits;
        scanner = new Scanner(System.in);
    }

    public void greet() {
        System.out.println("This program will tell you your body mass index, and the associated category.");
    }

    public UnitOfMeasure handleMass() {
        System.out.println("Tell me your weight (kg/lb, eg: 60,5 kg)");
        UnitOfMeasure unitOfMeasure = null;
        try {
            String input = scanner.nextLine();
            unitOfMeasure = parseUnitOfMeasure(input, massMeasurementUnits);
        } catch (RuntimeException ex) {
            System.out.println("Received input do not match the expected!");
            handleMass();
        }
        return unitOfMeasure;
    }

    public UnitOfMeasure handleLength() {
        System.out.println("Tell me your height (m/cm/in/ft eg: 1,78 m )");
        UnitOfMeasure unitOfMeasure = null;
        try {
            String input = scanner.nextLine();
            unitOfMeasure = parseUnitOfMeasure(input, lengthMeasurementUnits);
        } catch (RuntimeException ex) {
            System.out.println("Received input do not match the expected!");
            handleLength();
        }
        return unitOfMeasure;
    }


    private UnitOfMeasure parseUnitOfMeasure(String input, Set<UnitOfMeasure> measurementUnits) {
        Scanner inputScanner = new Scanner(input);
        double value = inputScanner.nextDouble();
        String symbol = inputScanner.next();
        UnitOfMeasure unitOfMeasure = null;
        for (UnitOfMeasure massUnit : measurementUnits) {
            if (massUnit.getSymbol().equals(symbol.toLowerCase().trim())) {
                unitOfMeasure = new UnitOfMeasure(massUnit);
                unitOfMeasure.setValue(value);
                break;
            }
        }
        if (unitOfMeasure == null) {
            throw new RuntimeException("Could not match the measurement units symbol to supported ones");
        }
        return unitOfMeasure;
    }
}
