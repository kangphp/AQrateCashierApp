package views;

import controllers.StockController;
import customUI.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.StockLog;

public class frmStockLog extends javax.swing.JFrame {
    private StockController sc = new StockController();

    public frmStockLog() {
        initComponents();
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tblLogs.getModel();
        model.setRowCount(0);
        ArrayList<StockLog> list = sc.getStockLogs();
        for (StockLog log : list) {
            model.addRow(new Object[] {
                    log.getCreatedAt(),
                    log.getItemId(),
                    log.getType(),
                    log.getQuantity(),
                    log.getBalanceAfter(),
                    log.getDescription()
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlRoot = new PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogs = new TableDark();
        btnBack = new Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlRoot.setBackground(new java.awt.Color(34, 36, 48));

        tblLogs.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Date", "Item ID", "Type", "Qty", "Result Balance", "Description" }));
        jScrollPane1.setViewportView(tblLogs);

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> {
            new frmMenu().setVisible(true);
            dispose();
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock Mutation Log");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE)));

        javax.swing.GroupLayout rootLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(rootLayout);
        rootLayout.setHorizontalGroup(
                rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        rootLayout.setVerticalGroup(
                rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    private PanelRound pnlRoot;
    private javax.swing.JScrollPane jScrollPane1;
    private TableDark tblLogs;
    private Button btnBack;
    private javax.swing.JLabel jLabel1;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmStockLog().setVisible(true));
    }
}
