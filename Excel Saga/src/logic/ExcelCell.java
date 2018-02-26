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
public class ExcelCell extends Cell{

    ExcelCell(String value) {
    }  
    
    @Override
    public String getValue(){
        return value;
    }
    
    @Override
    public void setValue(String value){
        this.value = value;
    }
}
