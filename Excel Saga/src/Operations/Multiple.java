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
public class Multiple extends FactoryCalculations{



    @Override
    String operations(ArrayList<String> value) {
        double res=1;
        
        for (int i = 0; i < value.size(); i++) {
            
            res *= Integer.parseInt(value.get(i));
        }
        
        return String.valueOf(res);
    }
    
}
