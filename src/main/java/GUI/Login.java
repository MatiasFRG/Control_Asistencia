/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Data.UsuarioDAO;
import static GUI.Escritorio.PanelPrincipaljsjs;
import Modelo.Usuario;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JInternalFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Correotxt = new javax.swing.JTextField();
        Contraseñatxt = new javax.swing.JPasswordField();
        IngresarBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Sistema de Control de Asistencia");
        jLabel1.setAlignmentY(1.5F);

        jLabel2.setText("Correo:");

        jLabel3.setText("Contraseña:");

        Correotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreotxtActionPerformed(evt);
            }
        });

        Contraseñatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñatxtActionPerformed(evt);
            }
        });

        IngresarBT.setText("Ingresar");
        IngresarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IngresarBT)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Contraseñatxt)
                                .addComponent(Correotxt)))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Correotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Contraseñatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(IngresarBT)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void CorreotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreotxtActionPerformed

    private void IngresarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarBTActionPerformed
        
        String correo = Correotxt.getText().trim();
String clave = new String(Contraseñatxt.getPassword());

// 🔹 Validar que el correo sea @gmail.com
if (!correo.matches("^[a-zA-Z0-9.]+@gmail\\.com$")) {
    JOptionPane.showMessageDialog(this, " El correo debe ser válido y terminar en @gmail.com");
    return; // no sigue al login
}

// 🔹 Validar que la contraseña no esté vacía
if (clave.isEmpty()) {
    JOptionPane.showMessageDialog(this, " La contraseña no puede estar vacía");
    return;
}

UsuarioDAO dao = new UsuarioDAO();
Usuario u = dao.login(correo, clave);

if (u != null) {
    if ("ADMIN".equalsIgnoreCase(u.getRol())) {
        JOptionPane.showMessageDialog(this, " Bienvenido Administrador: " + u.getNombre());
        Menu_Administrador Popelle = new Menu_Administrador();          
        PanelPrincipaljsjs.add(Popelle);     
        Popelle.setVisible(true);

    } else if ("EMPLEADO".equalsIgnoreCase(u.getRol())) {
        JOptionPane.showMessageDialog(this, " Bienvenido Empleado: " + u.getNombre());
        Menu_Empleado Popelle = new Menu_Empleado();          
        PanelPrincipaljsjs.add(Popelle);      
        Popelle.setVisible(true);
    }

    this.dispose(); // cerrar login
} else {
    JOptionPane.showMessageDialog(this, " Usuario o clave incorrectos");
}
        
    }//GEN-LAST:event_IngresarBTActionPerformed

    private void ContraseñatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñatxtActionPerformed
 public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseñatxt;
    private javax.swing.JTextField Correotxt;
    private javax.swing.JButton IngresarBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
