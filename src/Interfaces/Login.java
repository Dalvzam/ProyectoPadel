/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Dalvzam
 * @author jaimegonher2
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public static String USER;
    public String ComprobarUsuario(File archivo,String usuario,String contrasenia){
        /* Esta funcion retornará tipo de usuario que se ha logeado:
         * - 0 si no es un usuario registrado
         * - 1 si es un usuario normal
         * - 2 si es un usuario Administrador
        */
        FileReader fr = null;
        BufferedReader br = null;
        
        String password;
        String tipoUser;
        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            
            while((linea = br.readLine()) != null){
                String datosLeidos [] = linea.split(",");
                if (datosLeidos.length == 3){
                    USER = datosLeidos[0];
                    password = datosLeidos[1];
                    tipoUser = datosLeidos[2];
                    if (USER.equals(usuario) && password.equals(contrasenia)){
                        return tipoUser;
                    }
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "0";
    }
    
    public Login() {
    initComponents();
    
    // Configuración del ActionListener para el botón Login
    BotonLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el texto ingresado en los campos de Usuario y Contraseña
            String usuario = Usuario.getText();
            String contraseña = Contraseña.getText();
            
            
            File archivo = new File("src/Datos/usuarios.csv");
            
            if (ComprobarUsuario(archivo, usuario, contraseña).equals("1")) {
                // Cerrar el frame actual
                dispose();
                
                // Mostrar el otro frame del usuario registrado
                Usuario JFrameUsuario = new Usuario(); 
                JFrameUsuario.setVisible(true);
            // En el caso de que el usuario y contraseña que se introduzca sea uno registrado como Administrador (tipo 2) mostrará el frame de administrador
            } else if(ComprobarUsuario(archivo, usuario, contraseña).equals("2")){
                // Cerrar el frame actual
                dispose();
                
                // Mostrar el otro frame del Administrador
                Admin JFrameAdmin = new Admin(); 
                JFrameAdmin.setVisible(true);
            }else {
                // Mostrar mensaje de error si no coincide
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "Usuario o contraseña incorrectos", 
                    "Error", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    
    Registrarse.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Cerrar el frame actual
            dispose();

            // Mostrar el otro frame de Registro
            Registro JFrameRegistro = new Registro(); 
            JFrameRegistro.setVisible(true);
        }
    });
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
        Login = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JTextField();
        BotonLogin = new javax.swing.JButton();
        Registrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setMinimumSize(new java.awt.Dimension(1366, 768));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        Login.setText("Login");

        Usuario.setForeground(new java.awt.Color(153, 153, 153));
        Usuario.setText("Usuario");

        Contraseña.setForeground(new java.awt.Color(153, 153, 153));
        Contraseña.setText("Contraseña");

        BotonLogin.setBackground(new java.awt.Color(255, 102, 0));
        BotonLogin.setText("Login");

        Registrarse.setText("Registrarse");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(165, 165, 165))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)))
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(Registrarse)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Registrarse)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 450, 540));

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JTextField Contraseña;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Registrarse;
    private javax.swing.JTextField Usuario;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
