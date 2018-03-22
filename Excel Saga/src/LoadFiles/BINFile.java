/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import logic.Spreadsheet;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class BINFile extends FileType{

    @Override
    public void readFileType(File f) {
        System.out.println("read BINFile !");
        String aux_matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];
        try {

            FileInputStream ios = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(ios);

            String validate = (String) ois.readObject();

            for (int i = 0; i < Constants.N_ROWS; i++) {
                for (int j = 0; j < Constants.N_COLUMNS; j++) {
                    aux_matrix[i][j] = (String) ois.readObject();
                }
            }

            ios.close();
            ois.close();

            if (validate.equals(Constants.CODE)) {
                Spreadsheet sp = Spreadsheet.getSpreadsheet();
                sp.setMatriz(aux_matrix);
                System.out.println("BIN file was loaded successfully !!!");
            } else {
                System.out.println("File .bin not allowed");
            }

        } catch (FileNotFoundException e) {
            System.out.println("fILE NOT FOUND!");
            //e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }
    
}
