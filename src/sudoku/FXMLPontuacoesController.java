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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLPontuacoesController implements Initializable {
    
     
    protected Stage window;
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    final ObservableList optionsMin = FXCollections.observableArrayList();
    final ObservableList optionsSeg = FXCollections.observableArrayList();
    FXMLLoginController controller;

    @FXML
    ListView listMin = new ListView();
    
    @FXML
    ListView listSeg = new ListView();
    
    @FXML
    Button voltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert voltar != null : "fx:id=\"voltar\" was not injected: check your FXML file 'FXMLPontuacoes.fxml'.";
        
        optionsMin.clear();
        optionsSeg.clear();
        conn = SqlConnection.DBconnector();   
        try{
            String query = "select t.seg, t.min from UserDatabase u , Tempo t where u.username='"+controller.totLabel.getText()+"' and u.id=t.userid;";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                int min = rs.getInt("min");
                int seg = rs.getInt("seg");
                optionsMin.add(min);
                optionsSeg.add(seg);
            }
            pst.close();
            rs.close();            
        }catch(Exception e1) {
                System.out.println(e1);
            }
        for(int i=0; i<optionsMin.size();i++)
            listMin.getItems().add(optionsMin.get(i));
        
        for(int i=0; i<optionsSeg.size();i++)
            listSeg.getItems().add(optionsSeg.get(i));
        
        voltar.setOnAction(e->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                window = (Stage) voltar.getScene().getWindow();
                Scene menu = new Scene((Parent) loader.load());
                window.setScene(menu);
            } catch (Exception ignored){}

        });
    }  
    

    
}
