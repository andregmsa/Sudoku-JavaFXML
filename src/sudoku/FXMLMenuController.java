/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private Button btnNovoJogo;

    @FXML
    private Button btnLogout;
    
    @FXML
    private Button btnPontuacoes;
    
    @FXML
    private Label bnVindo;
    
    protected Stage window;
    FXMLLoginController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnNovoJogo != null : "fx:id=\"btnNovoJogo\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert btnPontuacoes != null : "fx:id=\"btnPontuacoes\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        
        bnVindo.setText( "Bem-Vindo " + controller.totLabel.getText());
        
        btnNovoJogo.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDificuldade.fxml"));
                window = (Stage) btnNovoJogo.getScene().getWindow();
                Scene dificuldade = new Scene((Parent) loader.load());
                dificuldade.getStylesheets().add(getClass().getResource("fxmldificuldade.css").toExternalForm());
                window.setScene(dificuldade);
            } catch (Exception ignored){}

        });
        
        btnPontuacoes.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPontuacoes.fxml"));
                window = (Stage) btnPontuacoes.getScene().getWindow();
                Scene pts = new Scene((Parent) loader.load());
                window.setScene(pts);
            } catch (Exception ignored){}

        });
        
        btnLogout.setOnAction(e->{
            try {
                controller.totLabel.setText("");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
                window = (Stage) btnLogout.getScene().getWindow();
                Scene pts = new Scene((Parent) loader.load());
                window.setScene(pts);
            } catch (Exception ignored){}

        });
        
        

    }    
    
}
