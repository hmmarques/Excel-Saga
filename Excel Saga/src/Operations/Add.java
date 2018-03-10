/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import static ViewMode.NormalViewMode.verifyIsNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import logic.Spreadsheet;
import utils.Position;

/**
 *
 * @author joao
 */
public class Add extends FactoryCalculations{

    Map<String, Integer> charCoordinate;
    Spreadsheet spreadsheet;

    @Override
    String operations(ArrayList<String> value) {
        charCoordinate = new HashMap<String, Integer>();
        initializeCharCoordinate();
        spreadsheet = Spreadsheet.getSpreadsheet();
        
        double res=0;
        
        if (value.get(0).contains(":")) {
            return verifyIfMultipleAddAndReturnValue(value.get(0));
        } else {
            
                for (int i = 0; i < value.size(); i++) {
                    if (value.get(i).isEmpty()) {
                        res += 0;
                    } else {
                        res += Double.parseDouble(value.get(i));
                    }
                }
            }
        
        return String.valueOf(res);
    }
    
    public String verifyIfMultipleAddAndReturnValue(String cmd){
        
        int i = 0;
        String cmd1;
        String cmd2;
        String line;
        String col;
        String line2;
        String col2;
        int res=0;
        
        
        StringTokenizer st = new StringTokenizer(cmd,":");
        
        cmd1 = st.nextToken();
        cmd2 = st.nextToken();
        
        
        line = String.valueOf(cmd1.charAt(0));
        col = cmd1.substring(1);
        line2 = String.valueOf(cmd2.charAt(0));
        col2 = cmd2.substring(1);
        
        if(Integer.parseInt(col) > Integer.parseInt(col2)){
            if(this.charCoordinate.get(line.toUpperCase())>this.charCoordinate.get(line2.toUpperCase())){
                for (int j = Integer.parseInt(col2); j <= Integer.parseInt(col); j++) {
                    for (int k = this.charCoordinate.get(line2.toUpperCase()); k <= this.charCoordinate.get(line.toUpperCase()); k++) {
                        if(verifyIsNumber(spreadsheet.getCellValue(new Position(j, k)))){
                            res += Integer.parseInt(spreadsheet.getCellValue(new Position(j, k)));
                        }
                        
                    }
                }
            } else{
                for (int j = Integer.parseInt(col2); j <= Integer.parseInt(col); j++) {
                    for (int k = this.charCoordinate.get(line.toUpperCase()); k <= this.charCoordinate.get(line2.toUpperCase()); k++) {
                        if(verifyIsNumber(spreadsheet.getCellValue(new Position(j, k)))){
                            res += Integer.parseInt(spreadsheet.getCellValue(new Position(j, k)));
                        }
                        
                    }
                }
            }
        }else{
            if(this.charCoordinate.get(line.toUpperCase())>this.charCoordinate.get(line2.toUpperCase())){
                for (int j = Integer.parseInt(col); j <= Integer.parseInt(col2); j++) {
                    for (int k = this.charCoordinate.get(line2.toUpperCase()); k <= this.charCoordinate.get(line.toUpperCase()); k++) {
                        if(verifyIsNumber(spreadsheet.getCellValue(new Position(j, k)))){
                            res += Integer.parseInt(spreadsheet.getCellValue(new Position(j, k)));
                        }
                        
                    }
                }
            }
            else{
                for (int j = Integer.parseInt(col); j <= Integer.parseInt(col2); j++) {
                    for (int k = this.charCoordinate.get(line.toUpperCase()); k <= this.charCoordinate.get(line2.toUpperCase()); k++) {
                        if(verifyIsNumber(spreadsheet.getCellValue(new Position(j, k)))){
                           res += Integer.parseInt(spreadsheet.getCellValue(new Position(j, k)));
                        }
                        
                    }
                }
            }
        }
        
        return String.valueOf(res);
 
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
