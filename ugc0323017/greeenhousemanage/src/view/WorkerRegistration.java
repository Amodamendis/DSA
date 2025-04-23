/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.regex.Pattern;
import controller.WorkerController;
import javax.swing.JOptionPane;
import model.WorkerModel;
public class WorkerRegistration extends javax.swing.JFrame {

    /**
     * Creates new form workerregistration
     */
    public WorkerRegistration() {
        initComponents();
        setLocationRelativeTo(null);  
        addInputValidation();
    }
        private void addInputValidation() {
        // Add key listeners for real-time validation
        username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validateUsername();
            }
        });
        
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validatePassword();
            }
        });
        
        email.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validateEmail();
            }
        });
    }
    
    private boolean validateEmail() {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String emailText = email.getText().trim();
        
        if (!Pattern.matches(emailRegex, emailText)) {
            email.putClientProperty("valid", false);
            return false;
        }
        
        email.putClientProperty("valid", true);
        return true;
    }
    
    private boolean validateUsername() {
        String usernameText = username.getText().trim();
        
        if (usernameText.length() < 5) {
            username.putClientProperty("valid", false);
            return false;
        }
        
        boolean hasLetter = false;
        boolean hasNumber = false;
        
        for (char c : usernameText.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasNumber = true;
        }
        
        if (!hasLetter || !hasNumber) {
            username.putClientProperty("valid", false);
            return false;
        }
        
        username.putClientProperty("valid", true);
        return true;
    }
    private boolean validatePassword() {
        String passwordText = password.getText().trim();
        
        if (passwordText.length() < 5) {
            password.putClientProperty("valid", false);
            return false;
        }
        
        boolean hasLetter = false;
        boolean hasNumber = false;
        
        for (char c : passwordText.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasNumber = true;
        }
        
        if (!hasLetter || !hasNumber) {
            password.putClientProperty("valid", false);
            return false;
        }
        
        password.putClientProperty("valid", true);
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(211, 216, 210));
        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 380, 340, 50));

        password.setBackground(new java.awt.Color(211, 216, 210));
        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 340, 50));

        name.setBackground(new java.awt.Color(211, 216, 210));
        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 340, 50));

        email.setBackground(new java.awt.Color(211, 216, 210));
        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 340, 50));

        create.setBorderPainted(false);
        create.setContentAreaFilled(false);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        getContentPane().add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 340, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/workerregistration.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
   try {
            String workerName = name.getText().trim();
            String workerEmail = email.getText().trim();
            String workerUsername = username.getText().trim();
            String workerPassword = password.getText().trim();
            
            // Validate empty fields
            if (workerName.isEmpty() || workerEmail.isEmpty() || 
                workerUsername.isEmpty() || workerPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validate email format
            if (!validateEmail()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address!", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            WorkerController controller = new WorkerController();
            
            // Validate username and password
            if (!validateUsername() || !validatePassword()) {
                JOptionPane.showMessageDialog(this, 
                    "Username and password must be at least 5 characters long and contain both letters and numbers!", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create worker object
            WorkerModel worker = new WorkerModel(workerName, workerEmail, workerUsername, workerPassword);
            
            // Register worker
            if (controller.registerWorker(worker)) {
                JOptionPane.showMessageDialog(this, "Registration successful!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                // Open worker login form
                new WorkerLogin().setVisible(true);
                this.dispose(); // Close registration form
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed! Please try again.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "An error occurred: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        name.setText("");
        email.setText("");
        username.setText("");
        password.setText("");

    }//GEN-LAST:event_createActionPerformed

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
            java.util.logging.Logger.getLogger(WorkerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
