/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dalvzam
 * @author jaimegonher2
 */
public class Registro extends javax.swing.JFrame {

    private void guardarUsuarioEnCSV() {
        String nombre = Usuario.getText();
        String apellido1 = Usuario1.getText();
        String apellido2 = Usuario2.getText();
        String email = Usuario3.getText();
        String nivel = (String) jComboBox1.getSelectedItem();

        String rutaArchivo = "src/Datos/usuarios.csv"; // Ruta del archivo CSV

        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(nombre + "," + apellido1 + "," + apellido2 + "," + email + "," + nivel);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form Login
     */
    public Registro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Registrar = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        BotonRegistro = new javax.swing.JButton();
        BotonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarUsuarioEnCSV();
            }
        });
        jComboBox1 = new javax.swing.JComboBox<>();
        Usuario1 = new javax.swing.JTextField();
        Usuario2 = new javax.swing.JTextField();
        Usuario3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setFont(bg.getFont().deriveFont(bg.getFont().getStyle() | java.awt.Font.BOLD, bg.getFont().getSize()+23));
        bg.setMinimumSize(new java.awt.Dimension(1366, 768));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Registrar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 48)); // NOI18N
        Registrar.setText("Registro");

        Usuario.setForeground(new java.awt.Color(153, 153, 153));
        Usuario.setText("Nombre");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });
        Usuario.setText("Nombre");
        Usuario.setForeground(new java.awt.Color(153, 153, 153)); // Color gris para simular placeholder

        Usuario.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Usuario.getText().equals("Nombre")) {
                    Usuario.setText("");
                    Usuario.setForeground(new java.awt.Color(0, 0, 0)); // Cambiar a negro al escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Usuario.getText().isEmpty()) {
                    Usuario.setText("Nombre");
                    Usuario.setForeground(new java.awt.Color(153, 153, 153)); // Volver al color gris si está vacío
                }
            }
        });


        BotonRegistro.setBackground(new java.awt.Color(255, 102, 0));
        BotonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        BotonRegistro.setText("Registrar");
        BotonRegistro.setToolTipText("");
        BotonRegistro.setPreferredSize(new java.awt.Dimension(100, 32));
        BotonRegistro.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30)); // Ajusta la fuente y tamaño

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIVEL", "Principiante", "Intermedio", "Avanzado" }));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"NIVEL", "Principiante", "Intermedio", "Avanzado"}));
        jComboBox1.setSelectedIndex(0); // Se asegura de que "NIVEL" aparezca primero

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (jComboBox1.getSelectedIndex() == 0) {
                    jComboBox1.setSelectedIndex(-1); // Evita que "NIVEL" sea seleccionable
                }
            }
        });


        Usuario1.setForeground(new java.awt.Color(153, 153, 153));
        Usuario1.setText("Primer apellido");
        Usuario1.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Usuario1.getText().equals("Primer apellido")) {
                    Usuario1.setText("");
                    Usuario1.setForeground(new java.awt.Color(0, 0, 0)); // Cambiar a negro al escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Usuario1.getText().isEmpty()) {
                    Usuario1.setText("Primer apellido");
                    Usuario1.setForeground(new java.awt.Color(153, 153, 153)); // Volver al color gris si está vacío
                }
            }
        });

        Usuario2.setForeground(new java.awt.Color(153, 153, 153));
        Usuario2.setText("E-mail");

        Usuario2.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Usuario2.getText().equals("E-mail")) {
                    Usuario2.setText("");
                    Usuario2.setForeground(new java.awt.Color(0, 0, 0)); // Cambiar a negro al escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Usuario2.getText().isEmpty()) {
                    Usuario2.setText("E-mail");
                    Usuario2.setForeground(new java.awt.Color(153, 153, 153)); // Volver al color gris si está vacío
                }
            }
        });

        Usuario3 = new javax.swing.JPasswordField();
        Usuario3.setForeground(new java.awt.Color(153, 153, 153));
        Usuario3.setText("Contraseña");
        Usuario3.setEchoChar((char) 0); // Mostrar texto normal inicialmente

        Usuario3.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(Usuario3.getPassword()).equals("Contraseña")) {
                    Usuario3.setText("");
                    Usuario3.setEchoChar('●'); // Cambiar a asteriscos al escribir
                    Usuario3.setForeground(new java.awt.Color(0, 0, 0)); // Cambiar a negro
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(Usuario3.getPassword()).isEmpty()) {
                    Usuario3.setEchoChar((char) 0); // Mostrar texto normal
                    Usuario3.setText("Contraseña");
                    Usuario3.setForeground(new java.awt.Color(153, 153, 153)); // Volver al color gris si está vacío
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Registrar)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BotonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BotonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 450, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed

    }//GEN-LAST:event_UsuarioActionPerformed


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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registro loginFrame = new Registro();
                loginFrame.pack();
                loginFrame.setLocationRelativeTo(null); // Centrar la ventana
                loginFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegistro;
    private javax.swing.JLabel Registrar;
    private javax.swing.JTextField Usuario;
    private javax.swing.JTextField Usuario1;
    private javax.swing.JTextField Usuario2;
    private javax.swing.JPasswordField Usuario3;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}