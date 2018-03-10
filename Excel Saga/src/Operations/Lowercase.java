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
public class Lowercase extends FactoryCalculations{

    @Override
    String operations(ArrayList<String> value) {
        
        if(value.size() > 1){
            return "#ERROR";
        }
        return value.get(0).toLowerCase();
    }
    
}

