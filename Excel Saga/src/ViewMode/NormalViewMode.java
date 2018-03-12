/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import Operations.Add;
import Operations.CapitalLetters;
import Operations.Copy;
import Operations.FactoryCalculations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import logic.Spreadsheet;
import utils.Constants;
import utils.Position;


/**
 *
 * @author Judith
 */
public class NormalViewMode implements StrategyViewMode {

    Spreadsheet spreadsheet;
    Map<String, Integer> charCoordinate;

    public NormalViewMode() {

        spreadsheet = Spreadsheet.getSpreadsheet();
        
        
    }

    @Override
    public String[][] viewSpreadsheet() {

        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
               
//                if(verifyIfFunction(spreadsheet.getCellValue(new Position(i, j)))){
//                    m[i][j] = resolveFuntion(spreadsheet.getCellValue(new Position(i, j)));                    
//                }else{
                    FactoryCalculations f = FactoryCalculations.createFactory(spreadsheet.getCellValue(new Position(i, j)));
                    if(f!=null){
                        m[i][j] = f.calculate();
                    }else{
                        m[i][j] = spreadsheet.getCellValue(new Position(i, j));
                    }
//                }
                
            }
        }
        return m;
    }
}
