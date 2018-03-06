/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import LoadFiles.XMLFile;
import java.io.File;
import java.util.StringTokenizer;

/**
 *
 * @author Sergio Cruz
 */
public abstract class FileType {

    public static FileType CreateObject(String s) {
        //fabrica de objetos para saber que tipo de extencao o ficheiro e depois devolver
        //o objeto correspondente para descodificar o ficheiro para a spreadsheet

        int cont = 0;
        String extention = "";
        StringTokenizer token;
        // String[] parts = s.split(".");

        //String[] parts = s.split(".",-1);
        token = new StringTokenizer(s, ".");
        while (token.hasMoreTokens()) {
            extention = token.nextToken();
        }

        if (extention.equals("xml")) {
            return new XMLFile();
        } else if (extention.equals("csv")) {
            return new CSVFile();
        } else if (extention.equals("html")) {
            return new HTMLFile();
        } else {
            return null;
        }
    }

    public abstract void readFileType(File f);
}
