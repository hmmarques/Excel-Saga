/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;


import java.io.FileWriter;
import java.io.IOException;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class CSVBuilder extends FileBuilder {

    //Delimiter used in CSV file
    private static final String DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";

    FileWriter fileWriter = null;
    //CSV file header

    public CSVBuilder() {
        super.setExtension(".csv");
    }

    @Override
    public void buildFile() {
        System.out.println("build file (CSV)");

        String aux_Matrix[][] = getMatrixinfo();
        if (aux_Matrix == null) {
            System.out.print("matrix nulla ao tentar criar o ficheiro CSV");
            return;
        }

        try {

            fileWriter = new FileWriter(name + extension);

            for (int i = 0; i < Constants.N_ROWS; i++) {
                if (i != 0) {
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }

                for (int y = 0; y < Constants.N_COLUMNS; y++) {
                    if (y == 0) {
                        fileWriter.append(aux_Matrix[i][y]);
                    } else {
                        fileWriter.append(DELIMITER);
                        fileWriter.append(aux_Matrix[i][y]);
                    }
                }
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            //e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                //e.printStackTrace();
            }
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
