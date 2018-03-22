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
         Spreadsheet.getSpreadsheet().setCellValue(p,value);
    }

    @Override
    public void Undo() {
       Spreadsheet.getSpreadsheet().setCellValue(p, originalvalue);
    }
    
    
    
}
