/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Command.Command;
import java.util.ArrayList;

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
    
    
    public void applyCommand(Command c){  
        c.Do();
        RedoList.clear(); //duvida deixar ou nao?
        UndoList.add(c);
    }
    
    public void Undo(){
       if(!UndoList.isEmpty()){
       
       Command last = UndoList.remove(UndoList.size() - 1);
       last.Undo();
       RedoList.add(last);      
       }       
    }
    
    //REDO
    public void Redo(){
       if(!RedoList.isEmpty()){
       
       Command last = RedoList.remove(RedoList.size() - 1);
       last.Do();
       UndoList.add(last);      
       }       
    }
}
