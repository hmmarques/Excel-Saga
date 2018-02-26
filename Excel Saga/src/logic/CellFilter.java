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
public abstract class CellFilter extends Cell{
    
    Cell cell;
    
    String filterValue;

    public CellFilter() {
        //getFilters().add(this);
    }
    
    @Override
    public abstract String getValue();
    
    @Override
    public abstract void setValue(String value);
}
