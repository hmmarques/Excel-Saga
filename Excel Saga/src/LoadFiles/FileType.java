/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import LoadFiles.XMLFile;
import java.io.File;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileType {
   
    
    public static FileType CreateObject(String s){
    //fabrica de objetos para saber que tipo de extencao o ficheiro e depois devolver
    //o objeto correspondente para descodificar o ficheiro para a spreadsheet
        System.out.println(s);
     
     // String[] parts = s.split(".");
      
        
    String extention = "xml";
    
    //System.out.println(parts[1]);
        //split path ou caso ja receba a extensao nao sera necessario split
        
        if( extention.equals("xml"))
         return new XMLFile();
        else
        if( extention.equals("csv"))
         return new CSVFile();
        else
        if(extention.equals("html"))
         return new HTMLFile();
        else
        return null;
    }
    
    public abstract void readFileType(File f);
}
