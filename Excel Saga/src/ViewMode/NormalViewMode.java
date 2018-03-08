/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import Operations.FactoryCalculations;
import java.util.ArrayList;
import java.util.List;
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

    public NormalViewMode() {

        spreadsheet = Spreadsheet.getSpreadsheet();
    }

    @Override
    public String[][] viewSpreadsheet() {

        String[][] m = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
               
                if(verifyIfFunction(spreadsheet.getCellValue(new Position(i, j)))){
                    m[i][j] = resolveFuntion(spreadsheet.getCellValue(new Position(i, j)));                    
                }else{
                    m[i][j] = spreadsheet.getCellValue(new Position(i, j));
                }
                
            }
        }
        return m;
    }
    
    public boolean verifyIfFunction(String cmd){
        
        if (!cmd.isEmpty()) {
            return String.valueOf(cmd.charAt(0)).equals("=");
        } else {
            return false;
        }
    }
    
    public String resolveFuntion(String cmd){
        
        StringTokenizer st = new StringTokenizer(cmd);
        List<String> values = new ArrayList<String>();
        FactoryCalculations f;
        int i = 0;
        
        while (st.hasMoreTokens()) {
            if(i==0){
                values.add(st.nextToken().substring(1));
                i=1;
            }
            values.add(st.nextToken());
        }
        
        
        f = FactoryCalculations.createFactory(values.get(0));
        
        for (int j = 1; j < values.size(); j++) {
            f.addValue(values.get(j));
        }
        
        
        return f.calculate();
    }
}
