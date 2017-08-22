/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class FXMLPuzzleMedioController implements Initializable {
    @FXML
    private TextField t00;

    @FXML
    private TextField t01;
    
    @FXML
    private TextField t02;
    
    @FXML
    private TextField t03;
    
    @FXML
    private TextField t04;
        
    @FXML
    private TextField t05;
    
    @FXML
    private TextField t06;
    
    @FXML
    private TextField t07;
    
    @FXML
    private TextField t08;
    
    @FXML
    private TextField t10;

    @FXML
    private TextField t11;
    
    @FXML
    private TextField t12;
    
    @FXML
    private TextField t13;
    
    @FXML
    private TextField t14;
        
    @FXML
    private TextField t15;
    
    @FXML
    private TextField t16;
    
    @FXML
    private TextField t17;
    
    @FXML
    private TextField t18;
    
    @FXML
    private TextField t20;

    @FXML
    private TextField t21;
    
    @FXML
    private TextField t22;
    
    @FXML
    private TextField t23;
    
    @FXML
    private TextField t24;
        
    @FXML
    private TextField t25;
    
    @FXML
    private TextField t26;
    
    @FXML
    private TextField t27;
    
    @FXML
    private TextField t28;
    
    @FXML
    private TextField t30;

    @FXML
    private TextField t31;
    
    @FXML
    private TextField t32;
    
    @FXML
    private TextField t33;
    
    @FXML
    private TextField t34;
        
    @FXML
    private TextField t35;
    
    @FXML
    private TextField t36;
    
    @FXML
    private TextField t37;
    
    @FXML
    private TextField t38;
    
    @FXML
    private TextField t40;

    @FXML
    private TextField t41;
    
    @FXML
    private TextField t42;
    
    @FXML
    private TextField t43;
    
    @FXML
    private TextField t44;
        
    @FXML
    private TextField t45;
    
    @FXML
    private TextField t46;
    
    @FXML
    private TextField t47;
    
    @FXML
    private TextField t48;
    
    @FXML
    private TextField t50;

    @FXML
    private TextField t51;
    
    @FXML
    private TextField t52;
    
    @FXML
    private TextField t53;
    
    @FXML
    private TextField t54;
        
    @FXML
    private TextField t55;
    
    @FXML
    private TextField t56;
    
    @FXML
    private TextField t57;
    
    @FXML
    private TextField t58;
    
    @FXML
    private TextField t60;

    @FXML
    private TextField t61;
    
    @FXML
    private TextField t62;
    
    @FXML
    private TextField t63;
    
    @FXML
    private TextField t64;
        
    @FXML
    private TextField t65;
    
    @FXML
    private TextField t66;
    
    @FXML
    private TextField t67;
    
    @FXML
    private TextField t68;
    
    @FXML
    private TextField t70;

    @FXML
    private TextField t71;
    
    @FXML
    private TextField t72;
    
    @FXML
    private TextField t73;
    
    @FXML
    private TextField t74;
        
    @FXML
    private TextField t75;
    
    @FXML
    private TextField t76;
    
    @FXML
    private TextField t77;
    
    @FXML
    private TextField t78;
    
    @FXML
    private TextField t80;

    @FXML
    private TextField t81;
    
    @FXML
    private TextField t82;
    
    @FXML
    private TextField t83;
    
    @FXML
    private TextField t84;
        
    @FXML
    private TextField t85;
    
    @FXML
    private TextField t86;
    
    @FXML
    private TextField t87;
    
    @FXML
    private TextField t88;
    
    @FXML
    private Button btnVerifica; 
    
    @FXML
    private Button btnPausa; 
    
    
    @FXML
    private Label lTempo; 
    
    @FXML
    private Label lTempoMin; 
    
    @FXML
    private Label lTempoFinal;  
    
    //variaveis para o tempo  
    long tComeca = System.currentTimeMillis();
    int tSegundos=0;
    int tMinutos=0;
    TimerTask task;
    Connection conn;
    PreparedStatement pst = null;
    String sUser ;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
    FXMLLoginController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        assert btnVerifica != null : "fx:id=\"btnVerifica\" was not injected: check your FXML file 'FXMLPuzzle.fxml'.";    
        conn = SqlConnection.DBconnector();  
        contaTempo();   
        controller = loader.getController();
        //sUser= controller.getUser().get();
        //System.out.println(controller.getUser().get());
         
        //primeiro nº do TextFiled = coluna e segundo nº = linha (t1º2º)
        //Sudoku dificuldade = facil
        final TextField Tf [][] = {{t00,t01,t02,t03,t04,t05,t06,t07,t08}
            ,{t10,t11,t12,t13,t14,t15,t16,t17,t18}
            ,{t20,t21,t22,t23,t24,t25,t26,t27,t28}
            ,{t30,t31,t32,t33,t34,t35,t36,t37,t38}
            ,{t40,t41,t42,t43,t44,t45,t46,t47,t48}
            ,{t50,t51,t52,t53,t54,t55,t56,t57,t58}
            ,{t60,t61,t62,t63,t64,t65,t66,t67,t68}
            ,{t70,t71,t72,t73,t74,t75,t76,t77,t78}
            ,{t80,t81,t82,t83,t84,t85,t86,t87,t88}};
    
   
        //ciclo para colocar os numeros do puzzle facil nos textfields, onde i=colunas e j=linhas
        for(int i=0;i<Tf.length;i++) {
            for(int j=0; j<Tf.length;j++){
                if(i==5 && j==3 || i==6 && j==5)
                     Tf[i][j].setText("1");
                if(i==0 && j==2 || i==1 && j==5 || i==8 && j==6 || i==2 && j==8)
                     Tf[i][j].setText("2");
                if(i==1 && j==1 || i==3 && j==3 || i==2 && j==4 || i==0 && j==6 || i==7 && j==7)
                     Tf[i][j].setText("3");
                if(i==2 && j==5)
                     Tf[i][j].setText("4");
                if(i==8 && j==1 || i==0 && j==5 || i==2 && j==6 || i==4 && j==7 )
                     Tf[i][j].setText("5");
                if(i==7 && j==0 || i==2 && j==1 || i==1 && j==8)
                     Tf[i][j].setText("6");
                if(i==6 && j==0 || i==0 && j==3 || i==3 && j==4 || i==8 && j==8)
                     Tf[i][j].setText("7");
                if(i==8 && j==2 || i==5 && j==7 || i==7 && j==8)
                     Tf[i][j].setText("8");
                if(i==0 && j==0 || i==3 && j==1)
                     Tf[i][j].setText("9");
                
                //se ja tiver numeros nao deixar editar
                if(Tf[i][j].getText().equals("1") || Tf[i][j].getText().equals("2")
                        || Tf[i][j].getText().equals("3") || Tf[i][j].getText().equals("4")
                        || Tf[i][j].getText().equals("5") || Tf[i][j].getText().equals("6")
                        || Tf[i][j].getText().equals("7") || Tf[i][j].getText().equals("8")
                        || Tf[i][j].getText().equals("9"))
                        Tf[i][j].setEditable(false);
                
                }
            }
                conn = SqlConnection.DBconnector();  
                //botao para verificar a resolucao tabuleiro facil
                btnVerifica.setOnAction((ActionEvent event) -> {
                    if(Tf[2][0].getText().equals("1") && Tf[7][1].getText().equals("1") && Tf[4][2].getText().equals("1")
                            && Tf[1][4].getText().equals("1") && Tf[3][6].getText().equals("1") && Tf[8][7].getText().equals("1")
                            && Tf[0][8].getText().equals("1")){
                        if(Tf[5][0].getText().equals("2") && Tf[6][1].getText().equals("2") && Tf[4][3].getText().equals("2")
                                && Tf[7][4].getText().equals("2") && Tf[3][7].getText().equals("2")){
                            if(Tf[4][0].getText().equals("3") && Tf[6][2].getText().equals("3") && Tf[8][5].getText().equals("3")
                                    && Tf[5][8].getText().equals("3")){
                                if(Tf[8][0].getText().equals("4") && Tf[5][1].getText().equals("4") && Tf[1][2].getText().equals("4")
                                        && Tf[6][3].getText().equals("4") && Tf[4][4].getText().equals("4") && Tf[7][6].getText().equals("4")
                                        && Tf[0][7].getText().equals("4") && Tf[3][8].getText().equals("4")){
                                    if(Tf[1][0].getText().equals("5") && Tf[3][2].getText().equals("5") && Tf[7][3].getText().equals("5")
                                            && Tf[5][4].getText().equals("5") && Tf[6][8].getText().equals("5")){
                                        if(Tf[5][2].getText().equals("6") && Tf[8][3].getText().equals("6") && Tf[0][4].getText().equals("6")
                                                && Tf[3][5].getText().equals("6") && Tf[4][6].getText().equals("6") && Tf[6][7].getText().equals("6")){
                                            if(Tf[4][1].getText().equals("7") && Tf[2][2].getText().equals("7") && Tf[7][5].getText().equals("7")
                                                    && Tf[5][6].getText().equals("7") && Tf[1][7].getText().equals("7")){
                                                if(Tf[3][0].getText().equals("8") && Tf[0][1].getText().equals("8") && Tf[2][3].getText().equals("8")
                                                        && Tf[6][4].getText().equals("8") && Tf[4][5].getText().equals("8") && Tf[1][6].getText().equals("8")){
                                                    if(Tf[7][2].getText().equals("9") && Tf[1][3].getText().equals("9") && Tf[8][4].getText().equals("9")
                                                            && Tf[5][5].getText().equals("9") && Tf[6][6].getText().equals("9") && Tf[2][7].getText().equals("9")
                                                            && Tf[4][8].getText().equals("9"))
                                                        lTempoFinal.setText(tMinutos + " m : " + tSegundos + " s");
                                                        /*try{
                                                            String query = "UPDATE UserDatabase SET min=?,seg=? WHERE name=?; ";
                                                            pst = conn.prepareStatement(query);
                                                            pst.setInt(1, tMinutos);
                                                            pst.setInt(2, tSegundos);
                                                            pst.setString(3, userLog.txtUser.getText());
                                                            pst.execute();
                                                            pst.close();
                                                            } catch(Exception e1) {
                                                                System.out.println(e1);
                                                            }*/
                                                        createOverlayVerificar("O puzzle foi completado com sucesso!");
                                                }//fecha o 8
                                                else {
                                                    createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                                                }
                                            }//fecha o 7
                                            else {
                                                createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                                            }
                                        }//fecha o 6
                                        else {
                                            createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                                        }
                                    }//fecha o 5
                                    else {
                                        createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                                    }
                                }//fecha o 4
                                else {
                                    createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                                }
                            }//fecha o 3
                            else {
                                createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                            }
                        }//fecha o 2
                        else {
                            createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                        }
                    }//fecha o 1
                    else {
                        createOverlayVerificar("O puzzle não está correto ou ainda não foi concluído!");
                    }
        });
                
                btnPausa.setOnAction((ActionEvent event) -> {
                    try
                    {
                        task.cancel();
                    }
                    catch (Exception e)
                    {
                    }
                    createOverlayPausa("PAUSA");
        });
                
                
                
        
    }
    
    public void contaTempo(){
    //tempo que comeca a contar
    Timer myTime = new Timer();
    task = new TimerTask() {
            @Override
            public void run() {
                tSegundos++;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        if (tSegundos == 60){
                            tSegundos = 0;
                            tMinutos++;
                        }    
                        lTempoMin.setText(tMinutos+ " m :" );
                        lTempo.setText(" " + tSegundos+ " s" );
                    }
                });
            }
        };
    
        //contar de 1 em 1 segundos
        myTime.scheduleAtFixedRate(task, 1000, 1000);
    }
    
        protected void createOverlayVerificar(String strMessage){

        //Creates buttons, label, original scene, and original window for overlay
        Button btnResume = new Button("Continuar");
        Button btnMainMenu = new Button("Menu Principal");
        Label lblMessage = new Label(strMessage);
        Scene origScene = t88.getScene();
        Stage window = (Stage) origScene.getWindow();
       
        //Setting up the buttons
        btnResume.setMaxWidth(200);
        btnMainMenu.setMaxWidth(200);

        //This section for setting the display of buttons
        VBox layout = new VBox(lblMessage, btnMainMenu,btnResume);
        //desfocar background
        layout.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");
        layout.setMaxWidth(t88.getScene().getWidth());
        layout.setMaxHeight(t88.getScene().getHeight());
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        //End section


        //This gets a snapshot of the game, then blurs it and sets it as the background
        //Maybe use fade animation?
        ImageView imageView = new ImageView(t88.getScene().snapshot(null));
        imageView.setEffect(new GaussianBlur(35));

        //This combines the blurred background with the buttons
        StackPane background = new StackPane(imageView,layout);

        //Creates a new scene for the overlay
        Scene scene4Overlay = new Scene(background);

        //Displays overlay to user (replaces game board scene)
        window.setScene(scene4Overlay);
        
        
                //User chooses play again, game board resets and scene is switched
        //to game board
        btnResume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            window.setScene(origScene);
            }
        });


        //User chooses Main Menu, scene for main menu is created and then switched too.
        btnMainMenu.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                Scene scene1 = new Scene((Parent) loader.load());
                window.setScene(scene1);
            } catch (Exception ignored){}
        });
        
    }
        
       
protected void createOverlayPausa(String strMessage){

        //Creates buttons, label, original scene, and original window for overlay
        Button btnResume = new Button("Continuar");
        Button btnMainMenu = new Button("Menu Principal");
        Label lblMessage = new Label(strMessage);
        Scene origScene = t88.getScene();
        Stage window = (Stage) origScene.getWindow();
       
        //Setting up the buttons
        btnResume.setMaxWidth(200);
        btnMainMenu.setMaxWidth(200);

        //This section for setting the display of buttons
        VBox layout = new VBox(lblMessage, btnMainMenu,btnResume);
        //desfocar background
        layout.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");
        layout.setMaxWidth(t88.getScene().getWidth());
        layout.setMaxHeight(t88.getScene().getHeight());
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        //End section


        //This gets a snapshot of the game, then blurs it and sets it as the background
        //Maybe use fade animation?
        ImageView imageView = new ImageView(t88.getScene().snapshot(null));
        imageView.setEffect(new GaussianBlur(35));

        //This combines the blurred background with the buttons
        StackPane background = new StackPane(imageView,layout);

        //Creates a new scene for the overlay
        Scene scene4Overlay = new Scene(background);

        //Displays overlay to user (replaces game board scene)
        window.setScene(scene4Overlay);
        
        
                //User chooses play again, game board resets and scene is switched
        //to game board
        btnResume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                contaTempo();
                
            window.setScene(origScene);
            }
        });


        //User chooses Main Menu, scene for main menu is created and then switched too.
        btnMainMenu.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenu.fxml"));
                Scene scene1 = new Scene((Parent) loader.load());
                window.setScene(scene1);
            } catch (Exception ignored){}
        });


    }
    
}
