package sample;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Operations {

    public void add (ArrayList<String> operators, TextField tfcalculate) {
        operators.add("+");
        tfcalculate.setText("");
    }

    public void subtract (ArrayList<String> operators, TextField tfcalculate) {
        operators.add("-");
        tfcalculate.setText("");
    }

    public void multiply (ArrayList<String> operators, TextField tfcalculate) {
        operators.add("*");
        tfcalculate.setText("");
    }

    public void divide (ArrayList<String> operators, TextField tfcalculate) {
        operators.add("/");
        tfcalculate.setText("");
    }
}
