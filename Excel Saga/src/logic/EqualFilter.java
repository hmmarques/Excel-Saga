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
public class EqualFilter extends CellFilter{

    public EqualFilter(Cell c, String value) {
        super();
        this.cell = c;
        this.value = value;
    }
    
    @Override
    public String getValue(){
        return "";
    }
    
}
