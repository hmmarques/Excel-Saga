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
public class CSVFile extends FileType{
    
    public void ReadCSVFile(File f){
    System.out.println("read CSVFile !");
    };

    @Override
    public void readFileType(File f) {
        ReadCSVFile(f);
    }
    
}
