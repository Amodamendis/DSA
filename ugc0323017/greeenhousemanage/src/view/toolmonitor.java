/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Administrator
 */
import model.ToolModel;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.ToolController;
import javax.swing.table.DefaultTableModel;
public class toolmonitor extends javax.swing.JFrame {
    
    public toolmonitor() {
    initComponents();
    
}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        handovertime = new javax.swing.JTextField();
        connu = new javax.swing.JTextField();
        toolname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        borrow = new javax.swing.JButton();
        clearall = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 560, 80, 50));

        handovertime.setBackground(new java.awt.Color(211, 216, 210));
        handovertime.setToolTipText("");
        handovertime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        handovertime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handovertimeActionPerformed(evt);
            }
        });
        getContentPane().add(handovertime, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, 370, 40));

        connu.setBackground(new java.awt.Color(211, 216, 210));
        connu.setToolTipText("");
        connu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        connu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connuActionPerformed(evt);
            }
        });
        getContentPane().add(connu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 370, 40));

        toolname.setBackground(new java.awt.Color(211, 216, 210));
        toolname.setToolTipText("");
        toolname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        toolname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolnameActionPerformed(evt);
            }
        });
        getContentPane().add(toolname, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 370, 40));

        jTable1.setBackground(new java.awt.Color(211, 216, 210));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tool name", "Con,nu", "Handover time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, 340));

        borrow.setBorderPainted(false);
        borrow.setContentAreaFilled(false);
        borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowActionPerformed(evt);
            }
        });
        getContentPane().add(borrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 490, 170, 60));

        clearall.setBorderPainted(false);
        clearall.setContentAreaFilled(false);
        clearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearallActionPerformed(evt);
            }
        });
        getContentPane().add(clearall, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 170, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/toolmonitorl.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SeeTask view = new SeeTask ();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void handovertimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handovertimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_handovertimeActionPerformed

    private void connuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connuActionPerformed

    private void toolnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toolnameActionPerformed

    private void borrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowActionPerformed
        // TODO add your handling code here:
  // Get values from text fields
    String toolNameValue = toolname.getText();
    String connuValue = connu.getText();
    String handoverTimeValue = handovertime.getText();
    
    // Input validation
    if (toolNameValue.isEmpty() || connuValue.isEmpty() || handoverTimeValue.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields");
        return;
    }
    
    try {
        // Convert connu to integer
        int connuInt = Integer.parseInt(connuValue);
        
        // Create model object
        ToolModel tool = new ToolModel(toolNameValue, connuInt, handoverTimeValue);
        
        // Create controller if not already created
        if (controller == null) {
            controller = new ToolController();
        }
        
        // Attempt to save to database
        boolean success = controller.borrowTool(tool);
        
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Tool borrowed successfully");
            controller.updateTableModel(jTable1);
            // Clear the input fields
            toolname.setText("");
            connu.setText("");
            handovertime.setText("");
           
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to borrow tool");
        }
        
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter a valid number for Con.nu");
    }
    }//GEN-LAST:event_borrowActionPerformed

    private void clearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearallActionPerformed
        // TODO add your handling code here
       if (controller == null) {
        controller = new ToolController();
    }
    
    // Show confirmation dialog
    int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete all tools from the database?",
        "Confirm Delete All",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE
    );
    
    if (choice == javax.swing.JOptionPane.YES_OPTION) {
        // Attempt to clear all data
        boolean success = controller.clearAllTools();
        
        if (success) {
            // Clear the JTable
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "All tools have been deleted from the database",
                "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Failed to delete tools from the database",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    }//GEN-LAST:event_clearallActionPerformed
private ToolController controller;

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
            java.util.logging.Logger.getLogger(toolmonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(toolmonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(toolmonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(toolmonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new toolmonitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrow;
    private javax.swing.JButton clearall;
    private javax.swing.JTextField connu;
    private javax.swing.JTextField handovertime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField toolname;
    // End of variables declaration//GEN-END:variables
}
