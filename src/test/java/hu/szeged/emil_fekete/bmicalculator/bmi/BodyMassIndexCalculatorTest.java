package hu.szeged.emil_fekete.bmicalculator.bmi;

import hu.szeged.emil_fekete.bmicalculator.measurement.UnitOfMeasure;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Centimetre;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Foot;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Inch;
import hu.szeged.emil_fekete.bmicalculator.measurement.length.Metre;
import hu.szeged.emil_fekete.bmicalculator.measurement.mass.Kilogram;
import hu.szeged.emil_fekete.bmicalculator.measurement.mass.Pound;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Josy on 2017.11.02..
 */
public class BodyMassIndexCalculatorTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    UnitOfMeasure mass;
    UnitOfMeasure height;
    double bmi;

    private void givenAMassAndHeightOf(UnitOfMeasure mass, UnitOfMeasure height) {
        this.mass = mass;
        this.height = height;
    }

    private void whenCalculatingTheBMI() {
        bmi = BodyMassIndexCalculator.calculateBMI(mass, height);
    }

    private void thenTheResultShouldBe(double expectedResult) {
        assertThat(bmi).isBetween(expectedResult - 0.01, expectedResult + 0.01);
    }

    @Test
    public void testBMICalculationWithKilogramAndCentimetre() {
        givenAMassAndHeightOf(new Kilogram(65.0), new Centimetre(180.0));
        whenCalculatingTheBMI();
        thenTheResultShouldBe(20.06);
    }

    @Test
    public void testBMICalculationWithPoundAndMetre() {
        givenAMassAndHeightOf(new Pound(200.0), new Metre(1.6));
        whenCalculatingTheBMI();
        thenTheResultShouldBe(35.44);
    }

    @Test
    public void testBMICalculationWithKilogramAndInch() {
        givenAMassAndHeightOf(new Kilogram(250.0), new Inch(75.0));
        whenCalculatingTheBMI();
        thenTheResultShouldBe(68.89);
    }

    @Test
    public void testBMICalculationWithPoundAndFoot() {
        givenAMassAndHeightOf(new Pound(100.0), new Foot(5.0));
        whenCalculatingTheBMI();
        thenTheResultShouldBe(19.53);
    }

    @Test
    public void testBMICalculationShouldThrowExceptionToInvalidMeasurementTypes() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("The first parameter should be type of mass measurement unit!");

        givenAMassAndHeightOf(new Foot(), new Foot());
        whenCalculatingTheBMI();
        thenTheResultShouldBe(0.0);
    }
    
    @Test
    public void testBMICalculationShouldThrowExceptionToNullParameters() {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Parameters cannot be null!");

        givenAMassAndHeightOf(null, new Foot());
        whenCalculatingTheBMI();
        thenTheResultShouldBe(0.0);
    }
}