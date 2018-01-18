/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author henriquemarques
 */
public class Position {
    
    int row;
    int collumn;

    public Position(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCollumn() {
        return collumn;
    }

    public void setCollumn(int collumn) {
        this.collumn = collumn;
    }
    
    
}
