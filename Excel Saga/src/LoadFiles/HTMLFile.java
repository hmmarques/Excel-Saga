/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
        int n_col;
        //25 colunas
        //100 linhas
        
        if (f.exists()) {
        Document doc = Jsoup.parse(f, "UTF-8");

        ArrayList<String> downServers = new ArrayList<>();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                ++n_linha;
                Element row = rows.get(i);
                Elements cols = row.select("td");
                System.out.println("i=" + i + row.text());


                String[] values = row.text().split(" ");
                n_col = values.length;

                if (!Verify_Cols(n_col)) {
                    //erro o ficheiro não é suportado
                    System.out.println("Nº of colums not allowed - " + n_col + " _ max:"+ Constants.N_COLUMNS);
                    return;
                }

                for(int j = 0 ; n_col > j ; j++){
                Matrix[n_linha-1][j] = values[j];          
                }

            }

        
            if (!Verify_Rows(n_linha)) {
                    //mensagem de erro 
                    System.out.println("Nº of rows not allowed _ " + n_linha + " _max:"+ Constants.N_ROWS);
                    //return ;
            } else {

                Spreadsheet sp = Spreadsheet.getSpreadsheet();

                sp.setMatriz(Matrix);

    //                int limit= 0;
    //                for(String[] ok : Matrix){
    //                for(int i = 0;i<4;i++){
    //                    System.out.print(","+ ok[i]);
    //                }
    //                System.out.println();
    //                if(++limit == 4)
    //                    return;
    //                }
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
            ReadHTMLFile(f);
        } catch (FileNotFoundException ex ) {
            System.out.println("fILE NOT FOUND!");
        }catch (IOException ex ) {
            System.out.println("PARCING fILE ERROR!");
        }
    }
}
