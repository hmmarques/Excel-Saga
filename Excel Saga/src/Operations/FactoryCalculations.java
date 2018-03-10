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
        
    ArrayList<String> value = new ArrayList<String>();
    String op;
    
    public static FactoryCalculations createFactory(String operation) //fábrica de objectos
    {
       
        switch (operation.toUpperCase()) {
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
        }
        
        return null;
    }
    
    abstract String operations(ArrayList<String> value);
    
    public String calculate(){
            
        return operations(value);  
        
    }
    public FactoryCalculations addValue(String val){
        
        this.value.add(val);
        
        return this;
    }
    
};
