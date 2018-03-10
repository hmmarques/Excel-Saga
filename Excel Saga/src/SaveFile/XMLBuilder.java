/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jsoup.nodes.Element;
import utils.Constants;


/**
 *
 * @author Sergio Cruz
 */
public class XMLBuilder extends FileBuilder{
    
    //Delimiter used in XML file
    
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String OPEN_MAIN_TAG= "<spreadsheet>";
    private static final String CLOSE_MAIN_TAG= "</spreadsheet>";
    private static final String OPEN_LINE_TAG= "<line>";
    private static final String CLOSE_LINE_TAG = "</line>";
    private static final String OPEN_COLUMN_TAG= "<column>";
    private static final String CLOSE_COLUMN_TAG = "</column>";
  

    FileWriter fileWriter = null;
    
    public XMLBuilder() {
        super.setExtension(".xml");
        
    }
  
    @Override
    public void buildFile() {
       System.out.println("Building file (XML)");
        String aux_Matrix[][] = getMatrixinfo();
        if (aux_Matrix == null) {
            System.out.print("Array without values at the creation of the XML file");
            return;
        }
        try {
            
            fileWriter = new FileWriter(name + extension);
            
            System.out.println("File created and now copying the array values of the Saga spreadsheet to the xml file by doing append to the created file");
            
           //Write the XML file header
            fileWriter.append(FileHeader());
            
           //Pass the array content to the xml file and construct the xml file with its specific tags
           
            //Add a new line separator after the header and open the main tag
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(OPEN_MAIN_TAG);
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a cell to the HTML file
            for (int i = 0; i < Constants.N_ROWS; i++) {
               
                fileWriter.append(OPEN_LINE_TAG);
                fileWriter.append(NEW_LINE_SEPARATOR);

                for (int y = 0; y < Constants.N_COLUMNS; y++) {
                    fileWriter.append(OPEN_COLUMN_TAG);
                    fileWriter.append(aux_Matrix[i][y]);
                    fileWriter.append(CLOSE_COLUMN_TAG);
                    fileWriter.append(NEW_LINE_SEPARATOR);

                }
                
              fileWriter.append(CLOSE_LINE_TAG);
          
            }
            
            //Add a new line separator at the end and close the main tag
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(CLOSE_MAIN_TAG);
                                      
            //Write the XML file footer
            fileWriter.append(FileFinal());
           
            System.out.println("XML file was created successfully !!!");
                        
        }
        catch (IOException e) {
            System.out.println("Error in the XML FileWriter !!!");
            //e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                //e.printStackTrace();
            }
        }
       
    }

    @Override
    public String FileHeader() {
        String s;
        s = "<?xml version = \"1.0\" encoding = \"UTF-8\" standalone = \"no\"?>";
        return s;
    }

    @Override
    public String FileFinal() {
        String s;
        s = "\n";
        return s;
    }

    
    
}
