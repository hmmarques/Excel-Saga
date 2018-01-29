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
public class FileAdapter implements SagaFile {
   FileType ft; 

    public FileAdapter() {
        //referências para os objetos a adaptar.
    
    }

    @Override
    public void readFile(File f) {
     
        
        
      ft = FileType.CreateObject(f.getAbsolutePath());
      
      ft.readFileType(f);
            
        
        
//        CSVf.ReadCSVFile(OpenFile(path));
//        XMLf.ReadXMLFile(OpenFile(path));
//        HTMLf.ReadHTMLFile(OpenFile(path));
        
    }
    
    
}
