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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLLoginController implements Initializable {
    
    public StringProperty nameString = new SimpleStringProperty();
    

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnRegistar;
    
    @FXML
    private Label lError;
    
    public StringProperty getUser() {
        return nameString;
    }
    
    public void setUser(String name) {
        nameString.set(name);
    }
    
    
    protected Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static Label totLabel = new Label(); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'FXMLLogin.fxml'.";
        assert btnRegistar != null : "fx:id=\"btnRegistar\" was not injected: check your FXML file 'FXMLLogin.fxml'.";
        conn = SqlConnection.DBconnector();        
        btnLogin.setOnAction((ActionEvent e) -> {
            try {
                String query = "select * from UserDatabase where username=? and password=?;";
                pst = conn.prepareStatement(query);
                pst.setString(1, txtUser.getText());
                pst.setString(2, txtPass.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    FXMLLoader loader = new FXMLLoader(FXMLLoginController.this.getClass().getResource("FXMLMenu.fxml"));
                    totLabel = new Label(txtUser.getText());
                    System.out.println(totLabel.getText());
                    window = (Stage) btnLogin.getScene().getWindow();
                    Scene menu = new Scene((Parent) loader.load());
                    //Scene lab = new Scene((Parent) label.getParent());
                    window.setScene(menu);
                    //window.setScene(lab);
                } else {
                    lError.setText("Erro! Dados inválidos!");
                }
                pst.close();
                rs.close();
            }catch(Exception e1) {
                lError.setText("SQL Error");
                System.out.println(e1);
            }
        });
        
            btnRegistar.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistar.fxml"));
                window = (Stage) btnRegistar.getScene().getWindow();
                Scene dificuldade = new Scene((Parent) loader.load());
                window.setScene(dificuldade);
            } catch (Exception ignored){}
        });
        
        
        
    }    
    
}
