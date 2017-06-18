package loginquerygui;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {

    @FXML
    private TextField usr;

    @FXML
    private TextField pass;
    private static String username="";
    private static String password="";

    public void Authenticate(ActionEvent event) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", usr.getText(), pass.getText());
            System.out.println("Connected");
            username=usr.getText();
            password=pass.getText();
            Parent query_page_parent = FXMLLoader.load(getClass().getResource("FXMLQuery.fxml"));
            Scene query_page_scene = new Scene(query_page_parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(query_page_scene);
            System.out.println("Showing");
            app_stage.show();
        } catch (Exception e) {
            usr.setText("");
            pass.setText("");
        }
    }
    public static String getUsr(){
        return username;
    }
    public static String getPass(){
        return password;
    }
}
