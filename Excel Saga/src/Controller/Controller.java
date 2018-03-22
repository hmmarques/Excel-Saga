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
import java.util.HashMap;
import logic.Spreadsheet;
import persistence.Document;
import persistence.Session;
import persistence.UnitOfWork;
import persistence.User;
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
    
    public void export(String name, String extension) {

        FileBuilder fb = FileBuilder.getBuilder(extension);
        fb.setName(name);
        fb.buildFile();
        Document d = new Document(name + "." + extension);
        UnitOfWork work = Session.getSession().getUnitOfWork();
        work.commit();
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

    public void setView(String view) {

        if (view.equals("normal")) {
            s = new NormalViewMode();
        } else {
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

    public void setUser(String username) {
        spreadsheet.setUser(username);
    }

    public ArrayList<String> getFiles(String name) {

        ArrayList<String> d = new ArrayList<>();
        User user = User.load(name);

        if (user == null) {
            User u = new User(name);
            UnitOfWork work = Session.getSession().getUnitOfWork();
            work.commit();
            return d;
        }

        ArrayList<Document> docs = Document.load(User.getID());

        for (Document doc : docs) {
            d.add(doc.getName());
        }

        return d;
    }

    public void loadSheet(String file) {
        File f = new File(file);
        SagaFile sf = new FileAdapter();
        sf.readFile(f);
    }

}
