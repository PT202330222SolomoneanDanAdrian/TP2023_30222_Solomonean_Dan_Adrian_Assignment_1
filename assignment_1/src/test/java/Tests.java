import BusinessLogic.Operations;
import DataModels.Monomial;
import DataModels.Polynomial;
import BusinessLogic.Parser;
import Exceptions.WrongFormatException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    public Polynomial polynomial;
    public Polynomial secondPolynomial;
    public Polynomial emptyPolynomial;

    @BeforeEach
    public void setup() throws WrongFormatException {
        this.polynomial = new Polynomial("+1x^5+2x^4+6x^3");
        this.secondPolynomial = new Polynomial("+3x^5+2x^4+10x^7");
        this.emptyPolynomial = new Polynomial("");
    }

    @AfterEach
    public void clear() {
        this.polynomial = new Polynomial();
        this.secondPolynomial = new Polynomial();
    }

    @Test
    public void havingAPolynomialOfWrongFormat_ThrowsException() {
        assertThrows(WrongFormatException.class, () -> {
            Parser.parsePolynomial("2x^2+2x+1");
        });
    }

    @Test
    public void havingToParseAPolynomial_TheExpectedResultIsGiven() throws WrongFormatException {
        TreeMap<Integer, Monomial> expectedMap = new TreeMap<>();
        TreeMap<Integer, Monomial> actualMap = Parser.parsePolynomial("+1x^5+2x^4+6x^3");

        expectedMap.put(5, new Monomial(1, 5));
        expectedMap.put(4, new Monomial(2, 4));
        expectedMap.put(3, new Monomial(6, 3));

        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void havingAPolynomial_WhenDifferentiatingIt_ThenTheDifferentiatedPolynomIsMapped() throws WrongFormatException {
        Polynomial differentiatedPolynomial = new Polynomial("+5x^4+8x^3+18x^2");

        assertEquals(differentiatedPolynomial.getMap(), Operations.differentiatePolynomial(polynomial).getMap());
    }

    @Test
    public void havingAPolynomial_WhenAddingItToItself_TheExpectedResultIsGiven() throws WrongFormatException {
        Polynomial result = new Polynomial();
        Polynomial addedPolynomal = new Polynomial("+2x^5+4x^4+12x^3");

        result = Operations.addPolynomials(polynomial, polynomial);

        assertEquals(addedPolynomal.getMap(), result.getMap());
    }

    @Test
    public void havingAPolynomial_WhenSubtractigItFromItslef_TheExpectedResultIsGiven() throws WrongFormatException {
        Polynomial result = new Polynomial();
        Polynomial subtractedPolynomial = new Polynomial("+0x^5+0x^4+0x^3");

        result = Operations.subtractPolynomials(polynomial, polynomial);

        assertEquals(subtractedPolynomial.getMap(), result.getMap());
    }

    @Test
    public void havingAPolynomial_AddedWithAnEmptyPolynomial_TheFirstPolynomialIsReturned() {
        Polynomial result = Operations.addPolynomials(polynomial, emptyPolynomial);

        assertEquals(result.getMap(), polynomial.getMap());
    }

    @Test
    public void havingAPolynomial_SubtractedWithAnEmptyPolynomial_TheFirstPolynomialIsReturned() {
        Polynomial result = Operations.subtractPolynomials(polynomial, emptyPolynomial);

        assertEquals(result.getMap(), polynomial.getMap());
    }

    @Test
    public void havingAPolynomial_WhenIntegratingIt_TheExpectedResultIsReturned() throws WrongFormatException {
        TreeMap<Integer, Monomial> expectedMap = new TreeMap<>();
        Polynomial integratedPolynomial = Operations.integratePolynomial(new Polynomial("+1x^5+2x^4+6x^3"));

        expectedMap.put(6, new Monomial(0.2, 6));
        expectedMap.put(5, new Monomial(0.4, 5));
        expectedMap.put(4, new Monomial(1.5, 4));

        assertEquals(expectedMap.toString(), integratedPolynomial.getMap().toString());
    }

    @Test
    public void havingAPolynomial_WhenMultyplingItWithZero_AllCoefficientsAreZero() throws WrongFormatException {
        Polynomial zeroPolynomial = new Polynomial("+0x^1");

        Polynomial result = Operations.multiplyPolynomials(polynomial, zeroPolynomial);

        for (Map.Entry<Integer, Monomial> entry : result.getMap().entrySet()) {
            assertEquals(0, entry.getValue().getCoefficient());
        }
    }

    //failed tests
//    @Test
//    public void havingAPolynomial_WhenIntegratingIt_TheExpectedResultIsGiven() throws WrongFormatException {
//        Polynomial integratedPolynomial = new Polynomial("+1x^5-2x^4+6x^3");
//
//        assertEquals(Operations.integratePolynomial(polynomial).getMap(), polynomial.getMap());
//    }
}
