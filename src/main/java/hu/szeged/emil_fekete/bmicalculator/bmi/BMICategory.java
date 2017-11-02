package hu.szeged.emil_fekete.bmicalculator.bmi;

public enum BMICategory {
    SEVERE_THINNESS(0.0, 16.0, "Severe Thinness"),
    MODERATE_THINNESS(16.0, 17.0, "Moderate Thinness"),
    MILD_THINNESS(17.0, 18.5, "Mild Thinness"),
    NORMAL(18.5, 25.0, "Normal"),
    OVERWEIGHT(25.0, 30.0, "Overweight"),
    OBESE_CLASSI(30.0, 35.0, "Obese Class I"),
    OBESE_CLASSII(35.0, 40.0, "Obese Class II"),
    OBESE_CLASSIII(40.0, Double.MAX_VALUE, "Obese Class III");

    public final String name;
    private final double lowerBoundaryInclusive;
    private final double upperBoundaryExclusive;

    BMICategory(double lowerBoundaryInclusive, double upperBoundaryExclusive, String name) {
        this.lowerBoundaryInclusive = lowerBoundaryInclusive;
        this.upperBoundaryExclusive = upperBoundaryExclusive;
        this.name = name;
    }

    private static boolean isBMIInCategoriesBoundaries(double bmi, BMICategory category) {
        return bmi >= category.lowerBoundaryInclusive && bmi < category.upperBoundaryExclusive;
    }

    public static BMICategory getBMICategory(double bmi) {
        if (bmi <= 0.0) throw new IllegalArgumentException("bmi must be a positive number!");
        BMICategory resultCategory = null;
        for (BMICategory category : BMICategory.values()) {
            if (isBMIInCategoriesBoundaries(bmi, category)) {
                resultCategory = category;
                break;
            }
        }
        return resultCategory;
    }
}

