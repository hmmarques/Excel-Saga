/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

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

    public EditCell(Position p, String value, String originalvalue) {
        this.originalvalue = originalvalue;
        this.value = value;
        this.p = p;
    }
    
    
    
    @Override
    public void Do() {
         System.out.println("passei no DOOOO da editCell");
         
         System.out.println("recebi: " + originalvalue);
         Spreadsheet.getSpreadsheet().setCellValue(p,value);
    }

    @Override
    public void Undo() {
        System.out.println("passei no undo da editCell");
       // Spreadsheet.getSpreadsheet().getCell(p).setValue(originalvalue);
       Spreadsheet.getSpreadsheet().setCellValue(p, originalvalue);
    }
    
    
    
}
