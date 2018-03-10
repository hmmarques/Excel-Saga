/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.Command;
import LoadFiles.FileAdapter;
import LoadFiles.SagaFile;
import Command.CommandManager;
import Command.EditCell;
import SaveFile.FileBuilder;
import ViewMode.FunctionalViewMode;
import ViewMode.NormalViewMode;
import ViewMode.StrategyViewMode;
import java.io.File;
import java.util.ArrayList;
import logic.Spreadsheet;
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
    StrategyViewMode s = new NormalViewMode();

    public Controller() {
        this.spreadsheet = Spreadsheet.getSpreadsheet();
        this.Cmg = CommandManager.getInstance();
        this.SFile = new FileAdapter();
    }

    public void upload() {
        //funçao deixa escolher o ficheiro

        //OpenFile();
        //escolheu o ficheiro
        //adapter ... e supostamente a spreadsheet fica com os dados do ficheiro carregado.
    }

    ;
    
    public void export(String extension) {
        
        FileBuilder fb = FileBuilder.getBuilder(extension);
        fb.setName("TEMP");      
        fb.buildFile();
    }

    public void setCellValue(int column, int row, String value) {

        //spreadsheet.setCellValue(new Position(row, column), value);
        //aqui é que deve guardar?
        //cria comando
        Position p = new Position(row, column);
        Command cmd = new EditCell(p, value, spreadsheet.getCellValue(p));
        Cmg.applyCommand(cmd);
    }

    public void redo() {
        Cmg.Redo();
    }

    public void undo() {
        Cmg.Undo();
    }

    public String[][] getMatrix() {
        return s.viewSpreadsheet();
    }
    
    public void setView(String view){
        
        if(view.equals("normal")){
            s = new NormalViewMode();
        }
        else{
            s = new FunctionalViewMode();
        }
    }
    public ArrayList<utils.Filter> getFilters(Position p) {
        return spreadsheet.getFilters(p);
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

    public String getCellValue(Position position) {
        return spreadsheet.getCellValue(position);
    }
    
    

}
