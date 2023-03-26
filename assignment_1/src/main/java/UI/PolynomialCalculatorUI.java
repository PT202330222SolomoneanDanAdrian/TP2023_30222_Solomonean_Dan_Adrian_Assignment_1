package UI;

import BusinessLogic.Operations;
import DataModels.Monomial;
import DataModels.Polynomial;
import BusinessLogic.Parser;
import Exceptions.WrongFormatException;

import javax.swing.*;
import java.util.Map;

public class PolynomialCalculatorUI extends JFrame {

    private JPanel containerPanel;
    private JTextField firstPolynomial;
    private JTextField secondPolynomial;
    private JTextField polynomialResult;
    private JButton addButton;
    private JButton differentiateButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton integrateButton;
    private JButton divideButton;


    public PolynomialCalculatorUI() {
        this.addButton.addActionListener(event -> {
            if (event.getSource() == addButton) {
                Polynomial polynomial = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial result = new Polynomial();

                try {
                    polynomial.setMap(Parser.parsePolynomial(firstPolynomial.getText()));
                    polynomial2.setMap(Parser.parsePolynomial(secondPolynomial.getText()));
                } catch (WrongFormatException e) {
                    this.showErrorDialog();
                }

                result = Operations.addPolynomials(polynomial, polynomial2);

                String resultedPolynomial = "";

                for (Map.Entry<Integer, Monomial> entry : result.getMap().descendingMap().entrySet()) {
                    resultedPolynomial += entry.getValue().toString();
                }

                this.polynomialResult.setText(resultedPolynomial);
            }
        });

        this.subtractButton.addActionListener(event -> {
            if (event.getSource() == subtractButton) {
                Polynomial polynomial = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial result = new Polynomial();

                try {
                    polynomial.setMap(Parser.parsePolynomial(firstPolynomial.getText()));
                    polynomial2.setMap(Parser.parsePolynomial(secondPolynomial.getText()));
                } catch (WrongFormatException e) {
                    this.showErrorDialog();
                }

                result = Operations.subtractPolynomials(polynomial, polynomial2);

                String resultedPolynomial = "";

                for (Map.Entry<Integer, Monomial> entry : result.getMap().descendingMap().entrySet()) {
                    resultedPolynomial += entry.getValue().toString();
                }

                this.polynomialResult.setText(resultedPolynomial);
            }
        });

        this.multiplyButton.addActionListener(event -> {
            if (event.getSource() == multiplyButton) {
                Polynomial polynomial = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                Polynomial result = new Polynomial();

                try {
                    polynomial.setMap(Parser.parsePolynomial(firstPolynomial.getText()));
                    polynomial2.setMap(Parser.parsePolynomial(secondPolynomial.getText()));
                } catch (WrongFormatException e) {
                    this.showErrorDialog();
                }

                result = Operations.multiplyPolynomials(polynomial, polynomial2);

                String resultedPolynomial = "";

                for (Map.Entry<Integer, Monomial> entry : result.getMap().descendingMap().entrySet()) {
                    resultedPolynomial += entry.getValue().toString();
                }

                this.polynomialResult.setText(resultedPolynomial);
            }
        });

        this.differentiateButton.addActionListener(event -> {
            if (event.getSource() == differentiateButton) {
                Polynomial polynomial = new Polynomial();
                Polynomial result = new Polynomial();

                try {
                    polynomial.setMap(Parser.parsePolynomial(firstPolynomial.getText()));
                } catch (WrongFormatException e) {
                    this.showErrorDialog();
                }

                result = Operations.differentiatePolynomial(polynomial);

                String resultedPolynomial = "";

                for (Map.Entry<Integer, Monomial> entry : result.getMap().descendingMap().entrySet()) {
                    resultedPolynomial += entry.getValue().toString();
                }

                this.polynomialResult.setText(resultedPolynomial);
            }
        });

        this.integrateButton.addActionListener(event -> {
            if (event.getSource() == integrateButton) {
                Polynomial polynomial = new Polynomial();
                Polynomial result = new Polynomial();

                try {
                    polynomial.setMap(Parser.parsePolynomial(firstPolynomial.getText()));
                } catch (WrongFormatException e) {
                    this.showErrorDialog();
                }

                result = Operations.integratePolynomial(polynomial);

                String resultedPolynomial = "";

                for (Map.Entry<Integer, Monomial> entry : result.getMap().descendingMap().entrySet()) {
                    resultedPolynomial += entry.getValue().toString();
                }

                this.polynomialResult.setText(resultedPolynomial);
            }
        });

        this.divideButton.addActionListener(event -> {
            if (event.getSource() == divideButton) {
                JOptionPane.showMessageDialog(null, "Not implemented yet :(");
            }
        });

        this.setTitle("Polynomial calculator");
        this.setContentPane(containerPanel);
        this.setVisible(true);
        this.pack();
    }

    private void showErrorDialog() {
        JOptionPane.showMessageDialog(null, "Invalid polynomial format.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
