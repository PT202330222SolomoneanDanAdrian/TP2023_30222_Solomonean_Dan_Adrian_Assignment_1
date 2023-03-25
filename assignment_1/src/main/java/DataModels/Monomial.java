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
            return "+" + String.format("%.1f", coefficient) + "x^" + exponent;
        }

        return String.format("%.1f", coefficient) + "x^" + exponent;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj.getClass() != this.getClass()){
            return false;
        }

        Monomial monomial = (Monomial) obj;

        return (this.exponent == monomial.getExponent() && Double.compare(this.coefficient, monomial.getCoefficient()) == 0);
    }
}
