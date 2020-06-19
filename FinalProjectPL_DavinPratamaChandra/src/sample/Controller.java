package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class Controller {

    // Declaring the elements of the GUI (buttons, text field)
    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn000,
            btndecimal, btnclear, btnadd, btnsubtract, btnmultiply, btndivide, btnpower2, btnequal;
    public TextField tfcalculate;
    // Declaring string called data to store the number input temporarily
    public String data;
    // Declaring ArrayList called tempAns to store the number inputs
    public ArrayList<String> tempAns = new ArrayList<>();
    // Declaring ArrayList called operators to store the operator inputs (add, subtract, multiply, etc.)
    public ArrayList<String> operators = new ArrayList<>();
    // Declaring ScientificOperations class with the name operations (stores math operation methods)
    public ScientificOperations operations = new ScientificOperations();
    // Declaring integer called flag to check certain conditions
    public int flag = 1;

    // Method to display number when its button is pressed
    public void buttonPress(ActionEvent event) {
        if (event.getSource() == btn1) {
            tfcalculate.setText(tfcalculate.getText() + "1");
        } else if (event.getSource() == btn2) {
            tfcalculate.setText(tfcalculate.getText() + "2");
        } else if (event.getSource() == btn3) {
            tfcalculate.setText(tfcalculate.getText() + "3");
        } else if (event.getSource() == btn4) {
            tfcalculate.setText(tfcalculate.getText() + "4");
        } else if (event.getSource() == btn5) {
            tfcalculate.setText(tfcalculate.getText() + "5");
        } else if (event.getSource() == btn6) {
            tfcalculate.setText(tfcalculate.getText() + "6");
        } else if (event.getSource() == btn7) {
            tfcalculate.setText(tfcalculate.getText() + "7");
        } else if (event.getSource() == btn8) {
            tfcalculate.setText(tfcalculate.getText() + "8");
        } else if (event.getSource() == btn9) {
            tfcalculate.setText(tfcalculate.getText() + "9");
        } else if (event.getSource() == btn0) {
            tfcalculate.setText(tfcalculate.getText() + "0");
        } else if (event.getSource() == btn000) {
            tfcalculate.setText(tfcalculate.getText() + "000");
        } else if (event.getSource() == btndecimal) {
            // If the number in the text field already contains a decimal point,
            // it will not allow another decimal point to be added
            if (tfcalculate.getText().contains(".")) {
                tfcalculate.setText(tfcalculate.getText());
            }
            else {
                tfcalculate.setText(tfcalculate.getText() + ".");
            }
        } else if (event.getSource() == btnclear) {
            // When the clear button is pressed, the text field will be set to empty
            tfcalculate.setText("");
        }
    }

    // Method to input operation symbol when its button is pressed
    // It throws ScriptException to be able to use ScriptEngine
    public void operationButtonPress(ActionEvent event) throws ScriptException {
        // If flag = 1, the number in the text field is added to tempAns ArrayList
        if (flag == 1) {
            data = tfcalculate.getText();
            tempAns.add(data);
        }
        // If the add button is pressed, it adds '+' to operators ArrayList
        // by using Operations class method 'add'
        if (event.getSource() == btnadd) {
            operations.add(operators, tfcalculate);
            flag = 1;
        } else if (event.getSource() == btnsubtract) {
            // If the subtract button is pressed, it adds '-' to
            // operators ArrayList by using Operations class method 'add'
            operations.subtract(operators, tfcalculate);
            flag = 1;
        } else if (event.getSource() == btnmultiply) {
            // If the multiply button is pressed, it adds '*' to
            // operators ArrayList by using Operations class method 'add'
            operations.multiply(operators, tfcalculate);
            flag = 1;
        } else if (event.getSource() == btndivide) {
            // If the divide button is pressed, it adds '/' to
            // operators ArrayList by using Operations class method 'add'
            operations.divide(operators, tfcalculate);
            flag = 1;
        } else if (event.getSource() == btnpower2) {
            // If the 'power of 2' button is pressed, it calls
            // the 'powerOfTwo' method from the ScientificOperations class
            flag = 0;
            operations.powerOfTwo(data, tempAns, operators, tfcalculate);
        } else if (event.getSource() == btnequal) {
            // If equal button is pressed, the numbers stored in tempAns ArrayList
            // and the operation symbols in operators ArrayList
            // will be added to String ans through the for loop
            String ans = "";
            for (int i = 0; i < operators.size(); i++) {
                ans += tempAns.get(i);
                ans += operators.get(i);
            }
            // This line below is to add the last number to the string ans
            // (since tempAns has more members than operators)
            ans += tempAns.get(tempAns.size() - 1);
            // Intialize ScriptEngineManager
            ScriptEngineManager mgr = new ScriptEngineManager();
            // This is used to evaluate math equations in the form of a string
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            tfcalculate.setText(engine.eval(ans).toString());
            System.out.println(engine.eval(ans).toString());
            // Clear the data stored in tempAns and operators
            tempAns.clear();
            operators.clear();
            flag = 1;
        }
    }

}

