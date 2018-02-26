/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import logic.Spreadsheet;
import utils.Constants;
import utils.Position;

/**
 *
 * @author Judith
 */
public class FunctionalViewMode implements StrategyViewMode {
    
    Spreadsheet spreadsheet;

    public FunctionalViewMode() {
        spreadsheet = Spreadsheet.getSpreadsheet();
    }
    
    @Override
    public String[][] viewSpreadsheet() {

        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                m[i][j] = spreadsheet.getCell(new Position(i, j)).getValue();
            }
        }
        return m;

    }
    
    
}
