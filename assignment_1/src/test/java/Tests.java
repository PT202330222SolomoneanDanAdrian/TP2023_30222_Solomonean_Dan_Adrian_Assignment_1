import BusinessLogic.Operations;
import DataModels.Monomial;
import DataModels.Polynomial;
import BusinessLogic.Parser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    public Polynomial polynomial;

    @BeforeEach
    public void setup() {
        this.polynomial = new Polynomial("+1x^5-2x^4+6x^3");
    }

    @AfterEach
    public void clear() {
        this.polynomial = new Polynomial("");
    }

    @Test
    public void havingToParseAPolynomial_TheExpectedResultIsGiven() {
        TreeMap<Integer, Monomial> expectedMap = new TreeMap<>();
        TreeMap<Integer, Monomial> actualMap = Parser.parsePolynomial("+1x^5-2x^4+6x^3");

        expectedMap.put(5, new Monomial(1, 5));
        expectedMap.put(4, new Monomial(-2, 4));
        expectedMap.put(3, new Monomial(6, 3));

        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void havingAPolynomial_WhenDifferentiatingIt_ThenTheDifferentiatedPolynomIsMapped() {
        Polynomial differentiatedPolynomial = new Polynomial("+5x^4-8x^3+18x^2");

        assertEquals(differentiatedPolynomial.getMap(), Operations.differentiatePolynomial(polynomial).getMap());
    }

    @Test
    public void havingAPolynomial_WhenAddingItToItself_TheExpectedResultIsGiven() {
        Polynomial result = new Polynomial();
        Polynomial addedPolynomal = new Polynomial("+2x^5-4x^4+12x^3");

        result = Operations.addPolynomials(polynomial, polynomial);

        assertEquals(addedPolynomal.getMap(), result.getMap());
    }

    @Test
    public void havingAPolynomial_WhenSubtractigItFromItslef_TheExpectedResultIsGiven() {
        Polynomial result = new Polynomial();
        Polynomial subtractedPolynomial = new Polynomial("+0x^5+0x^4+0x^3");

        result = Operations.subtractPolynomials(polynomial, polynomial);

        assertEquals(subtractedPolynomial.getMap(), result.getMap());
    }

    //failed tests
    @Test
    public void havingAPolynomial_WhenIntegratingIt_TheExpectedResultIsGiven() {
        Polynomial integratedPolynomial = new Polynomial("+1x^5-2x^4+6x^3");

        assertEquals(Operations.integratePolynomial(polynomial).getMap(), polynomial.getMap());
    }
}
