/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.util.StringTokenizer;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileType {

    public static FileType CreateObject(String s) {
        //fabrica de objetos para saber que tipo de extencao o ficheiro e depois devolver
        //o objeto correspondente para descodificar o ficheiro para a spreadsheet

        int cont = 0;
        String extension = "";
        StringTokenizer token;

        token = new StringTokenizer(s, ".");
        while (token.hasMoreTokens()) {
            extension = token.nextToken();
        }

        switch (extension) {
            case "csv":
                return new CSVFile();
            case "html":
                return new HTMLFile();
            case "bin":
                return new BINFile();
            default:
                return null;
        }
    }

    public abstract void readFileType(File f);
    
    public boolean Verify_Cols(int col) {
        return col <= Constants.N_COLUMNS;
    }

    public boolean Verify_Rows(int raw) {
        return raw <= Constants.N_ROWS;
    }
}
