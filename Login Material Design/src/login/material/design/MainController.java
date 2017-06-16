package login.material.design;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private Label mainlabel;

    @FXML
    private Label statuslabel;

    @FXML
    private TextField usrid;

    @FXML
    private TextField passid;

    public void Authenticate(ActionEvent event) {
        mainlabel.setText("Enter Details");
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", usrid.getText(), passid.getText());
            statuslabel.setText("Success");
        } catch (Exception e) {
            statuslabel.setText("Fail");
        }

    }
}
