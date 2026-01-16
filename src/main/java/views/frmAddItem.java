package views;

import javax.swing.*;
import java.util.*;

import models.Item;
import controllers.ItemController;
import controllers.CategoryController;
import java.awt.event.*;
import models.Category;

public class frmAddItem extends javax.swing.JFrame {
    ItemController ic = new ItemController();
    CategoryController cc = new CategoryController();
    
    public frmAddItem() {
        initComponents();setExtendedState(JFrame.MAXIMIZED_BOTH);
        titleBar.init(this);
        
        cmbCat.addItem("Choose One");
        
        ArrayList<Category> category = cc.getCategory();
        
        for(Category x: category)
        {
            cmbCat.addItem(x.getCatName());
        }      
        
        txtID.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //tampilkanInfoMember(fieldInputID.getText());
                    txtID.requestFocusInWindow();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new customUI.SimpleTitleBar();
        pnlMain = new javax.swing.JPanel();
        btnBack = new customUI.Buttont();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new customUI.PanelRound();
        txtName = new customUI.TextField();
        txtPrice = new customUI.TextField();
        txtID = new customUI.TextField();
        cmbCat = new customUI.ComboBoxUI();
        button1 = new customUI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 26, 35));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        titleBar.setBackground(new java.awt.Color(25, 26, 35));

        pnlMain.setBackground(new java.awt.Color(25, 26, 35));

        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Arrow back ios.png"))); // NOI18N
        btnBack.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setPreferredSize(new java.awt.Dimension(58, 68));
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Item");

        panelRound1.setBackground(new java.awt.Color(34, 36, 48));
        panelRound1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        txtName.setBackground(new java.awt.Color(34, 36, 48));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        txtName.setLabelText("Item Name");

        txtPrice.setBackground(new java.awt.Color(34, 36, 48));
        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        txtPrice.setLabelText("Price");
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtID.setBackground(new java.awt.Color(34, 36, 48));
        txtID.setForeground(new java.awt.Color(255, 255, 255));
        txtID.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        txtID.setLabelText("Item ID");

        cmbCat.setBackground(new java.awt.Color(34, 36, 48));
        cmbCat.setForeground(new java.awt.Color(255, 255, 255));
        cmbCat.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        cmbCat.setLabeText("Category");

        button1.setBackground(new java.awt.Color(25, 26, 35));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Add Item");
        button1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 24)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new frmItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        
    }//GEN-LAST:event_txtPriceActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (txtName.getText().equals("") || txtID.getText().equals("") || txtPrice.getText().equals("") || cmbCat.getSelectedItem().equals("")) {
            MessageError me = new MessageError(this, true);
            me.jLabel1.setIcon(new ImageIcon(getClass().getResource("/assets/error.png")));
            me.jLabel2.setText("Gagal");
            me.jLabel3.setText("Mohon Isi Semuanya, Jangan Ada yang Kosong!");
            me.showAlert();
        } else {
            ArrayList<Category> category = cc.getCategory();
            String catCode = "";
        
            for(Category x: category)
            {
                if (x.getCatName().equals(cmbCat.getSelectedItem()))
                {
                    catCode = x.getCatID();
                }
            }  
        
            Item item = new Item(txtID.getText(), catCode, txtName.getText(), Integer.valueOf(txtPrice.getText()));    
            if (ic.addItem(item))
            {
                MessageSuccess me = new MessageSuccess(this,true);
                me.jLabel2.setText("Sukses");
                me.jLabel3.setText("Berhasil Menambahkan Barang ["+ txtID.getText() +" - "+ txtName.getText() +"]  !");
                me.showAlert();
            } else {
                MessageError me = new MessageError(this, true);
                me.jLabel2.setText("Gagal");
                me.jLabel3.setText("Silahkan Hubungi Developer!");
                me.showAlert();
            }
        }
    }//GEN-LAST:event_button1ActionPerformed


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
            java.util.logging.Logger.getLogger(frmAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customUI.Buttont btnBack;
    private customUI.Button button1;
    private customUI.ComboBoxUI cmbCat;
    private javax.swing.JLabel jLabel1;
    private customUI.PanelRound panelRound1;
    private javax.swing.JPanel pnlMain;
    private customUI.SimpleTitleBar titleBar;
    private customUI.TextField txtID;
    private customUI.TextField txtName;
    private customUI.TextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
