/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import utils.*;

/**
 *
 * @author Sergio Cruz
 */
public class Spreadsheet {

    Cell[][] Matrix = new Cell[Constants.N_ROWS][Constants.N_COLUMNS];
    ArrayList<Filter>[][] MatrixFilters = new ArrayList[Constants.N_ROWS][Constants.N_COLUMNS];
    static Spreadsheet ss;
    boolean addToFilterArrayList = true;

    public Spreadsheet() {
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                Matrix[i][j] = new ExcelCell("");
                MatrixFilters[i][j] = new ArrayList<>();
            }
        }
    }

    public static Spreadsheet getSpreadsheet() {
        if (ss == null) {
            ss = new Spreadsheet();
        }
        return ss;
    }

    public void setCellValue(Position p, String value) {
        getCell(p).setValue(value);
    }

    public Cell getCell(Position p) {
        return Matrix[p.getRow()][p.getColumn()];
    }

    public void setCell(Position p, Cell c) {
        Matrix[p.getRow()][p.getColumn()] = c;
    }

    public void removeAllFilters(Position p) {
        Matrix[p.getColumn()][p.getRow()] = new ExcelCell(Matrix[p.getColumn()][p.getRow()].getValue());
    }

    public Cell[][] getMatrix() {

        return this.Matrix;
    }

    public void applyFilter(Position p, Constants.Filter filter, String filterValue) {
        Cell currentCell = getCell(p);
        Cell afterFilterCell;
        switch (filter) {
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
        if (afterFilterCell != null) {
            if(addToFilterArrayList){
                MatrixFilters[p.getRow()][p.getColumn()].add(new Filter(filter));
            }
            setCell(p, afterFilterCell);
        }
    }

    public void removeFilter(Position p, Constants.Filter filter) {

        for(int i = 0; i < MatrixFilters[p.getRow()][p.getColumn()].size(); i++){
            if(MatrixFilters[p.getRow()][p.getColumn()].get(i).getFilter().equals(filter)){
                MatrixFilters[p.getRow()][p.getColumn()].remove(MatrixFilters[p.getRow()][p.getColumn()].get(i));
            }
        }
        
        Cell core = getCell(p);
        while(!(core instanceof ExcelCell)){
            core = ((CellFilter)core).getInsideCell();
        }
        
        setCell(p, core);
        
        addToFilterArrayList = false;
        MatrixFilters[p.getRow()][p.getColumn()].forEach((f) -> {
            applyFilter(p, f.getFilter(), f.getValue());
        });
        addToFilterArrayList = true;
    }
}
