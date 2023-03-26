package DataModels;

import BusinessLogic.Parser;
import Exceptions.WrongFormatException;

import java.util.TreeMap;

public class Polynomial{
    private TreeMap<Integer, Monomial> map = new TreeMap<>();

    public Polynomial() {

    }

    public Polynomial(String polyonomial) throws WrongFormatException {
        this.map = Parser.parsePolynomial(polyonomial);
    }

    public TreeMap<Integer, Monomial> getMap() {
        return map;
    }

    public void setMap(TreeMap<Integer, Monomial> map) {
        this.map = map;
    }
}
