package screenchangedemo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
    @FXML
    private TextField usr;
    
    @FXML
    private TextField pass;
    
    public void Authenticate(ActionEvent event)throws IOException{
        if(usr.getText().equals("hr") && pass.getText().equals("hr")){
            System.out.println("Logged IN");
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLNextPage.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            System.out.println("Showing");
            app_stage.show();
        }else{
            usr.setText("");
            pass.setText("");
        }
    }
}
