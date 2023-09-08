/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Vector;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alperen
 */
public class Profil extends javax.swing.JFrame {

    /**
     * Creates new form Profil
     */
    public Profil() {
        initComponents();
        güncelle();
        güncelle1();
        güncelle2();
        yazdır();
        if (Proje3.profilID == Proje3.girilenKullanıcıID) {
            ekleButon.setVisible(false);
            popekleButon.setVisible(false);
            jazzekleButon.setVisible(false);
            klasikekleButon.setVisible(false);
            takipetButon.setVisible(false);
            

        } else {

            if (txtf_abonelik.getText().equals("Normal")) {
                takipetButon.setVisible(false);
            }
            silButon.setVisible(false);
            ekleButon.setVisible(false);
            
            popekleButon.setVisible(false);
            jazzekleButon.setVisible(false);
            klasikekleButon.setVisible(false);
            
            popTablo.setVisible(false);
            jazzTablo.setVisible(false);
            klasikTablo.setVisible(false);

            String takipSorgu = "SELECT takipeden_id,takipedilen_id FROM takip WHERE takipeden_id= \'" + Proje3.girilenKullanıcıID + "\' and takipedilen_id= \'" + Proje3.profilID + "\'";
            try {
                Veritabanı.stmt = Veritabanı.con.createStatement();
                Veritabanı.rs = Veritabanı.stmt.executeQuery(takipSorgu);
                while (Veritabanı.rs.next()) {
                    if (Proje3.girilenKullanıcıID == Veritabanı.rs.getInt("takipeden_id") && Proje3.profilID == Veritabanı.rs.getInt("takipedilen_id")) {
                        takipetButon.setVisible(false);
                        popTablo.setVisible(true);
                        jazzTablo.setVisible(true);
                        klasikTablo.setVisible(true);
                        ekleButon.setVisible(true);
                        popekleButon.setVisible(true);
                        jazzekleButon.setVisible(true);
                        klasikekleButon.setVisible(true);
                        popekleButon.setVisible(true);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void yazdır() {
        try {
            String bilgial = "SELECT kullanici_id,kullanici_ad,email,abonelik,kullanici_ulke FROM kullanicilar WHERE kullanici_id = \'" + Proje3.profilID + "\'";

            Veritabanı.stmt = Veritabanı.con.createStatement();
            Veritabanı.rs = Veritabanı.stmt.executeQuery(bilgial);

            while (Veritabanı.rs.next()) {
                txtf_ad.setText(Veritabanı.rs.getString("kullanici_ad"));
                txtf_email.setText(Veritabanı.rs.getString("email"));
                txtf_abonelik.setText(Veritabanı.rs.getString("abonelik"));
                txtf_ülke.setText(Veritabanı.rs.getString("kullanici_ulke"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void güncelle() {

        int i, j;
        try {
            Veritabanı.pstmt = Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_id,sarkilar.sarki_ad,sanatcilar.sanatci_ad,albumler.album_ad,sarkilar.sarki_tarih,sarkilar.sure,kullanicilar.kullanici_id FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id)  JOIN sanatcilar_albumler ON (sanatcilar.sanatci_id=sanatcilar_albumler.sanatci_id) JOIN albumler ON (sanatcilar_albumler.album_id=albumler.album_id) JOIN sarkilar_kullanicilar ON (sarkilar.sarki_id = sarkilar_kullanicilar.sarki_id) JOIN kullanicilar ON (sarkilar_kullanicilar.kullanici_id=kullanicilar.kullanici_id) WHERE (sarkilar.album_id=albumler.album_id) and (sarkilar.sarki_tur= 'Pop') and (kullanicilar.kullanici_id= \'" + Proje3.profilID + "\')");
            Veritabanı.rs = Veritabanı.pstmt.executeQuery();
            ResultSetMetaData ŞarkıData = Veritabanı.rs.getMetaData();
            i = ŞarkıData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) popTablo.getModel();
            RecordTable.setRowCount(0);
            while (Veritabanı.rs.next()) {
                Vector columnData = new Vector();
                for (j = 1; j <= i; j++) {
                    columnData.add(Veritabanı.rs.getString("sarki_id"));
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("album_ad"));
                    columnData.add(Veritabanı.rs.getString("sarki_tarih"));
                    columnData.add(Veritabanı.rs.getString("sure"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void güncelle1() {

        int i, j;
        try {
            Veritabanı.pstmt = Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_id,sarkilar.sarki_ad,sanatcilar.sanatci_ad,albumler.album_ad,sarkilar.sarki_tarih,sarkilar.sure,kullanicilar.kullanici_id FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id)  JOIN sanatcilar_albumler ON (sanatcilar.sanatci_id=sanatcilar_albumler.sanatci_id) JOIN albumler ON (sanatcilar_albumler.album_id=albumler.album_id) JOIN sarkilar_kullanicilar ON (sarkilar.sarki_id = sarkilar_kullanicilar.sarki_id) JOIN kullanicilar ON (sarkilar_kullanicilar.kullanici_id=kullanicilar.kullanici_id) WHERE (sarkilar.album_id=albumler.album_id) and (sarkilar.sarki_tur= 'Jazz') and (kullanicilar.kullanici_id= \'" + Proje3.profilID + "\')");
            Veritabanı.rs = Veritabanı.pstmt.executeQuery();
            ResultSetMetaData ŞarkıData = Veritabanı.rs.getMetaData();
            i = ŞarkıData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jazzTablo.getModel();
            RecordTable.setRowCount(0);
            while (Veritabanı.rs.next()) {
                Vector columnData = new Vector();
                for (j = 1; j <= i; j++) {
                    columnData.add(Veritabanı.rs.getString("sarki_id"));
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("album_ad"));
                    columnData.add(Veritabanı.rs.getString("sarki_tarih"));
                    columnData.add(Veritabanı.rs.getString("sure"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void güncelle2() {

        int i, j;
        try {
            Veritabanı.pstmt = Veritabanı.con.prepareStatement("SELECT sarkilar.sarki_id,sarkilar.sarki_ad,sanatcilar.sanatci_ad,albumler.album_ad,sarkilar.sarki_tarih,sarkilar.sure,kullanicilar.kullanici_id FROM sarkilar JOIN sarkilar_sanatcilar ON (sarkilar.sarki_id=sarkilar_sanatcilar.sarki_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sarkilar_sanatcilar.sanatci_id)  JOIN sanatcilar_albumler ON (sanatcilar.sanatci_id=sanatcilar_albumler.sanatci_id) JOIN albumler ON (sanatcilar_albumler.album_id=albumler.album_id) JOIN sarkilar_kullanicilar ON (sarkilar.sarki_id = sarkilar_kullanicilar.sarki_id) JOIN kullanicilar ON (sarkilar_kullanicilar.kullanici_id=kullanicilar.kullanici_id) WHERE (sarkilar.album_id=albumler.album_id) and (sarkilar.sarki_tur= 'Klasik') and (kullanicilar.kullanici_id= \'" + Proje3.profilID + "\')");
            Veritabanı.rs = Veritabanı.pstmt.executeQuery();
            ResultSetMetaData ŞarkıData = Veritabanı.rs.getMetaData();
            i = ŞarkıData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) klasikTablo.getModel();
            RecordTable.setRowCount(0);
            while (Veritabanı.rs.next()) {
                Vector columnData = new Vector();
                for (j = 1; j <= i; j++) {
                    columnData.add(Veritabanı.rs.getString("sarki_id"));
                    columnData.add(Veritabanı.rs.getString("sarki_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("album_ad"));
                    columnData.add(Veritabanı.rs.getString("sarki_tarih"));
                    columnData.add(Veritabanı.rs.getString("sure"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        popTablo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jazzTablo = new javax.swing.JTable();
        takipetButon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ekleButon = new javax.swing.JButton();
        popekleButon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        klasikTablo = new javax.swing.JTable();
        txtf_ad = new javax.swing.JTextField();
        txtf_email = new javax.swing.JTextField();
        txtf_abonelik = new javax.swing.JTextField();
        txtf_ülke = new javax.swing.JTextField();
        geriDönButon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        silButon = new javax.swing.JButton();
        jazzekleButon = new javax.swing.JButton();
        klasikekleButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        popTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Şarkı Adı", "Sanatçı", "Albüm", "Çıkış Tarihi", "Süre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        popTablo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        popTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popTabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(popTablo);

        jazzTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Şarkı Adı", "Sanatçı", "Albüm", "Tarih", "Süre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jazzTablo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jazzTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jazzTabloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jazzTablo);

        takipetButon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        takipetButon.setText("TAKİP ET");
        takipetButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takipetButonActionPerformed(evt);
            }
        });

        jLabel1.setText("Kullanıcı Adı");

        jLabel2.setText("E-mail");

        jLabel3.setText("Abonelik");

        jLabel4.setText("Ülke");

        ekleButon.setText("EKLE");
        ekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButonActionPerformed(evt);
            }
        });

        popekleButon.setText("TÜMÜNÜ EKLE");
        popekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popekleButonActionPerformed(evt);
            }
        });

        klasikTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Şarkı Adı", "Sanatçı", "Albüm", "Tarih", "Süre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        klasikTablo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        klasikTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                klasikTabloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(klasikTablo);

        txtf_ad.setEditable(false);

        txtf_email.setEditable(false);

        txtf_abonelik.setEditable(false);

        txtf_ülke.setEditable(false);

        geriDönButon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        geriDönButon.setText("GERİ DÖN");
        geriDönButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriDönButonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("POP ÇALMA LİSTESİ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("JAZZ ÇALMA LİSTESİ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("KLASİK ÇALMA LİSTESİ");

        silButon.setText("SİL");
        silButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButonActionPerformed(evt);
            }
        });

        jazzekleButon.setText("TÜMÜNÜ EKLE");
        jazzekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jazzekleButonActionPerformed(evt);
            }
        });

        klasikekleButon.setText("TÜMÜNÜ EKLE");
        klasikekleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klasikekleButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel5)
                .addGap(230, 230, 230)
                .addComponent(jLabel6)
                .addGap(205, 205, 205)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(takipetButon)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtf_abonelik, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtf_ülke, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(silButon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ekleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(popekleButon)
                        .addGap(253, 253, 253)
                        .addComponent(jazzekleButon)
                        .addGap(286, 286, 286)
                        .addComponent(klasikekleButon)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(takipetButon)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtf_abonelik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtf_ülke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(ekleButon)
                        .addGap(28, 28, 28)
                        .addComponent(silButon)
                        .addGap(70, 70, 70)
                        .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(popekleButon)
                    .addComponent(jazzekleButon)
                    .addComponent(klasikekleButon))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriDönButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriDönButonActionPerformed
        Proje3.Kullanıcılar = new Kullanıcılar();
        Proje3.Kullanıcılar.setLocationRelativeTo(null);
        Proje3.Kullanıcılar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_geriDönButonActionPerformed

    private void silButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButonActionPerformed

        int id = Integer.parseInt(Proje3.seçilentablo.getValueAt(Proje3.seçilen, 0).toString());
        int veriyiSil = JOptionPane.showConfirmDialog(null, "Silmek istediğinizden emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);
        if (veriyiSil == JOptionPane.YES_OPTION) {
            try {
                Veritabanı.pstmt = Veritabanı.con.prepareStatement("DELETE FROM sarkilar_kullanicilar WHERE sarki_id=? and kullanici_id= \'" + Proje3.profilID + "\'");
                Veritabanı.pstmt.setInt(1, id);
                Veritabanı.pstmt.executeUpdate();
                güncelle();
                güncelle1();
                güncelle2();
            } catch (SQLException ex) {
                Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_silButonActionPerformed
    }
    private void popTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popTabloMouseClicked
        Proje3.seçilentablo = (DefaultTableModel) popTablo.getModel();
        Proje3.seçilen = popTablo.getSelectedRow();
    }//GEN-LAST:event_popTabloMouseClicked

    private void jazzTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jazzTabloMouseClicked
        Proje3.seçilentablo = (DefaultTableModel) jazzTablo.getModel();
        Proje3.seçilen = jazzTablo.getSelectedRow();
    }//GEN-LAST:event_jazzTabloMouseClicked

    private void klasikTabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_klasikTabloMouseClicked
        Proje3.seçilentablo = (DefaultTableModel) klasikTablo.getModel();
        Proje3.seçilen = klasikTablo.getSelectedRow();
    }//GEN-LAST:event_klasikTabloMouseClicked

    private void ekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButonActionPerformed
        
        try {
            Veritabanı.pstmt = Veritabanı.con.prepareStatement("INSERT INTO sarkilar_kullanicilar(sarki_id,kullanici_id) values (?,?)");
            Veritabanı.pstmt.setString(1,Proje3.seçilentablo.getValueAt(Proje3.seçilen, 0).toString());
            Veritabanı.pstmt.setInt(2,Proje3.girilenKullanıcıID);
            Veritabanı.pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ekleButonActionPerformed

    private void popekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popekleButonActionPerformed
        
        String popekle = "SELECT sarkilar_kullanicilar.sarki_id,sarkilar_kullanicilar.kullanici_id FROM sarkilar_kullanicilar JOIN sarkilar ON (sarkilar.sarki_id=sarkilar_kullanicilar.sarki_id) WHERE kullanici_id= \'"+Proje3.profilID+"\' and sarki_tur = 'Pop' and sarkilar_kullanicilar.sarki_id NOT IN (SELECT sarkilar_kullanicilar.sarki_id FROM sarkilar_kullanicilar WHERE sarkilar_kullanicilar.kullanici_id= \'"+Proje3.girilenKullanıcıID+"\')";

        try {

            Veritabanı.stmt = Veritabanı.con.createStatement();
            Veritabanı.rs = Veritabanı.stmt.executeQuery(popekle);
            

            while(Veritabanı.rs.next()){

                Veritabanı.pstmt = Veritabanı.con.prepareStatement("INSERT INTO sarkilar_kullanicilar(sarki_id,kullanici_id) VALUES(?,?)");
                Veritabanı.pstmt.setInt(1, Veritabanı.rs.getInt("sarki_id"));
                Veritabanı.pstmt.setInt(2, Proje3.girilenKullanıcıID);
                Veritabanı.pstmt.executeUpdate();


            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
            
    }//GEN-LAST:event_popekleButonActionPerformed

    private void takipetButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takipetButonActionPerformed

        ekleButon.setVisible(true);
        popekleButon.setVisible(true);
        jazzekleButon.setVisible(true);
        klasikekleButon.setVisible(true);
        popTablo.setVisible(true);
        jazzTablo.setVisible(true);
        klasikTablo.setVisible(true);
        takipetButon.setVisible(false);
        try {
            Veritabanı.pstmt = Veritabanı.con.prepareStatement("INSERT INTO takip(takipeden_id,takipedilen_id) values (?,?)");
            Veritabanı.pstmt.setInt(1, Proje3.girilenKullanıcıID);
            Veritabanı.pstmt.setInt(2, Proje3.profilID);
            Veritabanı.pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_takipetButonActionPerformed

    private void jazzekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jazzekleButonActionPerformed
        String jazzekle ="SELECT sarkilar_kullanicilar.sarki_id,sarkilar_kullanicilar.kullanici_id FROM sarkilar_kullanicilar JOIN sarkilar ON (sarkilar.sarki_id=sarkilar_kullanicilar.sarki_id) WHERE kullanici_id= \'"+Proje3.profilID+"\' and sarki_tur = 'Jazz' and sarkilar_kullanicilar.sarki_id NOT IN (SELECT sarkilar_kullanicilar.sarki_id FROM sarkilar_kullanicilar WHERE sarkilar_kullanicilar.kullanici_id= \'"+Proje3.girilenKullanıcıID+"\') ";
        try {
            Veritabanı.stmt= Veritabanı.con.createStatement();
            Veritabanı.rs = Veritabanı.stmt.executeQuery(jazzekle);
            while(Veritabanı.rs.next()){
                Veritabanı.pstmt= Veritabanı.con.prepareStatement("INSERT INTO sarkilar_kullanicilar(sarki_id,kullanici_id) values (?,?)");
                Veritabanı.pstmt.setInt(1, Veritabanı.rs.getInt("sarki_id"));
                Veritabanı.pstmt.setInt(2, Proje3.girilenKullanıcıID);
                Veritabanı.pstmt.executeUpdate();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jazzekleButonActionPerformed

    private void klasikekleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klasikekleButonActionPerformed
        String klasikekle ="SELECT sarkilar_kullanicilar.sarki_id,sarkilar_kullanicilar.kullanici_id FROM sarkilar_kullanicilar JOIN sarkilar ON (sarkilar.sarki_id=sarkilar_kullanicilar.sarki_id) WHERE kullanici_id= \'"+Proje3.profilID+"\' and sarki_tur = 'Klasik' and sarkilar_kullanicilar.sarki_id NOT IN (SELECT sarkilar_kullanicilar.sarki_id FROM sarkilar_kullanicilar WHERE sarkilar_kullanicilar.kullanici_id= \'"+Proje3.girilenKullanıcıID+"\')";
        try {
            Veritabanı.stmt= Veritabanı.con.createStatement();
            Veritabanı.rs = Veritabanı.stmt.executeQuery(klasikekle);
            while(Veritabanı.rs.next()){
                Veritabanı.pstmt= Veritabanı.con.prepareStatement("INSERT INTO sarkilar_kullanicilar(sarki_id,kullanici_id) values (?,?)");
                Veritabanı.pstmt.setInt(1, Veritabanı.rs.getInt("sarki_id"));
                Veritabanı.pstmt.setInt(2, Proje3.girilenKullanıcıID);
                Veritabanı.pstmt.executeUpdate();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_klasikekleButonActionPerformed

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
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleButon;
    private javax.swing.JButton geriDönButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jazzTablo;
    private javax.swing.JButton jazzekleButon;
    private javax.swing.JTable klasikTablo;
    private javax.swing.JButton klasikekleButon;
    private javax.swing.JTable popTablo;
    private javax.swing.JButton popekleButon;
    private javax.swing.JButton silButon;
    private javax.swing.JButton takipetButon;
    private javax.swing.JTextField txtf_abonelik;
    private javax.swing.JTextField txtf_ad;
    private javax.swing.JTextField txtf_email;
    private javax.swing.JTextField txtf_ülke;
    // End of variables declaration//GEN-END:variables
}
