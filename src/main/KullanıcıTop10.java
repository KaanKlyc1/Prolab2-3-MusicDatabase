/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Vector;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alperen
 */
public class KullanıcıTop10 extends javax.swing.JFrame {

    /**
     * Creates new form KullanıcıTop10
     */
    public KullanıcıTop10() {
        initComponents();
        güncelle();
        güncelle1();
        güncelle2();
        güncelle3();
    }
    
    public void güncelle(){
        int i,j;
        try {
            Veritabanı.pstmt= Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_ad,sanatcilar.sanatci_ad,sarkilar.dinlenme FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id) ORDER BY sarkilar.dinlenme desc LIMIT 10");
            Veritabanı.rs= Veritabanı.pstmt.executeQuery();
            ResultSetMetaData AlbumData = Veritabanı.rs.getMetaData();
            i = AlbumData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)genelTop10.getModel();
            RecordTable.setRowCount(0);
            while(Veritabanı.rs.next()){
                Vector columnData = new Vector();
                for(j=1;j<=i;j++){
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("dinlenme"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
        
    }
    
    public void güncelle1(){
        int i,j;
        try {
            Veritabanı.pstmt= Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_ad,sanatcilar.sanatci_ad,sarkilar.dinlenme FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id) WHERE sarkilar.sarki_tur= 'Pop' ORDER BY sarkilar.dinlenme desc LIMIT 10");
            Veritabanı.rs= Veritabanı.pstmt.executeQuery();
            ResultSetMetaData AlbumData = Veritabanı.rs.getMetaData();
            i = AlbumData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)popTop10.getModel();
            RecordTable.setRowCount(0);
            while(Veritabanı.rs.next()){
                Vector columnData = new Vector();
                for(j=1;j<=i;j++){
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("dinlenme"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
        
    }
    
    public void güncelle2(){
        int i,j;
        try {
            Veritabanı.pstmt= Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_ad,sanatcilar.sanatci_ad,sarkilar.dinlenme FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id) WHERE sarkilar.sarki_tur='Jazz' ORDER BY sarkilar.dinlenme desc LIMIT 10");
            Veritabanı.rs= Veritabanı.pstmt.executeQuery();
            ResultSetMetaData AlbumData = Veritabanı.rs.getMetaData();
            i = AlbumData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)jazzTop10.getModel();
            RecordTable.setRowCount(0);
            while(Veritabanı.rs.next()){
                Vector columnData = new Vector();
                for(j=1;j<=i;j++){
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("dinlenme"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
        
    }
    
    public void güncelle3(){
        int i,j;
        try {
            Veritabanı.pstmt= Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_ad,sanatcilar.sanatci_ad,sarkilar.dinlenme FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id) WHERE sarkilar.sarki_tur='Klasik' ORDER BY sarkilar.dinlenme desc LIMIT 10");
            Veritabanı.rs= Veritabanı.pstmt.executeQuery();
            ResultSetMetaData AlbumData = Veritabanı.rs.getMetaData();
            i = AlbumData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)klasikTop10.getModel();
            RecordTable.setRowCount(0);
            while(Veritabanı.rs.next()){
                Vector columnData = new Vector();
                for(j=1;j<=i;j++){
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("dinlenme"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        popTop10 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jazzTop10 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        klasikTop10 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        genelTop10 = new javax.swing.JTable();
        geriDönButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pop Top 10");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Jazz Top 10");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Klasik Top 10");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Genel Top 10");

        popTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şarkı ", "Sanatçı", "Dinlenme "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(popTop10);

        jazzTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şarkı ", "Sanatçı", "Dinlenme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jazzTop10);

        klasikTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şarkı", "Sanatçı", "Dinlenme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(klasikTop10);

        genelTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şarkı", "Sanatçı", "Dinlenme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(genelTop10);

        geriDönButon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        geriDönButon.setText("GERİ DÖN");
        geriDönButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriDönButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(305, 305, 305)
                .addComponent(jLabel3)
                .addGap(314, 314, 314)
                .addComponent(jLabel4)
                .addGap(142, 142, 142))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(331, 331, 331))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriDönButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriDönButonActionPerformed
        Proje3.KullanıcıPanel = new KullanıcıPanel();
        Proje3.KullanıcıPanel.setLocationRelativeTo(null);
        Proje3.KullanıcıPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_geriDönButonActionPerformed

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
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullanıcıTop10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullanıcıTop10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable genelTop10;
    private javax.swing.JButton geriDönButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jazzTop10;
    private javax.swing.JTable klasikTop10;
    private javax.swing.JTable popTop10;
    // End of variables declaration//GEN-END:variables
}
