/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;

import java.io.File;

/**
 *
 * @author Sergio Cruz
 */
public class XMLBuilder extends FileBuilder{

    @Override
    public void buildFile() {
       System.out.println("build file (XML)");
    }

    @Override
    public void addCellValue() {
        System.out.println("add cell (XML)");
    }

    @Override
    public void addSeperator() {
     System.out.println("add seperator (XML)");
    }

    @Override
    public File getBuilder() {
        System.out.println("get builder (XML)");
        
        return null;
    }
    
}
