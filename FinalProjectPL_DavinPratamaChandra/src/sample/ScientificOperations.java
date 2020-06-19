package sample;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ScientificOperations extends Operations {

    public void powerOfTwo (String data, ArrayList<String> tempAns, ArrayList<String> operators, TextField tfcalculate) {
        operators.add("*");
        tempAns.add(data);
        tfcalculate.setText("");
    }
}
