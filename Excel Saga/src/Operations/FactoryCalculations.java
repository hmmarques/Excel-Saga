/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import logic.Spreadsheet;
import utils.Position;

/**
 *
 * @author joao
 */
public abstract class FactoryCalculations {
        
    static ArrayList<String> value = new ArrayList<String>();
    static public String op = "";
    static Map<String, Integer> charCoordinate = new HashMap<String, Integer>();;
    static Spreadsheet spreadsheet = Spreadsheet.getSpreadsheet();
    
    public static FactoryCalculations createFactory(String cmd) //fábrica de objectos
    {
       
        initializeCharCoordinate();
        
        if(verifyIfFunction(cmd)){
            op = getOperations(cmd).toUpperCase();
             value = resolveFuntion(cmd);
             
        }
        else{
            return null;
        }
        
       switch (op.toUpperCase()) {
                case "SOMA":
                    return new Add();
                case "SUBTRAIR":
                    return new Subtraction();
                case "PRODUTO":
                    return new Multiple();
                case "NUMERO":
                    return new Number();
                case "MAIUSCULAS":
                    return new CapitalLetters();
                case "MINUSCULAS":
                    return new Lowercase();
                case "COPIA":
                    return new Copy();
                default:
                    return null;
        }
       
    }
    
    abstract String operations(ArrayList<String> value);
    
    public String calculate(){
            
        return operations(value);  
        
    }
    public FactoryCalculations addValue(String val){
        
        this.value.add(val);
        
        return this;
    }
    
        public static boolean verifyIfFunction(String cmd){
        if(cmd != null){
            if (!cmd.isEmpty()) {
                return String.valueOf(cmd.charAt(0)).equals("=");
            } else {
                return false;
            }
        }
        return false;
    }
        
    public static String getOperations(String cmd){
        StringTokenizer st = new StringTokenizer(cmd);
        String opp = "";
        int i = 0;
        while (st.hasMoreTokens()) {
            if (i == 0) {
                opp = st.nextToken().substring(1);
                i = 1;
            } else {
                st.nextToken();
            }
        }
        return opp;
    }
    
    public static ArrayList<String> resolveFuntion(String cmd){
        
        
        StringTokenizer st = new StringTokenizer(cmd);
        StringTokenizer st2;
        ArrayList<String> values = new ArrayList<String>();
        ArrayList<String> valuescoordinates = new ArrayList<String>();
        List<String> values2 = new ArrayList<String>();
        FactoryCalculations f;
        FactoryCalculations ff;
        String valueCoordinate;
        String opp = "";
        int i = 0;
        int ii = 0;
        
        while (st.hasMoreTokens()) {
            if(i==0){
                opp = st.nextToken().substring(1);
                i=1;
            }else{
                valuescoordinates.add(st.nextToken());
            }
        }
        
        if (values.size()==1){
            //return "#ERROR";
        }
        
        //f = FactoryCalculations.createFactory(values.get(0));
        
        //if(f!=null){
            for (int j = 0; j < valuescoordinates.size(); j++) {

                if(verifyIsNumber(valuescoordinates.get(j))){
                    values.add(values.get(j));
                } else if (verifyIfFunction(valueOfCoordinate(valuescoordinates.get(j)))) {
                    ii = 0;
                    System.out.println("value: " + valuescoordinates.get(j));
                    st2 = new StringTokenizer(valueOfCoordinate(valuescoordinates.get(j)));
                    while (st2.hasMoreTokens()) {
                        //System.out.println("- " + st2.nextToken());
                        if (ii == 0) {
                            values2.add(st2.nextToken().substring(1));
                            ii = 1;
                        }
                        values2.add(st2.nextToken());
                    }
                    for (int k = 1; k < values2.size(); k++) {
                        if (verifyIsNumber(values2.get(k))) {
                            values.add(values2.get(k));
                        } else {
                            values.add(valueOfCoordinate(values2.get(k)));
                        }
                    }
                } else {
                    valueCoordinate = valueOfCoordinate(valuescoordinates.get(j));
                    if(verifyIsNumber(valueCoordinate)){
                        values.add(valueCoordinate);
                    }else{
                        if(op.equals("COPIA")){
                            values.add(valueCoordinate);
                        }
                    }
                    if(op.equals("MAIUSCULAS")){
                        values.add(valueCoordinate);
                    }
                    if(op.equals("MINUSCULAS")){
                        values.add(valueCoordinate);
                    }
                    if(op.equals("SOMA")){
                        if (cmd.contains(":")) {
                            values.add(valuescoordinates.get(j));
                        }
                    }
                }

            }

           // return f.calculate();
//        }
//        else{
//           // return "#ERROR";
//        }
        return values;
    }
    
    public static boolean verifyIsNumber(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    
    public static String valueOfCoordinate(String cmd){
        
        String line;
        String col; 
        
        col = cmd.substring(1);
        line = String.valueOf(cmd.charAt(0));
        
        if(!verifyIsNumber(col)){
            return "#ERROR";
        }
        if(!FactoryCalculations.charCoordinate.containsKey(line.toUpperCase())){
           return "#ERROR"; 
        }
        
        if(col.isEmpty() || line.isEmpty() || col == null || line ==null){
            return "";
        }else{
            return spreadsheet.getCellValue(new Position(Integer.parseInt(col), FactoryCalculations.charCoordinate.get(line.toUpperCase())));
        }
            
        //return null;
    }
    
    public static void initializeCharCoordinate(){
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
};
