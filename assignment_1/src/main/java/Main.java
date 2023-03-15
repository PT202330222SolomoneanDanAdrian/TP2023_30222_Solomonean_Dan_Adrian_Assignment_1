import DataModels.Monomial;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Monomial> map = new TreeMap<>();
        Map<Integer, Monomial> map2 = new TreeMap<>();
        TreeMap<Integer, Monomial> map3 = new TreeMap<>();

        map = Parser.parsePolynom("+4x^5-3x^4+1x^2-8x^1+1x^0");
        map2 = Parser.parsePolynom("+3x^4-1x^3+1x^2+2x^1-1x^0");

        for (Map.Entry<Integer, Monomial> entry : map.entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            if (map2.containsKey(exponent)) {
                monomial = new Monomial(monomial.getCoefficient() + map2.get(exponent).getCoefficient(), exponent);
            }

            map3.put(exponent, monomial);
        }

        for(Map.Entry<Integer, Monomial> entry : map2.entrySet()) {
            int exponent = entry.getKey();
            Monomial monomial = entry.getValue();

            if(!map2.containsKey(exponent)) {
                map3.put(exponent, monomial);
            }
        }

//        for (Map.Entry<Integer, Monomial> entry : map.entrySet()) {
//            int exponent = entry.getKey();
//            Monomial monomial = entry.getValue();
//
//            if (map2.containsKey(exponent)) {
//                monomial = new Monomial(monomial.getCoefficient() + ( Integer.valueOf(-1) * map2.get(exponent).getCoefficient()), exponent);
//            }
//
//            map3.put(exponent, monomial);
//        }
//
//        for (Map.Entry<Integer, Monomial> entry : map2.entrySet()) {
//            int exponent = entry.getKey();
//            Monomial monomial = entry.getValue();
//
//            if (!map2.containsKey(exponent)) {
//                map3.put(exponent, monomial);
//            }
//        }

        for (Map.Entry<Integer, Monomial> entry : map3.descendingMap().entrySet()) {
            System.out.print(entry.getValue().toString());
        }
    }
}
