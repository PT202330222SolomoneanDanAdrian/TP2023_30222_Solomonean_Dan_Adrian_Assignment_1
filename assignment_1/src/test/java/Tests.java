import DataModels.Monomial;
import DataModels.Polynomial;
import Parser.Parser;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Tests {

//    private String polynomial;
//    private String secondPolynomial;

    //    @BeforeEach
//    public void setup() {
//        polynomial = "+1x^5-2x^4+6x^3";
//        secondPolynomial = "1x^5-2x^4+3x^3";
//    }
    @Test
    public void havingToParseAPolynomial_TheExpectedResultIsGiven() {
        TreeMap<Integer, Monomial> expectedMap = new TreeMap<>();
        Polynomial polynomial = new Polynomial("+1x^5-2x^4+6x^3");

        expectedMap.put(5, new Monomial(1, 5));
        expectedMap.put(4, new Monomial(-2, 4));
        expectedMap.put(3, new Monomial(6, 3));

        TreeMap<Integer, Monomial> actualMap = Parser.parsePolynomial("+1x^5-2x^4+6x^3");

        assertEquals(expectedMap.get(5).getCoefficient(), actualMap.get(5).getCoefficient(), 1);
        assertEquals(expectedMap.get(4).getCoefficient(), actualMap.get(4).getCoefficient(), 1);
        assertEquals(expectedMap.get(3).getCoefficient(), actualMap.get(3).getCoefficient(), 1);
    }

    @Test
    public void WhenDifferentiatingAPolynomial_TheExponentGetsANewValueWithOneLess() {
        Polynomial result = new Polynomial();
        Polynomial polynomial = new Polynomial("+1x^5-2x^4+6x^3");

        result = Operations.differentiatePolynomial(polynomial);

        assertEquals(2, result.getMap().get(2).getExponent());
        assertEquals(3, result.getMap().get(3).getExponent());
        assertEquals(4, result.getMap().get(4).getExponent());
    }

//    @Test
//    public void havingToAddTwoPolynomials_TheCorectAnswerIsGiven() {
//
//    }

//    @Test
//    public void havingAnEmptyPolynom_TheCorectResultisGiven() {
//        DataModels.Polynomial emptyPolynomial = new DataModels.Polynomial("");
//        DataModels.Polynomial polynomial = new DataModels.Polynomial("+1x^5-2x^4+6x^3");
//
//        DataModels.Polynomial result = Operations.addPolynomials(polynomial, emptyPolynomial);
//
//        assertEquals(polynomial.getMap().toString(), result.getMap().toString());
//    }

//    @Test
//    public void addingAPolynomialToItself() {
//        DataModels.Polynomial p1 = new DataModels.Polynomial("+2x^2+3x^1");
//        DataModels.Polynomial p2 = new DataModels.Polynomial("+2x^2+3x^1");
//        DataModels.Polynomial result = Operations.addPolynomials(p1, p2);
//        assertEquals(new DataModels.Polynomial("+4x^2+6x^1").getMap().toString(), result.getMap().toString());
//    }
}
