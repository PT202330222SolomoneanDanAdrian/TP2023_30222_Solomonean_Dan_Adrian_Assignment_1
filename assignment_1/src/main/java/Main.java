import BusinessLogic.Operations;
import DataModels.Monomial;
import DataModels.Polynomial;
import UI.PolynomialCalculatorUI;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial("+3x^2+5x^1+1x^0");
        Polynomial polynomial1 = new Polynomial("+3x^2+5x^1");

        System.out.println(polynomial.getMap().equals(polynomial1.getMap()));


//            DataModels.Polynomial polynomial2 = BusinessLogic.Operations.addPolynomials(polynomial, polynomial1);
        //DataModels.Polynomial polynomial2 = BusinessLogic.Operations.subtractPolynomials(polynomial, polynomial1);
        //DataModels.Polynomial polynomial2 = BusinessLogic.Operations.integratePolynomial(polynomial1);
        Polynomial polynomial2 = Operations.addPolynomials(polynomial, polynomial1);


        for (Map.Entry<Integer, Monomial> entry : polynomial2.getMap().descendingMap().entrySet()) {
            System.out.println("key:" + entry.getKey() + " " + entry.getValue().toString());
        }

        new PolynomialCalculatorUI();
    }
}
