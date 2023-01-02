/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crudmahasiswasederhana.views;

import crudmahasiswasederhana.controller.MahasiswaController;
import crudmahasiswasederhana.interfc.MahasiswaInterface;
import crudmahasiswasederhana.models.Mahasiswa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fauzi
 */
public class MahasiswaFrame extends javax.swing.JFrame {
    List<Mahasiswa> record=new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;

    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        nimValidasiLabel.setVisible(false);
        namaValidasiLabel.setVisible(false);
        alamatValidasiLabel.setVisible(false);
        mhsServis = new MahasiswaController();

        mahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=mahasiswaTable.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
    }
    
    void loadData(){
        try {
            record = mhsServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(Mahasiswa mhs:record){
            data[x][0]=mhs.getNim();
            data[x][1]=mhs.getNama();
            data[x][2]=mhs.getAlamat();
            x++;
        }
        String judul[]={"nim","nama","alamat"};
        mahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(mahasiswaTable);
    }

    void isiText(){
        Mahasiswa mhs=record.get(row);
        nimText.setText(mhs.getNim());
        namaText.setText(mhs.getNama());
        alamatText.setText(mhs.getAlamat());
    }

    void kosongkanText(){
        nimText.setText("");
        namaText.setText("");
        alamatText.setText("");
    }

    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    void validasiInput (Mahasiswa o) {
        if (nimText.getText().equals("")) {
            nimValidasiLabel.setText("NIM belum diisi");
            nimValidasiLabel.setVisible(true);
        } else if (!nimText.getText().matches("[0-9]*")) {
            nimValidasiLabel.setText("NIM harus berisi angka");
            nimValidasiLabel.setVisible(true);
        } else if (nimText.getText().length() < 5) {
            nimValidasiLabel.setText("NIM minimal berisi 5 angka");
            nimValidasiLabel.setVisible(true);
        } else if (nimText.getText().length() > 12) {
            nimValidasiLabel.setText("NIM maksimal berisi 12 angka");
            nimValidasiLabel.setVisible(true);
        } else {
            o.setNim(nimText.getText());
            nimValidasiLabel.setVisible(false);
        }
        
        if (namaText.getText().equals("")) {
            namaValidasiLabel.setText("Nama belum diisi");
            namaValidasiLabel.setVisible(true);
        } else {
            o.setNama (namaText.getText());
            namaValidasiLabel.setVisible(false);
        }
        
        if (alamatText.getText().equals("")) {
            alamatValidasiLabel.setText("Alamat belum diisi");
            alamatValidasiLabel.setVisible(true);
        } else {
            o.setAlamat(alamatText.getText());
            alamatValidasiLabel.setVisible(false);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        nimLabel = new javax.swing.JLabel();
        nimText = new javax.swing.JTextField();
        namaLabel = new javax.swing.JLabel();
        namaText = new javax.swing.JTextField();
        alamatLabel = new javax.swing.JLabel();
        alamatText = new javax.swing.JTextField();
        tambahBtn = new javax.swing.JButton();
        ubahBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mahasiswaTable = new javax.swing.JTable();
        nimValidasiLabel = new javax.swing.JLabel();
        namaValidasiLabel = new javax.swing.JLabel();
        alamatValidasiLabel = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nimLabel.setText("Nim");

        nimText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextActionPerformed(evt);
            }
        });

        namaLabel.setText("Nama");

        alamatLabel.setText("Alamat");

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        ubahBtn.setText("Ubah");
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });

        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        mahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mahasiswaTable.setAutoscrolls(false);
        jScrollPane1.setViewportView(mahasiswaTable);

        nimValidasiLabel.setForeground(new java.awt.Color(255, 51, 51));
        nimValidasiLabel.setText("jLabel1");

        namaValidasiLabel.setForeground(new java.awt.Color(255, 51, 51));
        namaValidasiLabel.setText("jLabel1");

        alamatValidasiLabel.setForeground(new java.awt.Color(255, 51, 51));
        alamatValidasiLabel.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(alamatLabel)
                            .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaValidasiLabel)
                                    .addComponent(alamatValidasiLabel))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ubahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hapusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nimValidasiLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nimText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nimLabel))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimValidasiLabel)
                    .addComponent(tambahBtn))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaValidasiLabel)
                    .addComponent(ubahBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamatLabel)
                    .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamatValidasiLabel)
                    .addComponent(hapusBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        try {
            // TODO add your handling code here:
            String nim = nimText.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
        try {
            // TODO add your handling code here:
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            //            mhs.setNim(nimText.getText());
            //            mhs.setNama(namaText.getText());
            //            mhs.setAlamat(alamatText.getText());
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ubahBtnActionPerformed

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        try {
            // TODO add your handling code here:
            Mahasiswa mhs = new Mahasiswa();
            validasiInput(mhs);
            //            mhs.setNim(nimText.getText());
            //            mhs.setNama(namaText.getText());
            //            mhs.setAlamat(alamatText.getText());
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void nimTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimTextActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JTextField alamatText;
    private javax.swing.JLabel alamatValidasiLabel;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mahasiswaTable;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField namaText;
    private javax.swing.JLabel namaValidasiLabel;
    private javax.swing.JLabel nimLabel;
    private javax.swing.JTextField nimText;
    private javax.swing.JLabel nimValidasiLabel;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}
