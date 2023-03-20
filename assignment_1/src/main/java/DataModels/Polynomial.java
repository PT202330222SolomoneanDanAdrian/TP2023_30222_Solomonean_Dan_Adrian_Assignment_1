package DataModels;

import Parser.Parser;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial{
    TreeMap<Integer, Monomial> map = new TreeMap<>();

    public Polynomial() {

    }

    public Polynomial(String polyonomial) {
        this.map = Parser.parsePolynomial(polyonomial);
    }

    public TreeMap<Integer, Monomial> getMap() {
        return map;
    }

    public void setMap(TreeMap<Integer, Monomial> map) {
        this.map = map;
    }
}
