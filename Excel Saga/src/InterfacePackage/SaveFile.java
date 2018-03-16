/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacePackage;

import java.io.File;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author joao
 */
public class SaveFile extends javax.swing.JFrame {

    /**
     * Creates new form SaveFile
     */
    FileFilter bin = new FileNameExtensionFilter("BIN file(.bin)", "bin");
    FileFilter html = new FileNameExtensionFilter("HTML file(.html)", "html");
    FileFilter xml = new FileNameExtensionFilter("XML file(.xml)", "xml");
    FileFilter csv = new FileNameExtensionFilter("CSV file(.csv)", "csv");
    
    InterfaceSheet is;


    public SaveFile(InterfaceSheet is) {
        this.is = is;
        initComponents();  
        
        jFileSave.addChoosableFileFilter(bin);
        jFileSave.addChoosableFileFilter(html);
        jFileSave.addChoosableFileFilter(xml);
        jFileSave.addChoosableFileFilter(csv);
        
        jFileSave.setFileFilter(bin);
        jFileSave.setAcceptAllFileFilterUsed(false);
        jFileSave.setMultiSelectionEnabled(false);
       
         UIManager.put("FileChooser.filesOfTypeLabelText", "Extension");
         UIManager.put("FileChooser.lookInLabelText", "Save In");
         //UIManager.put("FileChooser.openDialogTitleText", "SAVE");
         SwingUtilities.updateComponentTreeUI(jFileSave);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileSave = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileSave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileSaveActionPerformed
        // TODO add your handling code here:
        
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            
            File fileToSave = jFileSave.getSelectedFile();
            FileFilter choosedFilter = jFileSave.getFileFilter();
            
            String ext = ((FileNameExtensionFilter) choosedFilter).getExtensions()[0];
            //caminho do ficheiro que esta no pc sem extenção
            String full_name = fileToSave.getAbsolutePath();
            
            System.out.println("save file:" + full_name + "  ---   com extençao: " + ext);
            is.controller.export(full_name,ext);

        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            System.out.println("Close");
        }

        this.setVisible(false);
    }//GEN-LAST:event_jFileSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaveFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SaveFile().setVisible(true);
            }
        });
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileSave;
    // End of variables declaration//GEN-END:variables
}
