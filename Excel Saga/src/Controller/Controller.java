/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.util.ArrayList;
import logic.Cell;
import logic.Spreadsheet;
import logic.*;
import utils.Constants;
import utils.Constants.Filter;
import utils.Position;

/**
 *
 * @author henriquemarques
 */
public class Controller {
    
    Spreadsheet spreadsheet;
    CommandManager Cmg;
    SagaFile SFile;
    
    
    public void upload(){
    //funçao deixa escolher o ficheiro
    
    //OpenFile();
    
    //escolheu o ficheiro
    //adapter ... e supostamente a spreadsheet fica com os dados do ficheiro carregado.
    
    };
    
    public void download(){};
    
    public void setCellValue(Position p, String value){
        spreadsheet.getcell(p).setValue(value);
        
        //aqui é que deve guardar?
        //cria comando
        Command cmd = new EditCell(p,value);
        Cmg.applyCommand(cmd);
    }
    
    public String[][] getMatrix(){
        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS]; 
        for(int i = 0; i < Constants.N_ROWS; i++)
            for(int j = 0; j < Constants.N_COLUMNS; j++)
                m[i][j] = spreadsheet.getcell(new Position(i,j)).getValue();
        return m;
    }
            
            
    public Controller(Spreadsheet spreedsheet) {
        this.spreadsheet = Spreadsheet.getSpreadsheet();
        this.Cmg = CommandManager.getInstance();
        this.SFile = new FileAdapter();
    }
    
    public void applyAllFilters(Position p, ArrayList<Filter> filters, ArrayList<String> values){
        spreadsheet.removeAllFilters(p);
        for(int i = 0; i < filters.size(); i++){
            applyFilter(p, filters.get(i), values.get(i));
        }
    }
    
    
    private void applyFilter(Position p, Filter filter, String filterValue){
        Cell currentCell = spreadsheet.getcell(p);
        Cell afterFilterCell;
        switch (filter){
            case UPPERCASE:
                afterFilterCell = new UpperFilter(currentCell);
                break;
            case POSITIVE:
                afterFilterCell = new PositiveFilter(currentCell);
                break;
            case NEGATIVE:
                afterFilterCell = new NegativeFilter(currentCell);
                break;
            case BIGGERTHAN:
                afterFilterCell = new BiggerThanFilter(currentCell, filterValue);
                break;
            case SMALLERTHAN:
                afterFilterCell = new SmallerThanFilter(currentCell, filterValue);
                break;
            case EQUAL:
                afterFilterCell = new EqualFilter(currentCell, filterValue);
                break;
            default:
                afterFilterCell = null;
        }
        if(afterFilterCell != null){
            spreadsheet.setCell(p, afterFilterCell);
        }
    }
    
    public File OpenFile(){
        
        
        return null;
}
    
}
