package BusinessLogic;

import DataModels.Monomial;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static TreeMap<Integer, Monomial> parsePolynomial(String polynom) {
        TreeMap<Integer, Monomial> monomials = new TreeMap<>();

        int coefficient;
        int exponent;

        Pattern pattern = Pattern.compile("(([+-]?\\d*)?[xX](\\^[+]?\\d+))");
        Matcher matcher = pattern.matcher(polynom);

        while (matcher.find()) {
            String monom = matcher.group();
            int index = monom.indexOf('^');

            coefficient = Integer.parseInt(monom.substring(0, index - 1));
            exponent =  Integer.parseInt(monom.substring(index + 1));

            //System.out.println(coefficient +"x^" + exponent);

            Monomial monomial = new Monomial(coefficient, exponent);

            monomials.put(monomial.getExponent(), monomial);
        }

        return monomials;
    }
}
