/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;
import logic.Spreadsheet;
import utils.Position;

/**
 *
 * @author joao
 */
public class Number extends FactoryCalculations{


    @Override
    String operations(ArrayList<String> value) {
      
        
        if(value.size() > 1){
            return "#ERROR";
        }
        if(value.isEmpty()){
            return String.valueOf("0");
        }
        if(value.size() == 1){
            if(!verifyIsNumber(value.get(0))){
                return String.valueOf("0");
            }
        }
        return String.valueOf(Double.parseDouble(value.get(0)));
    
    }
    
}
