package views;
import controllers.UserController;
import javax.swing.JFrame;
import models.User;
import utils.ConstUtil;
import javax.swing.JOptionPane;

public class frmLogin extends javax.swing.JFrame {
    
    public frmLogin() {
        initComponents();
        titleBar.init(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conForm = new javax.swing.JPanel();
        pnlForm = new customUI.PanelRound();
        txtUsername = new customUI.TextField();
        txtPassword = new customUI.PasswordField();
        btnLogin = new customUI.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleBar = new customUI.SimpleTitleBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 26, 35));
        setUndecorated(true);

        conForm.setBackground(new java.awt.Color(25, 26, 35));

        pnlForm.setBackground(new java.awt.Color(34, 36, 48));
        pnlForm.setRoundBottomLeft(20);
        pnlForm.setRoundBottomRight(20);
        pnlForm.setRoundTopLeft(20);
        pnlForm.setRoundTopRight(20);

        txtUsername.setBackground(new java.awt.Color(34, 36, 48));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setLabelText("Username");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(34, 36, 48));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setLabelText("Password");
        txtPassword.setShowAndHide(true);

        btnLogin.setBackground(new java.awt.Color(30, 30, 30));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.setFont(new java.awt.Font("Gilroy-SemiBold", 0, 24)); // NOI18N
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("StonerDemo", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AQyurate Cashier");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Plus Jakarta Sans SemiBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log In");

        titleBar.setBackground(new java.awt.Color(25, 26, 35));

        javax.swing.GroupLayout conFormLayout = new javax.swing.GroupLayout(conForm);
        conForm.setLayout(conFormLayout);
        conFormLayout.setHorizontalGroup(
            conFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(pnlForm, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        conFormLayout.setVerticalGroup(
            conFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conFormLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(conFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conFormLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))
                    .addGroup(conFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(conForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        User user = uc.getLogin(txtUsername.getText(), txtPassword.getText());
        if(user != null){
            ConstUtil.auth = user;
            new frmMenu().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Mohon masukkan Username/Password yang benar!", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        
    }//GEN-LAST:event_txtUsernameActionPerformed
    
    UserController uc = new UserController();
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customUI.Button btnLogin;
    private javax.swing.JPanel conForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private customUI.PanelRound pnlForm;
    private customUI.SimpleTitleBar titleBar;
    private customUI.PasswordField txtPassword;
    private customUI.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
