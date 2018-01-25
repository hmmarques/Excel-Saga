/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import logic.Spreadsheet;
import utils.Position;

/**
 *
 * @author Sergio Cruz
 */
public class EditCell implements Command{

    String originalvalue;
    String value;
    Position p;

    public EditCell(Position p, String value) {
        this.value = value;
        this.p = p;
    }
    
    
    
    @Override
    public void Do() {
         
         this.originalvalue = Spreadsheet.getSpreadsheet().getcell(p).getValue();
         Spreadsheet.getSpreadsheet().getcell(p).setValue(value);
    }

    @Override
    public void Undo() {
        Spreadsheet.getSpreadsheet().getcell(p).setValue(originalvalue);
    }
    
    
    
}
