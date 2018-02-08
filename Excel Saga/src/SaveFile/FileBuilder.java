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
public abstract class FileBuilder {
    
    
    public abstract void buildFile();
    
    public abstract void addCellValue();
    
    public abstract void addSeperator();
    
    public abstract File getBuilder();
    
    
}
