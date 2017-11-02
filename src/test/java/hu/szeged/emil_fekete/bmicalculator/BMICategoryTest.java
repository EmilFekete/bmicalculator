package hu.szeged.emil_fekete.bmicalculator;

import hu.szeged.emil_fekete.bmicalculator.bmi.BMICategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Josy on 2017.11.02..
 */
@RunWith(Parameterized.class)
public class BMICategoryTest {


    @Parameterized.Parameter(value = 0)
    public double bmi;
    @Parameterized.Parameter(value = 1)
    public BMICategory goodResult;
    private BMICategory categoryResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10.0, BMICategory.SEVERE_THINNESS},
                {16.7, BMICategory.MODERATE_THINNESS},
                {18.4, BMICategory.MILD_THINNESS},
                {18.5, BMICategory.NORMAL},
                {26.0, BMICategory.OVERWEIGHT},
                {31.0, BMICategory.OBESE_CLASSI},
                {36.0, BMICategory.OBESE_CLASSII},
                {45.0, BMICategory.OBESE_CLASSIII}}
        );
    }

    private void givenABodyMassIndexOf(double bmi) {
        this.bmi = bmi;
    }

    private void whenGettingTheBMICategory() {
        categoryResult = BMICategory.getBMICategory(bmi);
    }

    private void thenTheResultingBMICategoryIs(BMICategory expectedCategory) {
        assertThat(categoryResult).isEqualTo(expectedCategory);
    }

    @Test
    public void testGetBMICategoryShouldReturnTheRightCategoryToAGivenBMI() {
        givenABodyMassIndexOf(bmi);
        whenGettingTheBMICategory();
        thenTheResultingBMICategoryIs(goodResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBMICategoryShouldThrowExceptionToAZeroBMI() {
        givenABodyMassIndexOf(0.0);
        whenGettingTheBMICategory();
        thenTheResultingBMICategoryIs(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBMICategoryShouldThrowExceptionToANegativeBMI() {
        givenABodyMassIndexOf(-25.0);
        whenGettingTheBMICategory();
        thenTheResultingBMICategoryIs(null);
    }
}