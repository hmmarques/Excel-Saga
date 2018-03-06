/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacePackage;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controller.Controller;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import utils.Constants;
import utils.Position;

/**
 *
 * @author joao
 */
public class InterfaceSheet extends javax.swing.JFrame {

    private int row, column, rowAux, columnAux;
    private boolean overlookTableListener;
    private String cmdAux;
    private boolean controlTxtAreaform;
    private boolean insertedTextOnTxtArea = false;
    /**
     * Creates new form InterfaceSheet
     */
    Controller controller;

    public InterfaceSheet() {
        row = -1;
        column = -1;
        rowAux = -1;
        columnAux = -1;
        cmdAux = "";
        controlTxtAreaform = true;
        initComponents();
        controller = new Controller();
        JRNormal.setSelected(true);

        jTable1.getModel().addTableModelListener((e) -> {
            if (!overlookTableListener) {
                System.out.println("row-> " + row + "  Column->" + column);
                System.out.println("rowAux-> " + rowAux + "  ColumnAux->" + columnAux);
                controller.setCellValue(column, row, jTable1.getModel().getValueAt(row, column).toString());
                TxtAreaform.setText(jTable1.getModel().getValueAt(row, column).toString());
                overlookTableListener = true;
                jTable1.getModel().setValueAt(controller.getCellValue(new Position(row, column)), row, column);
            }
            overlookTableListener = false;
        });

        TxtAreaform.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (controlTxtAreaform) {
                    cmdAux = TxtAreaform.getText();
                    System.out.println("removeUpdate: " + cmdAux);
                    System.out.println("col: " + column + "  row: " + row);
                    System.out.println("colAux: " + columnAux + "  rowAux: " + rowAux);

                    if (rowAux != -1 && columnAux != -1) {
                        controller.setCellValue(columnAux, rowAux, cmdAux);
                    }
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (controlTxtAreaform) {
                    cmdAux = TxtAreaform.getText();
                    System.out.println("insertUpdate: " + cmdAux);
                    System.out.println("col: " + column + "  row: " + row);
                    System.out.println("colAux: " + columnAux + "  rowAux: " + rowAux);

                    if (rowAux != -1 && columnAux != -1) {
                        controller.setCellValue(columnAux, rowAux, cmdAux);
                    }
                    insertedTextOnTxtArea = true;
                }

            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                if (controlTxtAreaform) {
                    cmdAux = TxtAreaform.getText();
                    System.out.println("changedUpdate: " + cmdAux);

                    if (rowAux != -1 && columnAux != -1) {
                        controller.setCellValue(columnAux, rowAux, cmdAux);
                    }
                }
            }

        });

    }

    public void updateTable() {
        String[][] matrix = controller.getMatrix();
        // System.out.println("res = "+matrix[0][0]);

        for (int i = 0; i < Constants.N_ROWS; i++) {
            for (int j = 0; j < Constants.N_COLUMNS; j++) {
                overlookTableListener = true;
                jTable1.getModel().setValueAt(matrix[i][j], i, j);
            }
        }

    }

    public void updateFilters() {
        ArrayList<utils.Filter> filters = controller.getFilters(new Position(row, column));

        JCBUppercase.setSelected(false);
        JRPositive.setSelected(false);
        JRNegative.setSelected(false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");

        for (utils.Filter f : filters) {
            switch (f.getFilter()) {
                case UPPERCASE:
                    JCBUppercase.setSelected(true);
                    break;
                case POSITIVE:
                    JRPositive.setSelected(true);
                    break;
                case NEGATIVE:
                    JRNegative.setSelected(true);
                    break;
                case BIGGERTHAN:
                    jTextField1.setText(f.getValue());
                    break;
                case SMALLERTHAN:
                    jTextField2.setText(f.getValue());
                    break;
                case EQUAL:
                    jTextField3.setText(f.getValue());
                    break;
                default:

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JRNormal = new javax.swing.JRadioButton();
        JRFunctional = new javax.swing.JRadioButton();
        JCBUppercase = new javax.swing.JCheckBox();
        JRPositive = new javax.swing.JRadioButton();
        JRNegative = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaform = new javax.swing.JTextArea();
        BTNcsv = new javax.swing.JButton();
        BTNxml = new javax.swing.JButton();
        BTNhtml = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        BtnApplyFilters = new javax.swing.JButton();
        BTNchooseFile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        JRNormal.setText("Normal");
        JRNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRNormalMouseClicked(evt);
            }
        });
        JRNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRNormalActionPerformed(evt);
            }
        });

        JRFunctional.setText("Functional");
        JRFunctional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRFunctionalMouseClicked(evt);
            }
        });
        JRFunctional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRFunctionalActionPerformed(evt);
            }
        });

        JCBUppercase.setText("Uppercase");
        JCBUppercase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCBUppercaseMouseClicked(evt);
            }
        });
        JCBUppercase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBUppercaseActionPerformed(evt);
            }
        });

        JRPositive.setText("Positive");
        JRPositive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRPositiveMouseClicked(evt);
            }
        });
        JRPositive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRPositiveActionPerformed(evt);
            }
        });

        JRNegative.setText("Negative");
        JRNegative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRNegativeMouseClicked(evt);
            }
        });

        jLabel1.setText("Bigger");

        jLabel2.setText("Equal");

        jLabel3.setText("Smaller");

        TxtAreaform.setColumns(20);
        TxtAreaform.setRows(5);
        TxtAreaform.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtAreaformFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtAreaformFocusLost(evt);
            }
        });
        TxtAreaform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtAreaformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TxtAreaform);

        BTNcsv.setText("CSV");
        BTNcsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNcsvMouseClicked(evt);
            }
        });
        BTNcsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcsvActionPerformed(evt);
            }
        });

        BTNxml.setText("XML");
        BTNxml.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNxmlMouseClicked(evt);
            }
        });

        BTNhtml.setText("HTML");
        BTNhtml.setMaximumSize(new java.awt.Dimension(51, 23));
        BTNhtml.setMinimumSize(new java.awt.Dimension(51, 23));
        BTNhtml.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNhtmlMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "W", "X", "Y", "Z"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowSelectionAllowed(false);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        BtnApplyFilters.setText("Apply Filters");
        BtnApplyFilters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnApplyFiltersMouseClicked(evt);
            }
        });
        BtnApplyFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApplyFiltersActionPerformed(evt);
            }
        });

        BTNchooseFile.setText("Choose File");
        BTNchooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNchooseFileMouseClicked(evt);
            }
        });
        BTNchooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNchooseFileActionPerformed(evt);
            }
        });

        jButton1.setText("Undo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Redo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JRNormal)
                            .addComponent(JRFunctional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBUppercase)
                            .addComponent(JRNegative)
                            .addComponent(JRPositive))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(jTextField1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BtnApplyFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BTNcsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTNxml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BTNhtml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(170, 170, 170))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BTNchooseFile)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNcsv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNxml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNhtml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNchooseFile))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JRNormal)
                            .addComponent(JCBUppercase)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JRFunctional)
                            .addComponent(JRPositive)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(JRNegative)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(BtnApplyFilters)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRNormalActionPerformed
        // TODO add your handling code here:
        if (JRNormal.isSelected()) {
            JRFunctional.setSelected(false);
            controller.setView("normal");
        } else {
            JRFunctional.setSelected(true);
        }
        this.updateTable();
    }//GEN-LAST:event_JRNormalActionPerformed

    private void JRFunctionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRFunctionalActionPerformed
        // TODO add your handling code here:
        if (JRFunctional.isSelected()) {
            JRNormal.setSelected(false);
            controller.setView("functional");
        } else {
            JRNormal.setSelected(true);
        }
        this.updateTable();
    }//GEN-LAST:event_JRFunctionalActionPerformed

    private void JCBUppercaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBUppercaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBUppercaseActionPerformed

    private void JRPositiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRPositiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRPositiveActionPerformed

    private void BtnApplyFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApplyFiltersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnApplyFiltersActionPerformed

    private void BtnApplyFiltersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnApplyFiltersMouseClicked
        controller.removeFilter(new Position(row, column), Constants.Filter.BIGGERTHAN);
        if (!jTextField1.getText().equals("")) {
            controller.applyFilter(new Position(row, column), Constants.Filter.BIGGERTHAN, jTextField1.getText());
        }

        controller.removeFilter(new Position(row, column), Constants.Filter.SMALLERTHAN);
        if (!jTextField2.getText().equals("")) {
            controller.applyFilter(new Position(row, column), Constants.Filter.SMALLERTHAN, jTextField2.getText());
        }

        controller.removeFilter(new Position(row, column), Constants.Filter.EQUAL);
        if (!jTextField3.getText().equals("")) {
            controller.applyFilter(new Position(row, column), Constants.Filter.EQUAL, jTextField3.getText());
        }
        updateTable();
    }//GEN-LAST:event_BtnApplyFiltersMouseClicked

    private void JRNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRNormalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JRNormalMouseClicked

    private void JRFunctionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRFunctionalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JRFunctionalMouseClicked

    private void JCBUppercaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCBUppercaseMouseClicked
        if (row != -1 || column != -1) {
            if (JCBUppercase.isSelected()) {
                controller.applyFilter(new Position(row, column), Constants.Filter.UPPERCASE, "");
            } else {
                controller.removeFilter(new Position(row, column), Constants.Filter.UPPERCASE);
            }
            updateTable();
        }
    }//GEN-LAST:event_JCBUppercaseMouseClicked

    private void JRPositiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRPositiveMouseClicked
        if (row != -1 || column != -1) {
            if (JRPositive.isSelected()) {
                controller.applyFilter(new Position(row, column), Constants.Filter.POSITIVE, "");
            } else {
                controller.removeFilter(new Position(row, column), Constants.Filter.POSITIVE);
            }
            updateTable();
        }
    }//GEN-LAST:event_JRPositiveMouseClicked

    private void JRNegativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRNegativeMouseClicked
        if (row != -1 || column != -1) {
            if (JRNegative.isSelected()) {
                controller.applyFilter(new Position(row, column), Constants.Filter.NEGATIVE, "");
            } else {
                controller.removeFilter(new Position(row, column), Constants.Filter.NEGATIVE);
            }
            updateTable();
        }
    }//GEN-LAST:event_JRNegativeMouseClicked

    private void BTNxmlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNxmlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNxmlMouseClicked

    private void BTNchooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNchooseFileMouseClicked

        ChooseFile face = new ChooseFile(this);
        face.setVisible(true);
    }//GEN-LAST:event_BTNchooseFileMouseClicked

    private void BTNhtmlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNhtmlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNhtmlMouseClicked

    private void BTNcsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNcsvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNcsvMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        // JOptionPane.showMessageDialog(null,"x= "+jTable1.getSelectedColumn()+"   y= "+jTable1.getSelectedRow());
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {

                //controlTxtAreaform = false;
                //TxtAreaform.setText((String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()));
                //controlTxtAreaform = true;
            }
        });

    }//GEN-LAST:event_jTable1MouseClicked

    private void BTNchooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNchooseFileActionPerformed


    }//GEN-LAST:event_BTNchooseFileActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String teste = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
            JOptionPane.showMessageDialog(null, teste);

        }


    }//GEN-LAST:event_jTable1KeyPressed

    private void TxtAreaformFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAreaformFocusLost
        // TODO add your handling code here:
        // controlTxtAreaform = true;
        System.out.println("row: " + row);
        System.out.println("column:" + column);
        System.out.println("rowAux: " + rowAux);
        System.out.println("columnAux: " + columnAux);
        System.out.println("re: " + cmdAux);
        System.out.println("re:" + jTable1.getModel().getValueAt(rowAux, columnAux).toString());
        if (insertedTextOnTxtArea) {
            controller.setCellValue(columnAux, rowAux, cmdAux);
            insertedTextOnTxtArea = false;
        }

        this.updateTable();
    }//GEN-LAST:event_TxtAreaformFocusLost

    private void TxtAreaformFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAreaformFocusGained

        rowAux = jTable1.getSelectedRow();
        columnAux = jTable1.getSelectedColumn();
    }//GEN-LAST:event_TxtAreaformFocusGained

    private void TxtAreaformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtAreaformMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAreaformMouseClicked

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
        //System.out.println("x: "+jTable1.getSelectedRow() + "y: " + jTable1.getSelectedColumn());
    }//GEN-LAST:event_jTable1FocusGained

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        //this.cmdAux = this.TxtAreaform.getText();
        row = jTable1.getSelectedRow();
        column = jTable1.getSelectedColumn();

        controlTxtAreaform = false;
        TxtAreaform.setText((String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()));
        controlTxtAreaform = true;

        System.out.println("row-> " + row + "  Column->" + column);
        System.out.println("rowAux-> " + rowAux + "  ColumnAux->" + columnAux);
        updateFilters();
    }//GEN-LAST:event_jTable1MousePressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.redo();
        updateTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.undo();
        updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNcsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcsvActionPerformed
        controller.export("csv");
    }//GEN-LAST:event_BTNcsvActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceSheet().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNchooseFile;
    private javax.swing.JButton BTNcsv;
    private javax.swing.JButton BTNhtml;
    private javax.swing.JButton BTNxml;
    private javax.swing.JButton BtnApplyFilters;
    private javax.swing.JCheckBox JCBUppercase;
    private javax.swing.JRadioButton JRFunctional;
    private javax.swing.JRadioButton JRNegative;
    private javax.swing.JRadioButton JRNormal;
    private javax.swing.JRadioButton JRPositive;
    private javax.swing.JTextArea TxtAreaform;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
