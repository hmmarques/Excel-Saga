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

        //25 colunas
        //100 linhas
        Document doc = Jsoup.parse(f, "UTF-8");

        ArrayList<String> downServers = new ArrayList<>();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            System.out.println("i=" + i + row.text());
//    if (cols.get(7).text().equals("down")) {
//        downServers.add(cols.get(5).text());
//    }

            String[] values = row.text().split(" ");

        }

//        int n_linha = 0;
//        int n_colunas = 0;
//        
//        if(f.exists()){
//       
//		Scanner sc = new Scanner(f);
//		
//                while (sc.hasNextLine()){
//                String linha = 	sc.nextLine();
//                System.out.println(linha);
//                
//                if (linha.contains("<tr")) {
//                ++n_linha;
//                n_colunas = 0;
//                }else{
//                
//                if(linha.contains("<td")){
//                    
//                String[] parts = linha.split("<td>");
//                ++n_colunas;
//                }
//                
//                
//                
//                System.out.println("File HTML table found Java!");
//                }  
//                       
//                    
//		
//                
//                              
//                //n_colunas = parts.length;
//                
//                if(!Verify_Cols(n_colunas)){
//                //erro o ficheiro está corrompido
//                System.out.println("numero de colunas não aceitavel");
//                return;
//                }
//                
//                
////                    for (int i = 0; parts.length > i;i++){
////                       Matrix[n_linha][i] = parts[i];
////                    }
//               
//                }
//                
//                
//                
//            if(!Verify_Rows(n_linha))
//            {
//            //mensagem de erro 
//                System.out.println("numero de linhas não aceitavel");
//                //return ;
//            }else{
//
//            //coloca a matriz obtida para a spreadsheet
//                System.out.println("matriz de dados com nº linha: " + n_linha + " colunas: " + n_colunas);
//                Spreadsheet sp = Spreadsheet.getSpreadsheet();                    
//                sp.setMatriz(Matrix);
//            }        
//                
//        }else
//        {
//        System.out.println("fICHEIRO NÃO EXISTE!");
//        }
//    
    }

    ;

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
        } catch (IOException ex) {

        }
    }
}
