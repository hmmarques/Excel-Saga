/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author Sergio Cruz
 */
public abstract class Cell {
    
    String value;
    ArrayList<CellFilter> filters;

    public abstract String getValue();

    public void setValue(String value) {
        this.value = value;
    }  
    
    public ArrayList<CellFilter> getFilters(){
        return filters;
    }
}
