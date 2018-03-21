/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.saga;

import InterfacePackage.InterfaceSheet;
import InterfacePackage.Login;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistence.Session;


/**
 *
 * @author henriquemarques
 */
public class ExcelSaga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        Session session = Session.getSession();
        Connection connection = session.getConnection();

        //Create table in BD
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            /*statement.executeUpdate("drop table if exists Users");
            statement.executeUpdate("create table USERS (id integer auto_increment, name varchar(50))");
            statement.executeUpdate("drop table if exists Documents");
            statement.executeUpdate("create table DOCUMENTS (id integer auto_increment, userID integer , name varchar(50))");
            statement.executeUpdate("insert into USERS VALUES(1,'H')");
            statement.executeUpdate("insert into DOCUMENTS VALUES(1,1,'DOC_TESTE')");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        boolean aux = false;
        
        Login login = new Login();
        login.show();
            
    }
    
}
