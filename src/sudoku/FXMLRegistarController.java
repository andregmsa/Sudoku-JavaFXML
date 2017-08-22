/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLRegistarController implements Initializable {

    @FXML 
    private TextField nome;
    
    @FXML 
    private PasswordField pass;
    
    @FXML 
    private Button registar; ;
    
    
    protected Stage window;
    Connection conn;
    PreparedStatement pst = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert registar != null : "fx:id=\"registar\" was not injected: check your FXML file 'FXMLRegistar.fxml'.";
        conn = SqlConnection.DBconnector();        
        registar.setOnAction(e->{
            try{
                System.out.println("TESTE INSERT");
                String query = "INSERT INTO UserDatabase VALUES (NULL,?,?);";
                pst = conn.prepareStatement(query);
                pst.setString(1, nome.getText());
                pst.setString(2, pass.getText());
                pst.execute();
                pst.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
                window = (Stage) registar.getScene().getWindow();
                Scene menu = new Scene((Parent) loader.load());
                window.setScene(menu);
            } catch(Exception e1) {
                System.out.println("erro" + e1);
            }
        });
        
    }    
    
}
