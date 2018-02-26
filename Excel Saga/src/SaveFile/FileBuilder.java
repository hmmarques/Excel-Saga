/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;

import logic.Cell;
import logic.Spreadsheet;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileBuilder {
    String name;
    String path;
    String extention;
    
    
    public abstract void buildFile();
    
//    public abstract String addCellValue(String s);
    
    public abstract String FileHeader ();
    
    public abstract String FileFinal ();
    
    public static FileBuilder getBuilder(String ext){
    switch(ext){
        case "csv": return new CSVBuilder();
        case "xml": return new XMLBuilder();
        case "html": return new HTMLBuilder();
        default: return null;
    }       
    };
  
    public Cell[][]getMatrixinfo(){
    return Spreadsheet.getSpreadsheet().getMatrix();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }
    
    
    
}
