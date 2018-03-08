/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sergio Cruz
 */
public class BINBuilder extends FileBuilder {

    public BINBuilder() {
        super.setExtension(".bin");
    }

    
    
    
    @Override
    public void buildFile() {
        System.out.println("build file (BIN)");
        
       // Produto Temp;
	
        String aux_Matrix[][] = getMatrixinfo();
        
		try{
			FileOutputStream fos = new FileOutputStream( name + extension);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//for(int i = 0; i < p.size(); i++){
				//Temp = null;
				//Temp = new Produto(p.get(i));
				oos.writeObject(aux_Matrix);
			//}
			
			oos.close();
			fos.close();
			
		}catch(FileNotFoundException e){
			//e.printStackTrace();
		}catch(IOException e){
			//e.printStackTrace();
		}
        
        
        
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
