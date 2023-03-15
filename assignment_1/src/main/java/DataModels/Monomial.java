package DataModels;

public class Monomial {

    private int coefficient;

    private int exponent;

    public Monomial(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
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
