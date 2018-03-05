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
public class PositiveFilter extends CellFilter {

    public PositiveFilter(Cell c) {
        this.cell = c;
    }

    @Override
    public String getValue() {
        double n = 0;

        try {
            n = Double.parseDouble(this.cell.getValue());
        } catch (NumberFormatException e) {
            return this.cell.getValue();
        }

        if (n > 0) {
            return n + "";
        }
        return "";
    }

    @Override
    public void setValue(String value) {
        this.cell.setValue(value);
    }
}
