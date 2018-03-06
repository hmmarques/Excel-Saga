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
public class Add extends FactoryCalculations{

    @Override
    int calculate() {
        return this.value1 + this.value2;
    }
    
}
