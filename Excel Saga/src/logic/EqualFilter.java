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
public class EqualFilter extends CellFilter {

    public EqualFilter(Cell c, String filterValue) {
        super();
        this.cell = c;
        this.filterValue = filterValue;
    }

    @Override
    public String getValue() {
        double n = 0;

        try {
            n = Double.parseDouble(this.cell.getValue());
        } catch (NumberFormatException e) {
            return this.cell.getValue();
        }

        if (!filterValue.equals("") && n == Double.parseDouble(filterValue)) {
            return n + "";
        }
        return "";
    }

    @Override
    public void setValue(String value) {
        this.cell.setValue(value);
    }

}
