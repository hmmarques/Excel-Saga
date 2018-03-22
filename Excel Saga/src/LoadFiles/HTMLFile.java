/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import logic.Spreadsheet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class HTMLFile extends FileType {

    public void ReadHTMLFile(File f) throws FileNotFoundException, IOException {

        System.out.println("read HTMLFile !");

        String Matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];

        int n_linha = 0;
       

        if (f.exists()) {
            Document doc = Jsoup.parse(f, "UTF-8");

            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");

            for (int i = 1; i < rows.size(); i++) {
                ++n_linha;
                Element row = rows.get(i-1);
                Elements cols = row.select("td");
              //  System.out.println("i= " + cols.size());
              
                if (!Verify_Cols(cols.size())) {
                    //erro o ficheiro não é suportado
                    System.out.println("Nº of colums not allowed - " + cols.size() + " _ max:" + Constants.N_COLUMNS);
                    return;
                }

                for (int j = 0; cols.size() > j; j++) {
                    Matrix[i-1][j] = row.select("td").get(j).text();
                }

            }

            if (!Verify_Rows(n_linha)) {
                //mensagem de erro 
                System.out.println("Nº of rows not allowed _ " + n_linha + " _max:" + Constants.N_ROWS);
                //return ;
            } else {

                Spreadsheet sp = Spreadsheet.getSpreadsheet();
                sp.setMatriz(Matrix);
                System.out.println("HTML file was loaded successfully !!!");
            }

        } else {
            System.out.println("fICHEIRO DOES NOT EXIST!");
        }

    }

    @Override
    public void readFileType(File f) {
        try {
            ReadHTMLFile(f);
        } catch (FileNotFoundException ex) {
            System.out.println("fILE NOT FOUND!");
        } catch (IOException ex) {
            System.out.println("PARCING fILE ERROR!");
        }
    }
}
