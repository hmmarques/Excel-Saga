/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    
    public void setCellValue(Position p, String value){
        spreadsheet.getcell(p).setValue(value);
        
        //aqui é que deve guardar?
       // Cmg.apply(spreadsheet);
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
        this.Cmg = new CommandManager();
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
}
