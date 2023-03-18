import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class Tests {

    private String polynomial;
    private String secondPolynomial;

    @Before
    public void setup() {
        polynomial = "+1x^5-2x^4+6x^3";
        secondPolynomial = "1x^5-2x^4+3x^3";
    }
    @Test
    public void havingToParseAPolynomial_TheExpectedResultIsGiven() {
        TreeMap<Integer, Monomial> expectedMap = new TreeMap<>();

        expectedMap.put(5, new Monomial(1, 5));
        expectedMap.put(4, new Monomial(-2, 4));
        expectedMap.put(3, new Monomial(6, 3));

        TreeMap<Integer, Monomial> actualMap = Parser.parsePolynomial(polynomial);

        assertEquals(expectedMap.get(5).getCoefficient(), actualMap.get(5).getCoefficient(), 1);
        assertEquals(expectedMap.get(4).getCoefficient(), actualMap.get(4).getCoefficient(), 1);
        assertEquals(expectedMap.get(3).getCoefficient(), actualMap.get(3).getCoefficient(),1);
    }

//    @Test
//    public void havingToAddTwoPolynomials_TheCorectAnswerIsGiven() {
//
//    }

//    @Test
//    public void havingAnEmptyPolynom_TheCorectResultisGiven() {
//        Polynomial emptyPolynomial = new Polynomial("");
//        Polynomial polynomial = new Polynomial("+1x^5-2x^4+6x^3");
//
//        Polynomial result = Operations.addPolynomials(polynomial, emptyPolynomial);
//
//        assertEquals(polynomial.getMap().toString(), result.getMap().toString());
//    }

//    @Test
//    public void addingAPolynomialToItself() {
//        Polynomial p1 = new Polynomial("+2x^2+3x^1");
//        Polynomial p2 = new Polynomial("+2x^2+3x^1");
//        Polynomial result = Operations.addPolynomials(p1, p2);
//        assertEquals(new Polynomial("+4x^2+6x^1").getMap().toString(), result.getMap().toString());
//    }
}
