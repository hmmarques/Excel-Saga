/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import utils.*;

/**
 *
 * @author Sergio Cruz
 */
public class Spreadsheet {

    Cell[][] Matrix = new Cell[Constants.N_ROWS][Constants.N_COLUMNS];
    static Spreadsheet ss;

    public Spreadsheet() {
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                Matrix[i][j] = new ExcelCell("");
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
            setCell(p, afterFilterCell);
        }
    }

    public void removeFilter(Position p, Constants.Filter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
