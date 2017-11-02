package hu.szeged.emil_fekete.bmicalculator.io;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;

import java.io.IOException;
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
        System.out.println("Tell me your weight (kg/lb, space separated):");
        UnitOfMeasure unitOfMeasure = null;
        try {
            unitOfMeasure = handleMeasurement(massMeasurementUnits);
        } catch (RuntimeException ex) {
            System.out.println("Received input do not match the expected!");
            handleMass();
        }
        return unitOfMeasure;
    }

    public UnitOfMeasure handleLength() {
        System.out.println("Tell me your height (m/cm/in/ft space separated):");
        UnitOfMeasure unitOfMeasure = null;
        try {
            unitOfMeasure = handleMeasurement(massMeasurementUnits);
        } catch (RuntimeException ex) {
            System.out.println("Received input do not match the expected!");
            handleLength();
        }
        return unitOfMeasure;
    }

    private UnitOfMeasure handleMeasurement(Set<UnitOfMeasure> measurementUnits) {
        String weightInput = scanner.nextLine();
        UnitOfMeasure measure = null;
        try {
            measure = parseUnitOfMeasure(weightInput, measurementUnits);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Try again:");
        }
        return measure;
    }

    public UnitOfMeasure parseUnitOfMeasure(String input, Set<UnitOfMeasure> measurementUnits) throws IOException {
        Scanner scanner = new Scanner(input);
        double value = scanner.nextDouble();
        String symbol = scanner.next();
        UnitOfMeasure unitOfMeasure = null;
        for (UnitOfMeasure massUnit : measurementUnits) {
            if (massUnit.getSymbol().equals(symbol.toLowerCase().trim())) {
                unitOfMeasure = new UnitOfMeasure(massUnit);
                unitOfMeasure.setValue(value);
                break;
            }
        }
        if (unitOfMeasure == null) {
            throw new IOException("Could not parse the input!");
        }
        return unitOfMeasure;
    }
}
