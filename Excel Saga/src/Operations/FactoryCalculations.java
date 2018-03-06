/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

/**
 *
 * @author joao
 */
public abstract class FactoryCalculations {
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
    
    abstract String operations(String value1, String value2);
    
    public String calculate(){
        
        operations(value1,value2);   
        
        return null;
    }
    
    String value1;
    String value2;
};
