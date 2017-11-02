package hu.szeged.emil_fekete.bmicalculator;

public enum BMICategory {
    SEVERE_THINNESS(0.0, 16.0),
    MODERATE_THINNESS(16.0, 17.0),
    MILD_THINNESS(17.0, 18.5),
    NORMAL(18.5, 25.0),
    OVERWEIGHT(25.0, 30.0),
    OBESE_CLASSI(30.0, 35.0),
    OBESE_CLASSII(35.0, 40.0),
    OBESE_CLASSIII(40.0,Double.MAX_VALUE);

  private final double lowerBoundaryInclusive;
  private final double upperBoundaryExclusive;

  BMICategory(double lowerBoundaryInclusive, double upperBoundaryExclusive) {
	this.lowerBoundaryInclusive = lowerBoundaryInclusive;
	this.upperBoundaryExclusive = upperBoundaryExclusive;
  }
  private static boolean isBMIInCategoriesBoundaries(double bmi, BMICategory category){
      return bmi >= category.lowerBoundaryInclusive && bmi < category.upperBoundaryExclusive;
  }

  public static BMICategory getBMICategory(double bmi){
    if(bmi <= 0.0) throw new IllegalArgumentException("bmi must be a positive number!");
    BMICategory resultCategory = null;
    for(BMICategory category : BMICategory.values()){
        if(isBMIInCategoriesBoundaries(bmi,category)){
            resultCategory = category;
            break;
        }
    }
    return resultCategory;
  }
}

