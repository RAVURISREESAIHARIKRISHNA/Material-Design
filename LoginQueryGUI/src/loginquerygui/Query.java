package loginquerygui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Query {

    @FXML
    private TextArea in;

    @FXML
    private TextArea out;

    public void Run(ActionEvent event) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", LogInController.getUsr(), LogInController.getPass());
            System.out.println("Query.java : Connected");
            String data = in.getText();
            System.out.println(data);
            if (data.charAt(data.length() - 1) == ';') {
                data = data.substring(0, data.length() - 1);
            }
            Statement st = con.createStatement();
            ResultSet set = st.executeQuery(data);
            ResultSetMetaData meta = set.getMetaData();
            int cols = meta.getColumnCount();
            System.out.println(data);
            String output = "";
            String temp;
            for (int i = 1; i <= cols; i++) {
                // System.out.printf("%-30s",meta.getColumnName(i));
                temp = meta.getColumnName(i);
                output = output + temp;
                for (int j = 1; j <= 30 - (temp.length()); j++) {
                    output = output + " ";
                }
            }
            System.out.println();
            output = output + "\n";
            while (set.next()) {
                System.out.println();
                output = output + "\n";
                for (int i = 1; i <= cols; i++) {
                    // System.out.printf("%-30s",set.getString(i));
                    temp = set.getString(i);
                    if (temp != null) {
                        output = output + temp;
                    } else {
                        output = output + " ";
                        temp = "";
                    }
                    for (int k = 1; k <= 30 - (temp.length()); k++) {
                        output = output + " ";
                    }
                }
            }
            out.setText(output);
            System.out.println(output);
            con.close();
            st.close();
        } catch (Exception e) {
            out.setText("");
            in.setText("");
            e.printStackTrace();
        }
    }
}
