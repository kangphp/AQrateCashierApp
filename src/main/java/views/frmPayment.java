package views;

import controllers.TransactionController;
import customUI.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import models.Sale;
import models.Transaction;
import java.util.ArrayList;

public class frmPayment extends javax.swing.JDialog {
    private int subtotal;
    private ArrayList<Transaction> items;
    private frmAddTransaction parent;
    private TransactionController tc = new TransactionController();

    public frmPayment(java.awt.Frame parent, boolean modal, int subtotal, ArrayList<Transaction> items) {
        super(parent, modal);
        this.parent = (frmAddTransaction) parent;
        this.subtotal = subtotal;
        this.items = items;
        initComponents();
        initValues();
        calculateTotal();
    }

    private void initValues() {
        txtSubtotal.setText(String.valueOf(subtotal));
        txtTax.setText("11"); // Default 11% PPN
        txtDiscount.setText("0");
        cmbPayment.addItem("CASH");
        cmbPayment.addItem("QRIS");
        cmbPayment.addItem("TRANSFER");
    }

    private void calculateTotal() {
        try {
            double taxPercent = Double.parseDouble(txtTax.getText());
            double discount = Double.parseDouble(txtDiscount.getText());

            double taxAmount = (subtotal - discount) * (taxPercent / 100);
            double grandTotal = (subtotal - discount) + taxAmount;

            lblTotal.setText(String.format("%.0f", grandTotal));
        } catch (NumberFormatException e) {
            lblTotal.setText("0");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlRoot = new PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSubtotal = new TextField();
        txtTax = new TextField();
        txtDiscount = new TextField();
        cmbPayment = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtMoney = new TextField();
        btnPay = new Button();
        btnCancel = new Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlRoot.setBackground(new java.awt.Color(34, 36, 48));
        pnlRoot.setRoundBottomLeft(20);
        pnlRoot.setRoundBottomRight(20);
        pnlRoot.setRoundTopLeft(20);
        pnlRoot.setRoundTopRight(20);

        jLabel1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payment");

        txtSubtotal.setLabelText("Subtotal");
        txtSubtotal.setEditable(false);

        txtTax.setLabelText("Tax (%)");
        txtTax.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                calculateTotal();
            }
        });

        txtDiscount.setLabelText("Discount (Rp)");
        txtDiscount.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                calculateTotal();
            }
        });

        cmbPayment.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 14));
        cmbPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!cmbPayment.getSelectedItem().toString().equals("CASH")) {
                    txtMoney.setText(lblTotal.getText());
                    txtMoney.setEditable(false);
                } else {
                    txtMoney.setText("");
                    txtMoney.setEditable(true);
                }
            }
        });

        jLabel3.setFont(new java.awt.Font("Plus Jakarta Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 255, 127));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        txtMoney.setLabelText("Cash Given (Rp)");

        btnPay.setBackground(new java.awt.Color(25, 182, 214));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Confirm & Print");
        btnPay.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 14)); // NOI18N
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processPayment();
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 14)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 340,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(cmbPayment, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtMoney, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cmbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(lblTotal))
                                .addGap(18, 18, 18)
                                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE)));

        javax.swing.GroupLayout dialogLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(dialogLayout);
        dialogLayout.setHorizontalGroup(
                dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        dialogLayout.setVerticalGroup(
                dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(parent);
    }

    private void processPayment() {
        try {
            double grandTotal = Double.parseDouble(lblTotal.getText());
            double moneyGiven = 0;
            if (!txtMoney.getText().isEmpty()) {
                moneyGiven = Double.parseDouble(txtMoney.getText());
            }

            if (moneyGiven < grandTotal) {
                JOptionPane.showMessageDialog(this, "Money given is less than total!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create Sale Object
            Sale sale = new Sale(
                    null, // will be generated
                    (int) grandTotal,
                    (int) moneyGiven,
                    Double.parseDouble(txtTax.getText()),
                    Double.parseDouble(txtDiscount.getText()),
                    cmbPayment.getSelectedItem().toString());

            // Save
            if (tc.saveTransaction(sale, items)) {
                JOptionPane.showMessageDialog(this, "Transaction Successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                // Print logic here via PrintService
                // new services.PrintService().printReceipt(sale.getIdTrx());

                parent.resetTransaction(); // Method to clear cart in parent
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Transaction Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private PanelRound pnlRoot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTotal;
    private TextField txtSubtotal;
    private TextField txtTax;
    private TextField txtDiscount;
    private TextField txtMoney;
    private javax.swing.JComboBox<String> cmbPayment;
    private Button btnPay;
    private Button btnCancel;
}
