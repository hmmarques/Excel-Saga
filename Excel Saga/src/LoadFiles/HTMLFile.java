/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Spreadsheet;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class HTMLFile extends FileType{
    
    public void ReadHTMLFile(File f) throws FileNotFoundException{
    
        System.out.println("read HTMLFile !");
     
         String Matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];
         
        //25 colunas
        //100 linhas
        
        int n_linha = 0;
        int n_colunas = 0;
        
        if(f.exists()){
       
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
                String linha = 	sc.nextLine();
                System.out.println(linha);
                
                if (linha.contains("<tr")) {
                ++n_colunas;
                
                
                
                
                System.out.println("File HTML table found Java!");
                String[] parts = linha.split("td");
                
                
                
                
                }  
                    ++n_linha;    
                    
		
                
                              
                //n_colunas = parts.length;
                
                if(!Verify_Cols(n_colunas)){
                //erro o ficheiro está corrompido
                System.out.println("numero de colunas não aceitavel");
                return;
                }
                
                
//                    for (int i = 0; parts.length > i;i++){
//                       Matrix[n_linha][i] = parts[i];
//                    }
               
                }
            if(!Verify_Rows(n_linha))
            {
            //mensagem de erro 
                System.out.println("numero de linhas não aceitavel");
                //return ;
            }else{

            //coloca a matriz obtida para a spreadsheet
                System.out.println("matriz de dados com nº linha: " + n_linha + " colunas: " + n_colunas);
                Spreadsheet sp = Spreadsheet.getSpreadsheet();                    
                sp.setMatriz(Matrix);
            }        
                
        }else
        {
        System.out.println("fICHEIRO NÃO EXISTE!");
        }
    
    
    };

    public boolean Verify_Cols(int col){
    return col <= Constants.N_COLUMNS;       
    }
    
    public boolean Verify_Rows(int raw){
    return raw <= Constants.N_ROWS;
    }

    @Override
    public void readFileType(File f) {
        try {
            ReadHTMLFile(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
