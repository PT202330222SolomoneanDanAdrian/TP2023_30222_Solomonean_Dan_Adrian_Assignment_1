import java.util.Map;

public class Main {
    public static void main(String[] args) {


//        Polynomial polynomial = new Polynomial("+4x^5-3x^4+1x^2-8x^1+1x^0");
//        Polynomial polynomial1 = new Polynomial("+3x^4-1x^3+1x^2+2x^1-1x^0");

        Polynomial polynomial = new Polynomial("+1x^2+1x^0+4x^7");
        Polynomial polynomial1 = new Polynomial("+4x^2");


//            Polynomial polynomial2 = Operations.addPolynomials(polynomial, polynomial1);
        //Polynomial polynomial2 = Operations.subtractPolynomials(polynomial, polynomial1);
        Polynomial polynomial2 = Operations.integratePolynomial(polynomial1);

        for (Map.Entry<Integer, Monomial> entry : polynomial2.getMap().descendingMap().entrySet()) {
            System.out.println("key:" + entry.getKey() + " " + entry.getValue().toString());
        }
    }
}
