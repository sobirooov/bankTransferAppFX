package uz.javazam.banktransferappfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField transferSum;
    @FXML
    private Label transferA;
    @FXML
    private Label transferB;
    @FXML
    private Label invalidNum;


    public void send2B() {
        String s = transferSum.getText();
        String textA = transferA.getText();
        String clenedA = textA.replaceAll("[^0-9]", "");
        String textB = transferB.getText();
        String clenedB = textB.replaceAll("[^0-9]", "");

        if (s.isEmpty() || textA.isEmpty() || textB.isEmpty()) {
            invalidNum.setText("Please enter a number");
            return;
        }

        try {
            int a = Integer.parseInt(clenedA);
            int b = Integer.parseInt(clenedB);
            int sum = Integer.parseInt(s);

            if (sum <= 0) {
                invalidNum.setText("Enter a valid transfer amount");
                return;
            }

            if (a < sum) {
                invalidNum.setText("Insufficient balance in A!");
                return;
            }

            int newA = a - sum;
            int newB = b + sum;

            transferA.setText("$" + newA);
            transferB.setText("$" + newB);

            invalidNum.setText("");

        } catch (NumberFormatException e) {
            invalidNum.setText("Please enter a number");
        }
    }


    public void send2A() {
        String s = transferSum.getText();
        String textA = transferA.getText();
        String clenedA = textA.replaceAll("[^0-9]", "");
        String textB = transferB.getText();
        String clenedB = textB.replaceAll("[^0-9]", "");
        try {
            int sum = Integer.parseInt(s);
            int a = Integer.parseInt(clenedA);
            int b = Integer.parseInt(clenedB);

            if (sum <= 0) {
                invalidNum.setText("Enter a valid transfer amount");
                return;
            }

            if (b < sum) {
                invalidNum.setText("Insufficient balance in B!");
                return;
            }

            int newA = a + sum;
            int newB = b - sum;

            transferA.setText("$" + newA);
            transferB.setText("$" + newB);

            invalidNum.setText("");

        } catch (NumberFormatException e) {
            invalidNum.setText("please enter a number");
        }
    }
}
