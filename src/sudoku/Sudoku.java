/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author andre
 */
public class Sudoku extends Application {
    
    protected Stage window;
    protected Parent root;
    Connection conn;
    
    @Override
    public void start(Stage stage) throws Exception {
        //CheckConnection();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void CheckConnection(){
        conn = SqlConnection.DBconnector();
        if(conn == null){
            System.out.println("Connection Not Successful");
            System.exit(1);
        } else {
            System.out.println("Connection DB Successful");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
