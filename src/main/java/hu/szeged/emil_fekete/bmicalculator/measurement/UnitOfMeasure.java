package hu.szeged.emil_fekete.bmicalculator.measurement;

/**
 * Created by Josy on 2017.11.02..
 */
public abstract class UnitOfMeasure {
    protected final String symbol;
    protected final String name;
    protected final double metricEquivalentWithoutPrefix;
    protected final MeasureType type;
    protected double value;

    public UnitOfMeasure(String symbol, String name, double metricEquivalentWithoutPrefix, MeasureType type) {
        this(symbol, name, metricEquivalentWithoutPrefix, type, 1.0);
    }

    public UnitOfMeasure(String symbol, String name, double metricEquivalentWithoutPrefix, MeasureType type, double value) {
        this.symbol = symbol;
        this.name = name;
        this.metricEquivalentWithoutPrefix = metricEquivalentWithoutPrefix;
        this.type = type;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getMetricEquivalentWithoutPrefix() {
        return metricEquivalentWithoutPrefix;
    }

    public MeasureType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public enum MeasureType {
        LENGTH("length"),
        MASS("mass"),
        TIME("time"),
        ELECTRIC_CURRENT("electric current"),
        TEMPERATURE("temperature"),
        SUBSTANCE("substance"),
        LUMINOUS_INTENSITY("luminous intensity");

        String name;

        MeasureType(String name) {
            this.name = name;
        }
    }
}
