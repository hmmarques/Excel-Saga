/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import LoadFiles.FileAdapter;
import LoadFiles.SagaFile;
import Command.EditCell;
import Command.CommandManager;
import Command.Command;
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

    public Controller() {

        spreadsheet = new Spreadsheet();
    }

    public void upload() {
        //funçao deixa escolher o ficheiro

        //OpenFile();
        //escolheu o ficheiro
        //adapter ... e supostamente a spreadsheet fica com os dados do ficheiro carregado.
    }

    ;
    
    public void download() {
    }
    
    public void setCellValue(int column, int row, String value) {
        spreadsheet.setCellValue(new Position(row, column), value);

        //aqui é que deve guardar?
        //cria comando
        //Command cmd = new EditCell(new Position(column, row),value);
        //Cmg.applyCommand(cmd);
    }

    public String[][] getMatrix() {
        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                m[i][j] = spreadsheet.getCell(new Position(i, j)).getValue();
            }
        }
        return m;
    }

    public Controller(Spreadsheet spreedsheet) {
        this.spreadsheet = Spreadsheet.getSpreadsheet();
        this.Cmg = CommandManager.getInstance();
        this.SFile = new FileAdapter();
    }

    public void applyFilter(Position p, Filter filter, String filterValue) {
        spreadsheet.applyFilter(p, filter, filterValue);
    }
    
    public void removeFilter(Position p, Filter filter) {
        spreadsheet.removeFilter(p, filter);
    }
        
    public File OpenFile() {

        return null;
    }

}
