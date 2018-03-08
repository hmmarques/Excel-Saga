/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;

import logic.Cell;
import logic.Spreadsheet;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileBuilder {

    String name;
    String path;
    String extension;

    public abstract void buildFile();

//    public abstract String addCellValue(String s);

    public abstract String FileHeader();

    public abstract String FileFinal();

    public static FileBuilder getBuilder(String ext) {
        switch (ext) {
            case "csv":
                return new CSVBuilder();
            case "xml":
                return new XMLBuilder();
            case "html":
                return new HTMLBuilder();
            case "bin": 
                return new BINBuilder();
            default:
                return null;
        }
    }
  
    public String[][] getMatrixinfo() {
        String matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        
       for(String[] linha : matrix){
        for(int i = 0; i<Constants.N_COLUMNS;i++ ){
        linha[i] = Spreadsheet.getSpreadsheet().getMatrix()[1][1].getValue();
        }
       }       

        return matrix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
