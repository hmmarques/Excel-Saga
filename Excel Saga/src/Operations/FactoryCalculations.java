/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public abstract class FactoryCalculations {
        
    ArrayList<String> value;
    String op;
    
    public static FactoryCalculations createFactory(String operation) //fábrica de objectos
    {
       
        switch (operation.toUpperCase()) {
                case "SOMA":
                    return new Add();
                case "MULTIPLE":
                    return new Multiple();
                default:
        }
        
        return null;
    }
    
    abstract String operations(ArrayList<String> value);
    
    public String calculate(){
            
        return operations(value);  
        
    }
    public FactoryCalculations addValue(String val){
        
        if(this.value == null || this.value.size()==0){
            this.value = new ArrayList<String>();
        }
        this.value.add(val);
        return this;
    }
    
};
