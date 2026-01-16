package views;

import controllers.SupplierController;
import customUI.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Supplier;

public class frmSupplier extends javax.swing.JFrame {
    private SupplierController sc = new SupplierController();

    public frmSupplier() {
        initComponents();
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tblSuppliers.getModel();
        model.setRowCount(0);
        ArrayList<Supplier> list = sc.getAll();
        for (Supplier s : list) {
            model.addRow(new Object[] { s.getCodeSup(), s.getName(), s.getPhone(), s.getAddress() });
        }
    }

    private void clearFields() {
        txtCode.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlRoot = new PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSuppliers = new TableDark();
        txtCode = new TextField();
        txtName = new TextField();
        txtPhone = new TextField();
        txtAddress = new TextField();
        btnAdd = new Button();
        btnEdit = new Button();
        btnDelete = new Button();
        btnBack = new Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlRoot.setBackground(new java.awt.Color(34, 36, 48));

        tblSuppliers.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Code", "Name", "Phone", "Address" }));
        tblSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblSuppliers.getSelectedRow();
                txtCode.setText(tblSuppliers.getValueAt(row, 0).toString());
                txtName.setText(tblSuppliers.getValueAt(row, 1).toString());
                txtPhone.setText(tblSuppliers.getValueAt(row, 2).toString());
                txtAddress.setText(tblSuppliers.getValueAt(row, 3).toString());
            }
        });
        jScrollPane1.setViewportView(tblSuppliers);

        txtCode.setLabelText("Code Supplier");
        txtName.setLabelText("Name");
        txtPhone.setLabelText("Phone");
        txtAddress.setLabelText("Address");

        btnAdd.setText("Add");
        btnAdd.addActionListener(evt -> {
            sc.add(new Supplier(txtCode.getText(), txtName.getText(), txtPhone.getText(), txtAddress.getText()));
            loadTable();
            clearFields();
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(evt -> {
            sc.update(new Supplier(txtCode.getText(), txtName.getText(), txtPhone.getText(), txtAddress.getText()));
            loadTable();
            clearFields();
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(evt -> {
            sc.delete(txtCode.getText());
            loadTable();
            clearFields();
        });

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> {
            new frmMenu().setVisible(true);
            dispose();
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier Management");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                300, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAdd,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnEdit,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnDelete,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 500,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnBack,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
    private TableDark tblSuppliers;
    private TextField txtCode;
    private TextField txtName;
    private TextField txtPhone;
    private TextField txtAddress;
    private Button btnAdd;
    private Button btnEdit;
    private Button btnDelete;
    private Button btnBack;
    private javax.swing.JLabel jLabel1;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmSupplier().setVisible(true));
    }
}
