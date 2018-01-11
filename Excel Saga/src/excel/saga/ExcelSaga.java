/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.saga;

import InterfacePackage.InterfaceSheet;
import InterfacePackage.Login;

/**
 *
 * @author henriquemarques
 */
public class ExcelSaga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        System.out.println("2020");
        boolean aux = false;
        
        Login login = new Login();
        login.show();
        
        /*
         this.loginAccept = true;//metodo para validar user 
        if(this.loginAccept){
            InterfaceSheet face = new InterfaceSheet();
            face.show();
        }
        */
        
        System.out.println("loool");
        
    }
    
}
