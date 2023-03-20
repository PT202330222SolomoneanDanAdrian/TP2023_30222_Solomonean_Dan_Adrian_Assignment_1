package BusinessLogic;

import DataModels.Monomial;
import DataModels.Polynomial;

import java.util.Map;

public class Operations {

    public static Polynomial addPolynomials(Polynomial polynomial, Polynomial secondPolynomial) {
        Polynomial addedPolynomials = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial.getMap().entrySet()) {
            addedPolynomials.getMap().put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Monomial> entry : secondPolynomial.getMap().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            if (addedPolynomials.getMap().containsKey(exponent)) {
                Monomial existingMonomial = addedPolynomials.getMap().get(exponent);
                double coefficient = existingMonomial.getCoefficient() + monomial.getCoefficient();

                addedPolynomials.getMap().put(exponent, new Monomial(coefficient, exponent));
            } else {
                addedPolynomials.getMap().put(exponent, monomial);
            }
        }

        return addedPolynomials;
    }

    public static Polynomial subtractPolynomials(Polynomial polynomial, Polynomial secondPolynomial) {
        Polynomial subtractedPolynomials = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial.getMap().entrySet()) {
            subtractedPolynomials.getMap().put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Monomial> entry : secondPolynomial.getMap().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            if (subtractedPolynomials.getMap().containsKey(exponent)) {
                Monomial existingMonomial = subtractedPolynomials.getMap().get(exponent);
                double coefficient = existingMonomial.getCoefficient() - monomial.getCoefficient();

                subtractedPolynomials.getMap().put(exponent, new Monomial(coefficient, exponent));
            } else {
                subtractedPolynomials.getMap().put(exponent, new Monomial(Integer.valueOf(-1) * monomial.getCoefficient(), exponent));
            }
        }

        return subtractedPolynomials;
    }

    public static Polynomial multiplyPolynomials(Polynomial polynomial, Polynomial secondPolynomial) {
        Polynomial multipliedPolynomials = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial.getMap().descendingMap().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            for (Map.Entry<Integer, Monomial> secondEntry : secondPolynomial.getMap().descendingMap().entrySet()) {
                int secondExponent = secondEntry.getKey();
                Monomial secondMonomial = secondEntry.getValue();

                int addedExponenent = exponent + secondExponent;
                double coefficient = monomial.getCoefficient() * secondMonomial.getCoefficient();

                if (multipliedPolynomials.getMap().containsKey(addedExponenent)) {
                    coefficient += multipliedPolynomials.getMap().get(addedExponenent).getCoefficient();
                }

                multipliedPolynomials.getMap().put(addedExponenent, new Monomial(coefficient, addedExponenent));
            }
        }

        return multipliedPolynomials;
    }

    public static Polynomial differentiatePolynomial(Polynomial polynomial) {
        Polynomial differentiatedPolynomial = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial.getMap().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            if (exponent > 0) {
                differentiatedPolynomial.getMap().put(exponent - 1, new Monomial(monomial.getCoefficient() * exponent, exponent - 1));
            }
        }

        return differentiatedPolynomial;
    }

    public static Polynomial integratePolynomial(Polynomial polynomial) {
        Polynomial integratedPolynomial = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : polynomial.getMap().entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            integratedPolynomial.getMap().put(exponent + 1, new Monomial(monomial.getCoefficient() / (exponent + 1), exponent + 1));
        }

        return integratedPolynomial;
    }
}
