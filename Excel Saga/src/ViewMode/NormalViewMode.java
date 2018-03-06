/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import Operations.FactoryCalculations;
import logic.Spreadsheet;
import utils.Constants;
import utils.Position;


/**
 *
 * @author Judith
 */
public class NormalViewMode implements StrategyViewMode {

    Spreadsheet spreadsheet;

    public NormalViewMode() {

        spreadsheet = Spreadsheet.getSpreadsheet();
    }

    @Override
    public String[][] viewSpreadsheet() {

        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                m[i][j] = spreadsheet.getCellValue(new Position(i, j));
                
                if (1 == 1) {
                    FactoryCalculations f = FactoryCalculations.createFactory("SOMA");
                    f.setvalue1;
                    f.setvalue2;
                    f.calculate();
                    
                }
            }
        }
        return m;
    }

}
