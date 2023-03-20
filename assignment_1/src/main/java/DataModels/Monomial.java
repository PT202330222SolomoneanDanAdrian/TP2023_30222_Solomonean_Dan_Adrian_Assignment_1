package DataModels;

public class Monomial {

    private double coefficient;

    private int exponent;

    public Monomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public String toString() {
        if (coefficient >= 0) {
            return "+" + coefficient + "x^" + exponent;
        }

        return coefficient + "x^" + exponent;
    }
}
