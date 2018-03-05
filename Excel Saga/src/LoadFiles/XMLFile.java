/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoadFiles;

import java.io.File;

/**
 *
 * @author Sergio Cruz
 */
public class XMLFile extends FileType{
     public void ReadXMLFile(File f){
    
    System.out.println("read XMLFile !");
    

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
    };

   
    @Override
    public void readFileType(File f) {
      ReadXMLFile(f);
    }


}
