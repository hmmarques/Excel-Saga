/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveFile;


import java.io.FileWriter;
import java.io.IOException;
import utils.Constants;

/**
 *
 * @author Sergio Cruz
 */
public class HTMLBuilder extends FileBuilder{
    
   //Delimiter used in HTML file
    
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String OPEN_TAG_TR = "<tr>";
    private static final String CLOSE_TAG_TR = "</tr>";
    private static final String OPEN_TAG_TD = "<td>";
    private static final String CLOSE_TAG_TD = "</td>";
    
    FileWriter fileWriter = null;

    public HTMLBuilder() {
        super.setExtension(".html");
    }

    @Override
    public void buildFile() {
        System.out.println("build file (HTML)");

        String aux_Matrix[][] = getMatrixinfo();
        if (aux_Matrix == null) {
            System.out.print("matrix nula ao tentar criar o ficheiro HTML");
            return;
        }
        try {

            fileWriter = new FileWriter(name);

            //Write the HTML file header
            fileWriter.append(FileHeader());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a cell to the HTML file
            for (int i = 0; i < Constants.N_ROWS; i++) {
                fileWriter.append(OPEN_TAG_TR);
                fileWriter.append(NEW_LINE_SEPARATOR);

                for (int y = 0; y < Constants.N_COLUMNS; y++) {
                    fileWriter.append(OPEN_TAG_TD);
                    fileWriter.append(aux_Matrix[i][y]);
                    fileWriter.append(CLOSE_TAG_TD);
                    fileWriter.append(NEW_LINE_SEPARATOR);

                }

                //fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.append(CLOSE_TAG_TR);
            }

            fileWriter.append(FileFinal());

            System.out.println("HTML file was created successfully !!!");

        } catch (IOException e) {
            System.out.println("Error in HTMLFileWriter !!!");
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
        s = "<!DOCTYPE html> \n"
                + "<html> \n"
                + "<head> \n"
                + "<meta charset=\"UTF-8\"/> \n"
                + "<title>Document</title> \n"
                + "</head> \n"
                + "<body> \n"
                + "<table> \n";

        return s;
    }

    @Override
    public String FileFinal() {
        String s;
        s = "</table> /n </body> /n </html>";

        return s;
    }
}
