/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Sergio Cruz
 */
public class PositiveFilter extends CellFilter{
   
    public PositiveFilter(Cell c) {
        this.cell = c;
    }
    
    @Override
    public String getValue(){
        return "";
    }
    
    @Override
    public void setValue(String value){
        this.cell.setValue(value);
    }
}
