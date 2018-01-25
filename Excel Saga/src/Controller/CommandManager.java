/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import logic.Cell;
import logic.Spreadsheet;

/**
 *
 * @author Sergio Cruz
 */
public class CommandManager{
    ArrayList<Cell [][]> UndoList = new ArrayList<>();
    ArrayList<Cell [][]> RedoList = new ArrayList<>();
    Cell  model[][];

    public CommandManager() {
        this.model = Spreadsheet.getSpreadsheet().getMatrix();
    }
    
    
    
    public void apply(Spreadsheet sp){  
        //sp.Do(modelo);
        RedoList.clear(); //duvida
        UndoList.add(sp.getMatrix());
    }
    
    public void Undo(Spreadsheet sp){
       if(!UndoList.isEmpty()){
       
       Cell last[][] = UndoList.remove(UndoList.size() - 1);
       sp.Undo(last);
       RedoList.add(last);      
       }       
    }
    
    //REDO
    public void Redo(Spreadsheet sp){
       if(!RedoList.isEmpty()){
       
       Cell last[][] = RedoList.remove(RedoList.size() - 1);
       sp.Redo(last);
       UndoList.add(last);      
       }       
    }
}
