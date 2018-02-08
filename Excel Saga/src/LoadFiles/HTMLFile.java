/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;

/**
 *
 * @author Sergio Cruz
 */
public class HTMLFile extends FileType{
     public void ReadHTMLFile(File f){
    
    System.out.println("read HTMLFile !");
    };

    @Override
    public void readFileType(File f) {
       ReadHTMLFile(f);
    }
}
