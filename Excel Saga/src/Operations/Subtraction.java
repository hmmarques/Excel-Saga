/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class Subtraction  extends FactoryCalculations{


    @Override
    String operations(ArrayList<String> value) {
        double res=0;
        
        for (int i = 0; i < value.size(); i++) {
            if(value.get(i).isEmpty()){
                res -= 0;
            }else{
                if(i==0){
                    res = Double.parseDouble(value.get(i));
                }else{
                    res -= Double.parseDouble(value.get(i));
                }      
            }
        }
        
        return String.valueOf(res);
    }
    
}