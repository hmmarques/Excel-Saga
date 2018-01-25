/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Controller.Command;
import utils.*;

/**
 *
 * @author Sergio Cruz
 */
public class Spreadsheet implements Command{
    
    Cell Matrix[][] = new Cell[Constants.N_ROWS][Constants.N_COLUMNS];
    static Spreadsheet ss;
    
    
    
    public Spreadsheet() {
        
    }
    
    public static Spreadsheet getSpreadsheet()
    {
            if(ss == null)
            {
                ss = new Spreadsheet();
            }
            return ss;
    }
    
    public Cell getcell(Position p){
        return Matrix[p.getCollumn()][p.getRow()];
    }
    
    public void setCell(Position p, Cell c){
        Matrix[p.getCollumn()][p.getRow()] = c;
    }
    
    public void removeAllFilters(Position p){
        Matrix[p.getCollumn()][p.getRow()] = new ExcelCell(Matrix[p.getCollumn()][p.getRow()].getValue());
    }

    public Cell[][] getMatrix() {
        
        return this.Matrix;
    }

    @Override
    public void Redo(Cell[][] m) {
        this.Matrix = m;
    }

    @Override
    public void Undo(Cell[][] m) {
         this.Matrix = m;
    }
}
