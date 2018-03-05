/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author hmmarques
 */
public class Filter {
    
    Constants.Filter filter;
    String value;

    public Filter() {
    }
    
    public Filter(Constants.Filter filter) {
        this.filter = filter;
    }
    
    public Filter(Constants.Filter filter, String value) {
        this.filter = filter;
        this.value = value;
    }

    public Constants.Filter getFilter() {
        return filter;
    }

    public void setFilter(Constants.Filter filter) {
        this.filter = filter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
