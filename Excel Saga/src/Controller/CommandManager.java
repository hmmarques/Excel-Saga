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
    ArrayList<Command> UndoList = new ArrayList<>();
    ArrayList<Command> RedoList = new ArrayList<>();
   
    private static CommandManager CMg = null;
    //Cell  model[][];

    public CommandManager() {
      //  this.model = Spreadsheet.getSpreadsheet().getMatrix();
    }
    
    public static CommandManager getInstance() {
		if(CMg == null) {
			CMg = new CommandManager();
		}
		return CMg;
	}
    
    
    public void apply(Command c){  
        //sp.Do(modelo);
        RedoList.clear(); //duvida
        UndoList.add(c);
    }
    
    public void Undo(){
       if(!UndoList.isEmpty()){
       
       Command last = UndoList.remove(UndoList.size() - 1);
       //Command.Undo();
       RedoList.add(last);      
       }       
    }
    
    //REDO
    public void Redo(){
       if(!RedoList.isEmpty()){
       
//       Cell last[][] = RedoList.remove(RedoList.size() - 1);
//       sp.Redo(last);
//       UndoList.add(last);      
       }       
    }
}
