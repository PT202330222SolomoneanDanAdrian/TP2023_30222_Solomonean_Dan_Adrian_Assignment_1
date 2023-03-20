import BusinessLogic.Operations;
import DataModels.Monomial;
import DataModels.Polynomial;
import UI.PolynomialCalculatorUI;

import java.util.Map;

public class Main {
    public static void main(String[] args) {


//        DataModels.Polynomial polynomial = new DataModels.Polynomial("+4x^5-3x^4+1x^2-8x^1+1x^0");
//        DataModels.Polynomial polynomial1 = new DataModels.Polynomial("+3x^4-1x^3+1x^2+2x^1-1x^0");

        Polynomial polynomial = new Polynomial("+3x^2+5x^1+1x^0");
        Polynomial polynomial1 = new Polynomial("+3x^2+5x^1");

        //System.out.println(polynomial.equals(polynomial1));


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
