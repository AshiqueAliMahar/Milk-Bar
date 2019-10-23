/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milkbar.UI;

import java.awt.Image;
import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.xml.stream.events.Characters;
import milkbar.dao.UsersDAO;
import milkbar.model.User;
import org.apache.regexp.CharacterArrayCharacterIterator;

/**
 *
 * @author ali.ashique
 */
public class ProfileIF extends javax.swing.JInternalFrame {

    private final User user;
    public ProfileIF(User user) {
        initComponents();
        rootPane.setDefaultButton(btnSave);
        this.user=user;
        setData(user);
    }

    private void setData(User user){
        txtName.setText(user.getName());
        pwdPassword.setText(user.getPassword());
        pwdCnfrmPassword.setText(user.getPassword());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pwdCnfrmPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        tgBtnPassword = new javax.swing.JToggleButton();
        tgBtnCPassword = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("American Typewriter", 0, 18))); // NOI18N
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtName.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        pwdPassword.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        jLabel1.setText("Name*");
        jLabel1.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        jLabel2.setText("Password*");
        jLabel2.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        pwdCnfrmPassword.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        jLabel3.setText("Confirm Password*");
        jLabel3.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N

        btnSave.setText("Save Changes");
        btnSave.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tgBtnPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkbar/images/password.png"))); // NOI18N
        tgBtnPassword.setPreferredSize(new java.awt.Dimension(28, 28));
        tgBtnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgBtnPasswordActionPerformed(evt);
            }
        });

        tgBtnCPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkbar/images/password.png"))); // NOI18N
        tgBtnCPassword.setPreferredSize(new java.awt.Dimension(28, 28));
        tgBtnCPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgBtnCPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(613, 613, 613))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(pwdCnfrmPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tgBtnCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)))
                            .addGap(42, 42, 42))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(pwdPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tgBtnPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(34, 34, 34)))
                            .addGap(55, 55, 55))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtName)
                            .addGap(89, 89, 89)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgBtnPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwdCnfrmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgBtnCPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String pwd=String.valueOf(pwdPassword.getPassword()),cPwd=String.valueOf(pwdCnfrmPassword.getPassword());
        
        if(pwd.equals(cPwd)){
            user.setPassword(pwd);
            user.setName(txtName.getText());
            UsersDAO.update(user);
            SwingUtilities.getWindowAncestor(this).dispose();
            new Login().setVisible(true);
        }else
            JOptionPane.showMessageDialog(rootPane, "Password Mismatch Error");
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tgBtnPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgBtnPasswordActionPerformed
        if(tgBtnPassword.isSelected())
            pwdPassword.setEchoChar((char)0);
        else
            pwdPassword.setEchoChar('*');
    }//GEN-LAST:event_tgBtnPasswordActionPerformed

    private void tgBtnCPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgBtnCPasswordActionPerformed
        if(tgBtnCPassword.isSelected())
            pwdCnfrmPassword.setEchoChar((char)0);
        else
            pwdCnfrmPassword.setEchoChar('*');
    }//GEN-LAST:event_tgBtnCPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwdCnfrmPassword;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JToggleButton tgBtnCPassword;
    private javax.swing.JToggleButton tgBtnPassword;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
