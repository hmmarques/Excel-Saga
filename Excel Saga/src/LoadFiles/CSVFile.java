/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import logic.Spreadsheet;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class CSVFile extends FileType {

    public void ReadCSVFile(File f) throws FileNotFoundException {

        System.out.println("read CSVFile !");

        String Matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];

        //25 colunas
        //100 linhas
        int n_linha = 0;
        int n_col;

        if (f.exists()) {

            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) 
            {

                ++n_linha;

                String linha = sc.nextLine();
                System.out.println(linha);

                String[] parts = linha.split(";");

                n_col = parts.length;
                
                if (!Verify_Cols(n_col)) {
                    //erro o ficheiro não é suportado
                    System.out.println("Nº of colums not allowed - " + n_col + " _ max:"+ Constants.N_COLUMNS);
                    return;
                }

                for (int i = 0; n_col > i; i++) {
                    Matrix[n_linha - 1][i] = parts[i];
                }

            }
            
                if (!Verify_Rows(n_linha)) {
                    //mensagem de erro 
                      System.out.println("Nº of rows not allowed _ " + n_linha + " _max:"+ Constants.N_ROWS);
                    //return ;
                } else {

                    Spreadsheet sp = Spreadsheet.getSpreadsheet();

                    sp.setMatriz(Matrix);

                 }

        } else {
            System.out.println("fICHEIRO DOES NOT EXIST!");
        }

    }

    public boolean Verify_Cols(int col) {
        return col <= Constants.N_COLUMNS;
    }

    public boolean Verify_Rows(int raw) {
        return raw <= Constants.N_ROWS;
    }

    @Override
    public void readFileType(File f) {
        try {
            ReadCSVFile(f);
        } catch (FileNotFoundException ex) {
            System.out.println("fILE NOT FOUND!");
        }
    }
}
