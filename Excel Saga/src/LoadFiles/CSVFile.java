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
import javafx.scene.Cursor;
import logic.Cell;
import logic.Spreadsheet;
import sun.security.provider.VerificationProvider;
import utils.Constants;



/**
 *
 * @author Sergio Cruz
 */
public class CSVFile extends FileType{
    
    public void ReadCSVFile(File f) throws FileNotFoundException{
         System.out.println("read CSVFile !");
     
         Cell Matrix[][] = new Cell[Constants.N_ROWS][Constants.N_COLUMNS];
         
          //25 colunas
          //100 linhas
         int n_linha = 0;
          
        if(f.exists()){
       
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){
                ++n_linha;    
                    
		String linha = 	sc.nextLine();
                    System.out.println(linha);
                String[] parts = linha.split(";");
               
                
                
                int n_colunas = parts.length;
                
                if(!Verify_Cols(n_colunas)){
                //erro o ficheiro está corrompido
                return;
                }
                
                
                    for (int i = 0; parts.length > i;i++){
                       Matrix[n_linha][i].setValue(parts[i]);
                    }
               
                }
            if(!Verify_Rows(n_linha))
            {
            //mensagem de erro 
                //return ;
            }else{

            //coloca a matriz obtida para a spreadsheet
            //Spreadsheet sp = Spreadsheet.getSpreadsheet();
            //sp.setMatriz(mtz);
            }        
                
        }else
        {
        System.out.println("fICHEIRO NÃO EXISTE!");
        }
    
    
    };

    public boolean Verify_Cols(int col){
    return col == Constants.N_COLUMNS;       
    }
    
    public boolean Verify_Rows(int raw){
    return raw == Constants.N_ROWS;
    }
    
    
    @Override
    public void readFileType(File f) {
        try {
            ReadCSVFile(f);
        } catch (FileNotFoundException ex) {
           
        }
    }
    
}
