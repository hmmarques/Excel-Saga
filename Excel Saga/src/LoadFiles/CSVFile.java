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
public class CSVFile extends FileType{
    
    public void ReadCSVFile(File f) throws FileNotFoundException{
         System.out.println("read CSVFile !");
     
         String Matrix[][] = new String[Constants.N_ROWS][Constants.N_COLUMNS];
         
        //25 colunas
        //100 linhas
        
        int n_linha = 0;
        int n_colunas = 0;
        
        if(f.exists()){
       
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
                    
                ++n_linha;                  
                
		String linha = 	sc.nextLine();
                System.out.println(linha);
                
                String[] parts = linha.split(";");
                              
                n_colunas = parts.length;               
                if(!Verify_Cols(n_colunas)){
                //erro o ficheiro está corrompido
                System.out.println("numero de colunas não aceitavel");
                return;
                }
                
                
                    for (int i = 0; n_colunas > i;i++){                                             
                       Matrix[n_linha-1][i] = parts[i];                       
                    }
              
                }
            if(!Verify_Rows(n_linha))
            {
            //mensagem de erro 
                System.out.println("numero de linhas não aceitavel");
                //return ;
            }else{

            //coloca a matriz obtida para a spreadsheet
                System.out.println("matriz de dados com nº linha: " + n_linha );
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
            ReadCSVFile(f);
        } catch (FileNotFoundException ex) {
           
        }
    }
    
}
