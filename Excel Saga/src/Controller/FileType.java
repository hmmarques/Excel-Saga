/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileType {
    public static FileType CreateObject(String s){
    //fabrica de objetos para saber que tipo de extencao o ficheiro e depois devolver
    //o objeto correspondente para descodificar o ficheiro para a spreadsheet
        
        //split path ou caso ja receba a extensao nao sera necessario split
        
        //if( extensao xml )
        // return new XMLFile();
        //else
        //if( extensao csv )
        // return new CSVFile();
        //else
        //if( extensao html )
        // return new HTMLFile();
        
        
        return null;
    }
    
    public abstract void readFileType(File f);
}
