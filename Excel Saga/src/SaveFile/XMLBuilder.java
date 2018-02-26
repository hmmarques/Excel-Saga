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
    public String FileHeader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String FileFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
