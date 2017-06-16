/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private TextArea in;

    @FXML
    private TextArea out;

    public void Authenticate(ActionEvent event) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
        System.out.println("Connected");
        String data = in.getText();
        if(data==null||data.equals("")){
            out.setText("");
            in.setText("");
            return;
        }
        if(data.equals("cls")){
            out.setText("");
            in.setText("");
            return;
        }
        if(data.charAt(data.length()-1)==';'){
            data = data.substring(0, data.length()-1);
        }
//        int count = 0, i = 0;
//        while (true) {
//            i = data.indexOf(',', i);
//            count++;
//            if (i == -1) {
//                count++;
//                break;
//            }
//        }
        String ans = "";
        Statement st = con.createStatement();
        ResultSet set = st.executeQuery(data);
        while (set.next()) {
//            for (int k = 1; k <= count; k++) {
//                ans = ans + set.getString(k) + " ";
//            }
//            ans = ans + "\n";
            ans = ans + set.getString(1)+"\n";
        }
        out.setText(ans);
    }
}
