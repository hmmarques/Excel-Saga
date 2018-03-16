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
import utils.Constants;

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

        String aux_Matrix[][] = getMatrixinfo();

        try {
            try (FileOutputStream fos = new FileOutputStream(name + extension); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                
                oos.writeObject(Constants.CODE);
                
                for (int i = 0; i < Constants.N_ROWS; i++) {
                    for (int j = 0; j < Constants.N_COLUMNS; j++) {
                        oos.writeObject(aux_Matrix[i][j]);
                    }
                }
                
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    @Override
    public String FileHeader() {
        return "";
    }

    @Override
    public String FileFinal() {
        return "";
    }
}
