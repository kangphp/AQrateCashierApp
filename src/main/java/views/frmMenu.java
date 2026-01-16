package views;

import controllers.TransactionController;
import customUI.PieChart;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import models.ModelPieChart;

public class frmMenu extends javax.swing.JFrame {
        Timer updateTimer;
        int DELAY = 100;
        TransactionController tc = new TransactionController();

        public frmMenu() {
                initComponents();

                custTitleBar.init(this);
                setExtendedState(JFrame.MAXIMIZED_BOTH);

                // RBAC Implementation
                if (utils.ConstUtil.auth != null && "cashier".equalsIgnoreCase(utils.ConstUtil.auth.getRole())) {
                        btnItem.setEnabled(false);
                        btnCategory.setEnabled(false);
                        btnSales.setEnabled(false); // Assuming Sales Report is Admin only

                        // Optional: Visually indicate disabled state if LookAndFeel doesn't make it
                        // obvious
                        btnItem.setVisible(false);
                        btnCategory.setVisible(false);
                        btnSales.setVisible(false);
                }

                updateTimer = new Timer(DELAY, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Date currentTime = new Date();
                                String formatTimeStr = "HH:mm:ss";
                                DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
                                String formattedTimeStr = formatTime.format(currentTime);

                                lblTime.setText(formattedTimeStr);

                                // Periodic check (every 10 seconds approx to avoid heavy load, logic can be
                                // improved)
                                if (System.currentTimeMillis() % 10000 < DELAY * 2) {
                                        checkLowStock();
                                }
                        }
                });

                updateTimer.start();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                custTitleBar = new customUI.SimpleTitleBar();
                pnlName = new javax.swing.JPanel();
                lblTime = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                pnlBody = new javax.swing.JPanel();
                pnlMenu = new customUI.PanelRound();
                btnItem = new customUI.Buttont();
                btnSales = new customUI.Buttont();
                btnCategory = new customUI.Buttont();
                btnAddTrans = new customUI.Buttont();
                btnAddTrans = new customUI.Buttont();
                btnStock = new customUI.Buttont();
                btnDashboard = new customUI.Buttont();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(25, 182, 214));
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setUndecorated(true);
                setResizable(false);

                custTitleBar.setBackground(new java.awt.Color(25, 26, 35));

                pnlName.setBackground(new java.awt.Color(25, 26, 35));

                // Add Dashboard Button Logic Here (Added via Layout manually below)

                lblTime.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 24)); // NOI18N
                lblTime.setForeground(new java.awt.Color(255, 255, 255));
                lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblTime.setText("jLabel3");

                jLabel1.setBackground(new java.awt.Color(25, 26, 35));
                jLabel1.setFont(new java.awt.Font("StonerDemo", 1, 48)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("AQyurate Cashier");

                javax.swing.GroupLayout pnlNameLayout = new javax.swing.GroupLayout(pnlName);
                pnlName.setLayout(pnlNameLayout);
                pnlNameLayout.setHorizontalGroup(
                                pnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlNameLayout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                539,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lblTime,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                143,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                pnlNameLayout.setVerticalGroup(
                                pnlNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlNameLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(pnlNameLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lblTime,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                54,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pnlBody.setBackground(new java.awt.Color(25, 26, 35));

                pnlMenu.setBackground(new java.awt.Color(34, 36, 48));
                pnlMenu.setForeground(new java.awt.Color(255, 255, 255));
                pnlMenu.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                pnlMenu.setRoundBottomLeft(80);
                pnlMenu.setRoundBottomRight(80);
                pnlMenu.setRoundTopLeft(80);
                pnlMenu.setRoundTopRight(80);

                btnItem.setBackground(new java.awt.Color(92, 92, 92));
                btnItem.setBorder(null);
                btnItem.setForeground(new java.awt.Color(255, 255, 255));
                btnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tools-line.png"))); // NOI18N
                btnItem.setMnemonic('F');
                btnItem.setText("Item");
                btnItem.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnItemActionPerformed(evt);
                        }
                });

                btnSales.setForeground(new java.awt.Color(255, 255, 255));
                btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-fast-cart-48.png"))); // NOI18N
                btnSales.setText("Sale");
                btnSales.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnSales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnSales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnSales.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSalesActionPerformed(evt);
                        }
                });

                btnCategory.setForeground(new java.awt.Color(255, 255, 255));
                btnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-sorting-48.png"))); // NOI18N
                btnCategory.setText("Category");
                btnCategory.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnCategory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnCategory.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCategoryActionPerformed(evt);
                        }
                });

                btnAddTrans.setForeground(new java.awt.Color(255, 255, 255));
                btnAddTrans
                                .setIcon(new javax.swing.ImageIcon(
                                                getClass().getResource("/assets/icons8-add-shopping-cart-48.png"))); // NOI18N
                btnAddTrans.setText("New Transaction");
                btnAddTrans.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnAddTrans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnAddTrans.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnAddTrans.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAddTransActionPerformed(evt);
                        }
                });

                btnStock.setForeground(new java.awt.Color(255, 255, 255));
                btnStock.setIcon(new javax.swing.ImageIcon(
                                getClass().getResource("/assets/icons8-warehouse-48(1).png"))); // NOI18N
                btnStock.setText("Stock");
                btnStock.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnStock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnStock.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnStockActionPerformed(evt);
                        }
                });

                btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
                btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-speed-48.png"))); // NOI18N
                btnDashboard.setText("Dashboard");
                btnDashboard.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
                btnDashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                btnDashboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                btnDashboard.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDashboardActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
                pnlMenu.setLayout(pnlMenuLayout);
                pnlMenuLayout.setHorizontalGroup(
                                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlMenuLayout.createSequentialGroup()
                                                                .addContainerGap(214, Short.MAX_VALUE)
                                                                .addComponent(btnItem,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                18,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnStock,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                18,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(btnSales,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addComponent(btnCategory,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addComponent(btnAddTrans,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addComponent(btnDashboard,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                128,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(215, Short.MAX_VALUE)));
                pnlMenuLayout.setVerticalGroup(
                                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlMenuLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(pnlMenuLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(pnlMenuLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(btnSales,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                128,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(btnCategory,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                128,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnAddTrans,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                128,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(pnlMenuLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addComponent(btnStock,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnItem,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                128,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(btnDashboard,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                128,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout pnlBodyLayout = new javax.swing.GroupLayout(pnlBody);
                pnlBody.setLayout(pnlBodyLayout);
                pnlBodyLayout.setHorizontalGroup(
                                pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBodyLayout
                                                                .createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pnlMenu,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)));
                pnlBodyLayout.setVerticalGroup(
                                pnlBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlBodyLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(pnlMenu,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(283, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(custTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pnlName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(custTitleBar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(pnlName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(pnlBody,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnItemActionPerformed
                new frmItem().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnItemActionPerformed

        private void btnAddTransActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddTransActionPerformed
                new frmAddTransaction().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnAddTransActionPerformed

        private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {
                String[] options = { "Manage Stock", "Stock Log", "Suppliers" };
                int choice = JOptionPane.showOptionDialog(this, "Select Option", "Inventory Management",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (choice == 0) {
                        new frmStock().setVisible(true);
                } else if (choice == 1) {
                        new frmStockLog().setVisible(true);
                } else if (choice == 2) {
                        new frmSupplier().setVisible(true);
                }
        }

        private void checkLowStock() {
                controllers.StockController sc = new controllers.StockController();
                ArrayList<models.Item> lowItems = sc.getLowStockItems();
                if (!lowItems.isEmpty()) {
                        lblTime.setForeground(Color.RED);
                        lblTime.setText("LOW STOCK: " + lowItems.size());
                } else {
                        lblTime.setForeground(Color.WHITE);
                }
        }

        private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCategoryActionPerformed
                new frmCategory().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnCategoryActionPerformed

        private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalesActionPerformed
                new frmSales().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_btnSalesActionPerformed

        private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {
                new frmDashboard().setVisible(true);
                this.dispose();
        }

        public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new frmMenu().setVisible(true);
                                // new frmMenu().setExtendedState();
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private customUI.Buttont btnAddTrans;
        private customUI.Buttont btnCategory;
        private customUI.Buttont btnItem;
        private customUI.Buttont btnSales;
        private customUI.Buttont btnStock;
        private customUI.Buttont btnDashboard;
        private customUI.SimpleTitleBar custTitleBar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel lblTime;
        private javax.swing.JPanel pnlBody;
        private customUI.PanelRound pnlMenu;
        private javax.swing.JPanel pnlName;
        // End of variables declaration//GEN-END:variables
}
