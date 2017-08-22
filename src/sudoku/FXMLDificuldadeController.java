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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLDificuldadeController implements Initializable {

    @FXML
    private Button btnFacil;

    @FXML
    private Button btnMedio;
    
    @FXML
    private Button btnDificil;

    protected Stage window;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert btnFacil != null : "fx:id=\"btnFacil\" was not injected: check your FXML file 'FXMLDificuldade.fxml'.";
        assert btnMedio != null : "fx:id=\"btnMedio\" was not injected: check your FXML file 'FXMLDificuldade.fxml'.";
        assert btnDificil != null : "fx:id=\"btnDificil\" was not injected: check your FXML file 'FXMLDificuldade.fxml'.";
                
        btnFacil.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPuzzle.fxml"));
                window = (Stage) btnFacil.getScene().getWindow();
                Scene dificuldade = new Scene((Parent) loader.load());
                window.setScene(dificuldade);
            } catch (Exception ignored){}

        });
        
        btnMedio.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPuzzleMedio.fxml"));
                window = (Stage) btnFacil.getScene().getWindow();
                Scene dificuldade = new Scene((Parent) loader.load());
                window.setScene(dificuldade);
            } catch (Exception ignored){}

        });
        
        btnDificil.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPuzzleDificil.fxml"));
                window = (Stage) btnFacil.getScene().getWindow();
                Scene dificuldade = new Scene((Parent) loader.load());
                window.setScene(dificuldade);
            } catch (Exception ignored){}

        });
    }    
    
}
