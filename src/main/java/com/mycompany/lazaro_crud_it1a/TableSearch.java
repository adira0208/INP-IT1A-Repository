/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lazaro_crud_it1a;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 1
 */
public class TableSearch extends javax.swing.JFrame {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    String dataInfo, SID, SFname, SUname; 
    int flag= 0;
    Statement statement;
    
    String tableHeader[]= {"ID","FULLNAME","USERNAME"};
    DefaultTableModel tblmodel = new DefaultTableModel();
    
    
    /**
     * Creates new form TableSearch
     */
     
    public TableSearch() {
        initComponents();
         setLocationRelativeTo(null);
         setResizable(false);
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         setDriver();
        
        
    }
     public void setDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //establish connnection
            con = DriverManager.getConnection("jdbc:mysql://localhost/inpit1a","root","");
        }catch(ClassNotFoundException | SQLException e){ 
            JOptionPane.showMessageDialog(null, e.getMessage());
        }//end of catch
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        cboOption = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JTextField();
        btnFetch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FetchData");
        setResizable(false);

        cboOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ID", "FULLNAME", "USERNAME", " ", " " }));
        cboOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOptionActionPerformed(evt);
            }
        });

        btnFetch.setText("Fetch Data");
        btnFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "FULLNAME", "USERNAME"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClose)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cboOption, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btnFetch, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFetch)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboOptionActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

  txtData.setText("");
  tblData.setModel(new DefaultTableModel());
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnFetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchActionPerformed
// TODO add your handling core here;
//refresh the table
tblmodel.fireTableDataChanged();
// create new data table model
tblmodel = new DefaultTableModel();
//and set column headers
tblmodel.setColumnIdentifiers(tableHeader);
//set the tablemOdel
tblData.setModel(tblmodel);
//autofit content
tblData.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
tblData.setFillsViewportHeight(true);
//get the search data
dataInfo = txtData.getText();
try{
    // ALL Option
    if(cboOption.getSelectedItem().equals("ALL")){
    stmt = con.prepareStatement("SELECT * FROM users;");
    rs = stmt.executeQuery();
    while(rs.next()){
        flag = 1; //record is present
       // Assign the string value from mysql table
        SID = rs.getString("id");
        SFname= rs.getString("fullname");
        SUname = rs.getString("uname");
        tblmodel.addRow(new Object[]{SID, SFname, SUname});      
    }//end of WHILE
    if(flag==0)
        JOptionPane.showMessageDialog(null,"No record found!","Error Message", JOptionPane.ERROR_MESSAGE);
    
}//END OF IF 
    
    else if(cboOption.getSelectedItem().equals("ID")){
    stmt = con.prepareStatement("SELECT * FROM users WHERE ID = " + dataInfo);
    rs = stmt.executeQuery();
    while(rs.next()){
        flag = 1; //record is present
       // Assign the string value from mysql table
        SID = rs.getString("id");
        SFname= rs.getString("fullname");
        SUname = rs.getString("uname");
        tblmodel.addRow(new Object[]{SID, SFname, SUname});      
    }//end of WHILE
    if(flag==0)
        JOptionPane.showMessageDialog(null,"No record found!","Error Message", JOptionPane.ERROR_MESSAGE);
    
}//END OF IF 
    
    else if(cboOption.getSelectedItem().equals("FULLNAME")){
    stmt = con.prepareStatement("SELECT * FROM users WHERE fullname like '%" + dataInfo +"%'");
    rs = stmt.executeQuery();
    while(rs.next()){
        flag = 1; //record is present
       // Assign the string value from mysql table
        SID = rs.getString("id");
        SFname= rs.getString("fullname");
        SUname = rs.getString("uname");
        tblmodel.addRow(new Object[]{SID, SFname, SUname});      
    }//end of WHILE
    if(flag==0)
        JOptionPane.showMessageDialog(null,"No record found!","Error Message", JOptionPane.ERROR_MESSAGE);
    
}//END OF IF 
    
    else if(cboOption.getSelectedItem().equals("USERNAME")){
    stmt = con.prepareStatement("SELECT * FROM users WHERE uname like '%" + dataInfo +"%'");
    rs = stmt.executeQuery();
    while(rs.next()){
        flag = 1; //record is present
       // Assign the string value from mysql table
        SID = rs.getString("id");
        SFname= rs.getString("fullname");
        SUname = rs.getString("uname");
        tblmodel.addRow(new Object[]{SID, SFname, SUname});      
    }//end of WHILE
    if(flag==0)
        JOptionPane.showMessageDialog(null,"No record found!","Error Message", JOptionPane.ERROR_MESSAGE);
    
}//END OF IF 
    
}catch(SQLException | HeadlessException ex){
    JOptionPane.showMessageDialog(null,ex.getMessage());
    
    
}//end of catch block
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFetchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed


        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(TableSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFetch;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboOption;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
