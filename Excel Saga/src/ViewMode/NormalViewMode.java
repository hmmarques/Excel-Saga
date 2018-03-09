/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

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
        charCoordinate = new HashMap<String, Integer>();
        initializeCharCoordinate();
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
        if(cmd != null){
            if (!cmd.isEmpty()) {
                return String.valueOf(cmd.charAt(0)).equals("=");
            } else {
                return false;
            }
        }
        return false;
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
            
            if(verifyIsNumber(values.get(j))){
                f.addValue(values.get(j));
            }else{
                f.addValue(valueOfCoordinate(values.get(j)));
            }
            
        }
        
        return f.calculate();
    }
    
    public static boolean verifyIsNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public String valueOfCoordinate(String cmd){
        String line;
        String col; 
        
        col = cmd.substring(1);
        line = String.valueOf(cmd.charAt(0));
        
        return spreadsheet.getCellValue(new Position(Integer.parseInt(col), this.charCoordinate.get(line)));
        //return null;
    }
    
    public void initializeCharCoordinate(){
        charCoordinate.put("A", 0);
        charCoordinate.put("B", 1);
        charCoordinate.put("C", 2);
        charCoordinate.put("D", 3);
        charCoordinate.put("E", 4);
        charCoordinate.put("F", 5);
        charCoordinate.put("G", 6);
        charCoordinate.put("H", 7);
        charCoordinate.put("I", 8);
        charCoordinate.put("J", 9);
        charCoordinate.put("K", 10);
        charCoordinate.put("L", 11);
        charCoordinate.put("M", 12);
        charCoordinate.put("N", 13);
        charCoordinate.put("O", 14);
        charCoordinate.put("P", 15);
        charCoordinate.put("Q", 16);
        charCoordinate.put("R", 17);
        charCoordinate.put("S", 18);
        charCoordinate.put("T", 19);
        charCoordinate.put("U", 20);
        charCoordinate.put("W", 21);
        charCoordinate.put("X", 22);
        charCoordinate.put("Y", 23);
        charCoordinate.put("Z", 24);
    }
}
