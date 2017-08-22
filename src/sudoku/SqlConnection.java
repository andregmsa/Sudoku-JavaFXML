/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.sql.*;

/**
 *
 * @author andre
 */
public class SqlConnection {
    
    public static Connection DBconnector(){
        try{
            Connection conn=null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserDatabase.sqlite");
            return conn;
            
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return null;
    
    }
    
}
