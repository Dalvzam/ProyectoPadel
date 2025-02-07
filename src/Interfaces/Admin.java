/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dalvzam 
 * @author jaimegonher2
 */
public class Admin extends javax.swing.JFrame {
private static final String RUTA_CSV = "src/Datos/reservas.csv";
    /**
     * Creates new form Usuario
     */
    public Admin() {
        initComponents();
        
        cargarUsuariosEnComboBox(); // Cargar los usuarios en el ComboBox


        // Acción para el botón "Bloquear"
        bloquear.addActionListener(e -> bloquearPista(1));

        // Acción para el botón "Desbloquear"
        desbloquear.addActionListener(e -> desBloquearPista(0));
        
    }
    
    private void cargarUsuariosEnComboBox() {
        String rutaArchivo = "src/Datos/usuarios.csv";
        ArrayList<String> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 1) {
                    usuarios.add(datos[0]); // Segunda columna: usuario
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        seleccionarUsuario.setModel(new DefaultComboBoxModel<>(usuarios.toArray(new String[0])));
    }

    private void bloquearPista(int nuevoEstado) {
            File archivo = new File("src/Datos/reservas.csv");
            File tempFile = new File("src/Datos/temp_reservas.csv");
            boolean actualizado = false;
            boolean pistaBloqueada = false;
            boolean flag = false;

            try (BufferedReader br = new BufferedReader(new FileReader(archivo));
                 FileWriter escritor = new FileWriter(tempFile)) {

                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datosLeidos = linea.split(",");

                    if (!actualizado && datosLeidos.length == 8) { // Asegura que tiene 8 columnas
                        String fecha = datosLeidos[0];
                        String turno = datosLeidos[1];
                        String colorPista = datosLeidos[2];
                        String bloqueoPista = datosLeidos[7];

                        if (fecha.equals(fechaFormateada) && turno.equals(WhichTurnoSeleccionado())
                                && colorPista.equals(WhichPistaSeleccionada())) {
                            // Cambiamos el dato para bloquear la pista
                            datosLeidos[7] = "1";
                        }
                    }

                    escritor.write(String.join(",", datosLeidos) + System.lineSeparator());
                }

                if (flag == false){
                    // la fecha escogida no existe en el archivo y hay que guardarla
                    String contenido = fechaFormateada + "," + WhichTurnoSeleccionado() + "," + WhichPistaSeleccionada() + "," + "sin jugador,sin jugador,sin jugador,sin jugador,1"; 
                    escritor.write(contenido + System.lineSeparator());
                }
                    javax.swing.JOptionPane.showMessageDialog(null,
                            "El estado de la pista ha cambiado correctamente.",
                            "Éxito",
                            javax.swing.JOptionPane.ERROR_MESSAGE);


            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            // Reemplaza el archivo original con el actualizado
            if (archivo.delete() && tempFile.renameTo(archivo)) {
                ActualizarPistas(WhichTurnoSeleccionado());
            }
        }

    private void desBloquearPista(int nuevoEstado) {
        File archivo = new File("src/Datos/reservas.csv");
        File tempFile = new File("src/Datos/temp_reservas.csv");
        boolean actualizado = false;
        boolean pistaBloqueada = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             FileWriter escritor = new FileWriter(tempFile)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosLeidos = linea.split(",");

                if (!actualizado && datosLeidos.length == 8) { // Asegura que tiene 8 columnas
                    String fecha = datosLeidos[0];
                    String turno = datosLeidos[1];
                    String colorPista = datosLeidos[2];
                    String bloqueoPista = datosLeidos[7];

                    if (fecha.equals(fechaFormateada) && turno.equals(WhichTurnoSeleccionado())
                            && colorPista.equals(WhichPistaSeleccionada())) {
                        // Cambiamos el dato para bloquear la pista
                        datosLeidos[7] = "0";
                    }
                }

                escritor.write(String.join(",", datosLeidos) + System.lineSeparator());
            }


            javax.swing.JOptionPane.showMessageDialog(null,
                    "El estado de la pista ha cambiado correctamente.",
                    "Éxito",
                    javax.swing.JOptionPane.ERROR_MESSAGE);


        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Reemplaza el archivo original con el actualizado
        if (archivo.delete() && tempFile.renameTo(archivo)) {
            ActualizarPistas(WhichTurnoSeleccionado());
        }
    }

    public static String fechaFormateada;
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        PanelFechaTurno = new javax.swing.JPanel();
        Calendario = new com.toedter.calendar.JCalendar();
        PanelTurnos = new javax.swing.JPanel();
        textoTurnos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Turno_1 = new javax.swing.JToggleButton();
        Turno_2 = new javax.swing.JToggleButton();
        Turno_3 = new javax.swing.JToggleButton();
        Turno_4 = new javax.swing.JToggleButton();
        Turno_5 = new javax.swing.JToggleButton();
        PanelLogo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        botonCancelarReserva = new javax.swing.JButton();
        bloquear = new javax.swing.JButton();
        desbloquear = new javax.swing.JButton();
        seleccionarUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PanelPistas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Pista_Azul = new javax.swing.JLabel();
        jugador_Azul_1 = new javax.swing.JLabel();
        jugador_Azul_2 = new javax.swing.JLabel();
        jugador_Azul_3 = new javax.swing.JLabel();
        jugador_Azul_4 = new javax.swing.JLabel();
        Seleccionado_Azul = new javax.swing.JLabel();
        bloqueado_azul = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Pista_Morada = new javax.swing.JLabel();
        jugador_Morada_1 = new javax.swing.JLabel();
        jugador_Morada_2 = new javax.swing.JLabel();
        jugador_Morada_3 = new javax.swing.JLabel();
        jugador_Morada_4 = new javax.swing.JLabel();
        Seleccionado_Morado = new javax.swing.JLabel();
        bloqueado_morado = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Pista_Roja = new javax.swing.JLabel();
        jugador_Roja_1 = new javax.swing.JLabel();
        jugador_Roja_2 = new javax.swing.JLabel();
        jugador_Roja_3 = new javax.swing.JLabel();
        jugador_Roja_4 = new javax.swing.JLabel();
        Seleccionado_Rojo = new javax.swing.JLabel();
        bloqueado_rojo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Pista_Verde = new javax.swing.JLabel();
        jugador_Verde_1 = new javax.swing.JLabel();
        jugador_Verde_2 = new javax.swing.JLabel();
        jugador_Verde_3 = new javax.swing.JLabel();
        jugador_Verde_4 = new javax.swing.JLabel();
        Seleccionado_Verde = new javax.swing.JLabel();
        bloqueado_verde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 820));
        setResizable(false);

        bg.setMinimumSize(new java.awt.Dimension(1366, 820));
        bg.setPreferredSize(new java.awt.Dimension(1366, 820));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFechaTurno.setBackground(new java.awt.Color(102, 102, 102));

        Calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioPropertyChange(evt);
            }
        });

        textoTurnos.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        textoTurnos.setText("Turnos");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        Turno_1.setText("16:00 - 17:00");
        Turno_1.setActionCommand("");
        Turno_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turno_1ActionPerformed(evt);
            }
        });

        Turno_2.setText("17:00 - 18:00");
        Turno_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turno_2ActionPerformed(evt);
            }
        });

        Turno_3.setText("18:00 - 19:00");
        Turno_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turno_3ActionPerformed(evt);
            }
        });

        Turno_4.setText("19:00 - 20:00");
        Turno_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turno_4ActionPerformed(evt);
            }
        });

        Turno_5.setText("20:00 - 21:00");
        Turno_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Turno_5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTurnosLayout = new javax.swing.GroupLayout(PanelTurnos);
        PanelTurnos.setLayout(PanelTurnosLayout);
        PanelTurnosLayout.setHorizontalGroup(
            PanelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(Turno_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Turno_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Turno_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Turno_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Turno_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTurnosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoTurnos)
                .addGap(244, 244, 244))
        );
        PanelTurnosLayout.setVerticalGroup(
            PanelTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoTurnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Turno_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Turno_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Turno_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Turno_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Turno_5)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelLogo.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_paddle.png"))); // NOI18N

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        botonCancelarReserva.setBackground(new java.awt.Color(255, 102, 0));
        botonCancelarReserva.setText("Cancelar Reserva");
        botonCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarReservaActionPerformed(evt);
            }
        });

        bloquear.setText("Bloquear");

        desbloquear.setText("Desbloquear");
        desbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desbloquearActionPerformed(evt);
            }
        });

        seleccionarUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USUARIO", "Usuario 1", "Usuario 2", "Usuario 3", "Usuario 4" }));
        seleccionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("1. Seleccionar pista");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2. Seleccionar turno");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("3. Seleccionar usuario");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("4. Pulsar cancelar");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Para bloquear o desbloquear, seleccionar antes");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("pista, día y turno.");

        javax.swing.GroupLayout PanelFechaTurnoLayout = new javax.swing.GroupLayout(PanelFechaTurno);
        PanelFechaTurno.setLayout(PanelFechaTurnoLayout);
        PanelFechaTurnoLayout.setHorizontalGroup(
            PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTurnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                        .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelarReserva))
                        .addGap(53, 53, 53)
                        .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel5)
                    .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                        .addComponent(bloquear)
                        .addGap(18, 18, 18)
                        .addComponent(desbloquear))
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelFechaTurnoLayout.setVerticalGroup(
            PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                        .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(PanelFechaTurnoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seleccionarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCancelarReserva)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFechaTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bloquear)
                            .addComponent(desbloquear))))
                .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(PanelFechaTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 780));

        PanelPistas.setBackground(new java.awt.Color(102, 102, 102));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        Pista_Azul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pista_azul.png"))); // NOI18N
        Pista_Azul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pista_AzulMouseClicked(evt);
            }
        });

        jugador_Azul_1.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Azul_1.setText("Sin Jugador");

        jugador_Azul_2.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Azul_2.setText("Sin Jugador");

        jugador_Azul_3.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Azul_3.setText("Sin Jugador");

        jugador_Azul_4.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Azul_4.setText("Sin Jugador");

        Seleccionado_Azul.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Seleccionado_Azul.setForeground(new java.awt.Color(51, 255, 51));
        Seleccionado_Azul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seleccionado_Azul.setText("Seleccionado");
        Seleccionado_Azul.setVisible(false);

        bloqueado_azul.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        bloqueado_azul.setForeground(new java.awt.Color(255, 0, 0));
        bloqueado_azul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bloqueado_azul.setText("BLOQUEADO");
        bloqueado_azul.setVisible(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(Pista_Azul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador_Azul_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Azul_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Azul_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Azul_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Seleccionado_Azul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bloqueado_azul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(Pista_Azul)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bloqueado_azul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Seleccionado_Azul)
                .addGap(18, 18, 18)
                .addComponent(jugador_Azul_1)
                .addGap(18, 18, 18)
                .addComponent(jugador_Azul_2)
                .addGap(18, 18, 18)
                .addComponent(jugador_Azul_3)
                .addGap(18, 18, 18)
                .addComponent(jugador_Azul_4)
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        Pista_Morada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pista_morada.png"))); // NOI18N
        Pista_Morada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pista_MoradaMouseClicked(evt);
            }
        });

        jugador_Morada_1.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Morada_1.setText("Sin Jugador");

        jugador_Morada_2.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Morada_2.setText("Sin Jugador");

        jugador_Morada_3.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Morada_3.setText("Sin Jugador");

        jugador_Morada_4.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Morada_4.setText("Sin Jugador");

        Seleccionado_Morado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Seleccionado_Morado.setForeground(new java.awt.Color(51, 255, 51));
        Seleccionado_Morado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seleccionado_Morado.setText("Seleccionado");
        Seleccionado_Morado.setVisible(false);

        bloqueado_morado.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        bloqueado_morado.setForeground(new java.awt.Color(255, 0, 0));
        bloqueado_morado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bloqueado_morado.setText("BLOQUEADO");
        bloqueado_morado.setVisible(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Pista_Morada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador_Morada_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Morada_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Morada_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Morada_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Seleccionado_Morado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloqueado_morado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Pista_Morada))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bloqueado_morado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Seleccionado_Morado)
                .addGap(18, 18, 18)
                .addComponent(jugador_Morada_1)
                .addGap(18, 18, 18)
                .addComponent(jugador_Morada_2)
                .addGap(18, 18, 18)
                .addComponent(jugador_Morada_3)
                .addGap(18, 18, 18)
                .addComponent(jugador_Morada_4)
                .addGap(127, 127, 127))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        Pista_Roja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pista_roja.png"))); // NOI18N
        Pista_Roja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pista_RojaMouseClicked(evt);
            }
        });

        jugador_Roja_1.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Roja_1.setText("Sin Jugador");

        jugador_Roja_2.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Roja_2.setText("Sin Jugador");

        jugador_Roja_3.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Roja_3.setText("Sin Jugador");

        jugador_Roja_4.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Roja_4.setText("Sin Jugador");

        Seleccionado_Rojo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Seleccionado_Rojo.setForeground(new java.awt.Color(51, 255, 51));
        Seleccionado_Rojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seleccionado_Rojo.setText("Seleccionado");
        Seleccionado_Rojo.setVisible(false);

        bloqueado_rojo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        bloqueado_rojo.setForeground(new java.awt.Color(255, 0, 0));
        bloqueado_rojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bloqueado_rojo.setText("BLOQUEADO");
        bloqueado_rojo.setVisible(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Pista_Roja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jugador_Roja_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jugador_Roja_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jugador_Roja_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jugador_Roja_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Seleccionado_Rojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bloqueado_rojo)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Pista_Roja)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bloqueado_rojo)
                .addGap(56, 56, 56)
                .addComponent(Seleccionado_Rojo)
                .addGap(18, 18, 18)
                .addComponent(jugador_Roja_1)
                .addGap(18, 18, 18)
                .addComponent(jugador_Roja_2)
                .addGap(18, 18, 18)
                .addComponent(jugador_Roja_3)
                .addGap(18, 18, 18)
                .addComponent(jugador_Roja_4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        Pista_Verde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pista_verde.png"))); // NOI18N
        Pista_Verde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pista_VerdeMouseClicked(evt);
            }
        });

        jugador_Verde_1.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Verde_1.setText("Sin Jugador");

        jugador_Verde_2.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Verde_2.setText("Sin Jugador");

        jugador_Verde_3.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Verde_3.setText("Sin Jugador");

        jugador_Verde_4.setForeground(new java.awt.Color(255, 255, 255));
        jugador_Verde_4.setText("Sin Jugador");

        Seleccionado_Verde.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Seleccionado_Verde.setForeground(new java.awt.Color(51, 255, 51));
        Seleccionado_Verde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seleccionado_Verde.setText("Seleccionado");
        Seleccionado_Verde.setVisible(false);

        bloqueado_verde.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        bloqueado_verde.setForeground(new java.awt.Color(255, 0, 0));
        bloqueado_verde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bloqueado_verde.setText("BLOQUEADO");
        bloqueado_verde.setVisible(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Pista_Verde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador_Verde_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Verde_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Verde_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador_Verde_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Seleccionado_Verde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bloqueado_verde)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Pista_Verde)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bloqueado_verde)
                .addGap(53, 53, 53)
                .addComponent(Seleccionado_Verde)
                .addGap(18, 18, 18)
                .addComponent(jugador_Verde_1)
                .addGap(18, 18, 18)
                .addComponent(jugador_Verde_2)
                .addGap(18, 18, 18)
                .addComponent(jugador_Verde_3)
                .addGap(18, 18, 18)
                .addComponent(jugador_Verde_4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPistasLayout = new javax.swing.GroupLayout(PanelPistas);
        PanelPistas.setLayout(PanelPistasLayout);
        PanelPistasLayout.setHorizontalGroup(
            PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPistasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );
        PanelPistasLayout.setVerticalGroup(
            PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPistasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bg.add(PanelPistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 830, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 775, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
        private void CalendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioPropertyChange
            /*Cuando el valor del calendario cambie, cambio de formato la fecha y la almaceno */
            /* Todavia no se si usar la fecha formateada o ya procesada en partes */
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            Date fechaSinFormatear = Calendario.getDate();
            fechaFormateada = df.format(fechaSinFormatear);
            ResetearValoresJugadores();
            ActualizarPistas(WhichTurnoSeleccionado());
            
        
        }//GEN-LAST:event_CalendarioPropertyChange
    
        private void Turno_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turno_1ActionPerformed
            Turno_2.setSelected(false);
            Turno_3.setSelected(false);
            Turno_4.setSelected(false);
            Turno_5.setSelected(false);
            ActualizarPistas("1");
        }//GEN-LAST:event_Turno_1ActionPerformed
    
        private void Turno_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turno_2ActionPerformed
            Turno_1.setSelected(false);
            Turno_3.setSelected(false);
            Turno_4.setSelected(false);
            Turno_5.setSelected(false);
            ActualizarPistas("2");
        }//GEN-LAST:event_Turno_2ActionPerformed
    
        private void Turno_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turno_3ActionPerformed
            Turno_2.setSelected(false);
            Turno_1.setSelected(false);
            Turno_4.setSelected(false);
            Turno_5.setSelected(false);
            ActualizarPistas("3");
        }//GEN-LAST:event_Turno_3ActionPerformed
    
        private void Turno_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turno_4ActionPerformed
            Turno_2.setSelected(false);
            Turno_3.setSelected(false);
            Turno_1.setSelected(false);
            Turno_5.setSelected(false);
            ActualizarPistas("4");
        }//GEN-LAST:event_Turno_4ActionPerformed
    
        private void Turno_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Turno_5ActionPerformed
            Turno_2.setSelected(false);
            Turno_3.setSelected(false);
            Turno_4.setSelected(false);
            Turno_1.setSelected(false);
            ActualizarPistas("5");
        }//GEN-LAST:event_Turno_5ActionPerformed

        private void botonHacerReservaActionPerformed(java.awt.event.ActionEvent evt) {
            String contenido = fechaFormateada + "," + WhichTurnoSeleccionado() + "," + WhichPistaSeleccionada()+","+Login.USER+",sin jugador,sin jugador,sin jugador";
            File archivo = new File("src/Datos/reservas.csv");
            File tempFile = new File("src/Datos/temp_reservas.csv");
            boolean actualizado = false;
        
            try (BufferedReader br = new BufferedReader(new FileReader(archivo));
                 FileWriter escritor = new FileWriter(tempFile)) {
        
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datosLeidos = linea.split(",");
        
                    if (!actualizado && datosLeidos.length == 7) {
                        String fecha = datosLeidos[0];
                        String turno = datosLeidos[1];
                        String colorPista = datosLeidos[2];
        
                        if (fecha.equals(fechaFormateada) && turno.equals(WhichTurnoSeleccionado()) && colorPista.equals(WhichPistaSeleccionada())) {
                            // Revisamos las columnas de jugadores (índices 3 a 6)
                            for (int i = 3; i <= 6; i++) {
                                if (datosLeidos[i].equalsIgnoreCase("sin jugador") || datosLeidos[i].equalsIgnoreCase(Login.USER)) {
                                    datosLeidos[i] = Login.USER; // Reemplaza la primera coincidencia
                                    actualizado = true;
                                    break; // Sale del bucle
                                }
                            }
                        }
                    }
                    
                    escritor.write(String.join(",", datosLeidos) + System.lineSeparator());
                }
                // Si no se ha actualizado, agregar la nueva línea
                if (!actualizado) {
                    escritor.write(contenido + System.lineSeparator());
                }
                
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            
            // Reemplaza el archivo original con el actualizado
            if (archivo.delete() && tempFile.renameTo(archivo)) {
                ActualizarPistas(WhichTurnoSeleccionado());
            } 
            
            
        }

    private void Pista_AzulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pista_AzulMouseClicked
        if (Seleccionado_Azul.isVisible()) {
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
        }else{
            Seleccionado_Azul.setVisible(true);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
            PistaSeleccionada = "azul";
        }
    }//GEN-LAST:event_Pista_AzulMouseClicked

    private void Pista_MoradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pista_MoradaMouseClicked
        if (Seleccionado_Morado.isVisible()) {
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
        }else{
            Seleccionado_Morado.setVisible(true);
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
            PistaSeleccionada = "morada";
        }
    }//GEN-LAST:event_Pista_MoradaMouseClicked

    private void Pista_RojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pista_RojaMouseClicked
        if (Seleccionado_Rojo.isVisible()) {
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
        }else{
            Seleccionado_Rojo.setVisible(true);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Verde.setVisible(false);
            PistaSeleccionada = "roja";
        }
    }//GEN-LAST:event_Pista_RojaMouseClicked

    private void Pista_VerdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pista_VerdeMouseClicked
        if (Seleccionado_Verde.isVisible()) {
            Seleccionado_Azul.setVisible(false);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Verde.setVisible(false);
        }else{
            Seleccionado_Verde.setVisible(true);
            Seleccionado_Morado.setVisible(false);
            Seleccionado_Rojo.setVisible(false);
            Seleccionado_Azul.setVisible(false);
            PistaSeleccionada = "verde";
        }
    }//GEN-LAST:event_Pista_VerdeMouseClicked

    private void botonCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {
        File archivo = new File("src/Datos/reservas.csv");
        File tempFile = new File("src/Datos/temp_reservas.csv");
        boolean actualizado = false;
        boolean pistaBloqueada = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             FileWriter escritor = new FileWriter(tempFile)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosLeidos = linea.split(",");

                if (!actualizado && datosLeidos.length == 8) { // Asegura que tiene 8 columnas
                    String fecha = datosLeidos[0];
                    String turno = datosLeidos[1];
                    String colorPista = datosLeidos[2];
                    String bloqueoPista = datosLeidos[7];

                    if (fecha.equals(fechaFormateada) && turno.equals(WhichTurnoSeleccionado())
                            && colorPista.equals(WhichPistaSeleccionada())) {

                        if (bloqueoPista.equals("1")) {
                            pistaBloqueada = true;
                        } else {
                            // Revisamos las columnas de jugadores (índices 3 a 6)
                            for (int i = 3; i <= 6; i++) {
                                if (datosLeidos[i].equalsIgnoreCase(seleccionarUsuario.getSelectedItem().toString())) {
                                    datosLeidos[i] = "sin jugador"; // Reemplaza la primera coincidencia
                                    actualizado = true;
                                    break; // Sale del bucle
                                }
                            }
                        }
                    }
                }

                escritor.write(String.join(",", datosLeidos) + System.lineSeparator());
            }

            // Mostrar mensaje si la pista está bloqueada y no permitir cancelar
            if (pistaBloqueada) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "No puedes cancelar la reserva porque la pista está bloqueada por el administrador.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Reemplaza el archivo original con el actualizado
        if (archivo.delete() && tempFile.renameTo(archivo)) {
            ActualizarPistas(WhichTurnoSeleccionado());
        }
    }                                                    

    private void desbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desbloquearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desbloquearActionPerformed

    private void seleccionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarUsuarioActionPerformed

    public static void ActualizarPistas(String turnoSeleccionado){
        /* Cada vez que se seleccione un turno, las pistas se actualizarán y mostraran los jugadores */
        FileReader fr = null;
        BufferedReader br = null;
        File archivo = new File("src/Datos/reservas.csv");
        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            bloqueado_azul.setVisible(false);
            bloqueado_morado.setVisible(false);
            bloqueado_rojo.setVisible(false);
            bloqueado_verde.setVisible(false);
            String linea;
            String fecha;
            String turno;
            String colorPista;
            String jugador1;
            String jugador2;
            String jugador3;
            String jugador4;
            String pistabloqueada;

            ResetearValoresJugadores();

            while((linea = br.readLine()) != null){
                String datosLeidos [] = linea.split(",");
                if (datosLeidos.length == 8){
                    fecha = datosLeidos[0];
                    turno = datosLeidos[1];
                    colorPista = datosLeidos[2];
                    jugador1 = datosLeidos[3];
                    jugador2 = datosLeidos[4];
                    jugador3 = datosLeidos[5];
                    jugador4 = datosLeidos[6];
                    pistabloqueada = datosLeidos[7];
                    if (fecha.equals(fechaFormateada) && turno.equals(turnoSeleccionado)){
                        switch (colorPista) {
                            case "azul":
                                jugador_Azul_1.setText(jugador1);
                                jugador_Azul_2.setText(jugador2);
                                jugador_Azul_3.setText(jugador3);
                                jugador_Azul_4.setText(jugador4);
                                if(pistabloqueada.equals("1")){
                                    bloqueado_azul.setVisible(true);
                                }
                                break;
                            case "morada":
                                jugador_Morada_1.setText(jugador1);
                                jugador_Morada_2.setText(jugador2);
                                jugador_Morada_3.setText(jugador3);
                                jugador_Morada_4.setText(jugador4);
                                if(pistabloqueada.equals("1")){
                                    bloqueado_morado.setVisible(true);
                                }
                                break;
                            case "roja":
                                jugador_Roja_1.setText(jugador1);
                                jugador_Roja_2.setText(jugador2);
                                jugador_Roja_3.setText(jugador3);
                                jugador_Roja_4.setText(jugador4);
                                if(pistabloqueada.equals("1")){
                                    bloqueado_rojo.setVisible(true);
                                }
                                break;
                            case "verde":
                                jugador_Verde_1.setText(jugador1);
                                jugador_Verde_2.setText(jugador2);
                                jugador_Verde_3.setText(jugador3);
                                jugador_Verde_4.setText(jugador4);
                                if(pistabloqueada.equals("1")){
                                    bloqueado_verde.setVisible(true);
                                }
                                break;

                            default:
                                break;
                        }
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
    }

    public static void ResetearValoresJugadores(){
        jugador_Azul_1.setText("Sin jugador");
        jugador_Azul_2.setText("Sin jugador");
        jugador_Azul_3.setText("Sin jugador");
        jugador_Azul_4.setText("Sin jugador");

        jugador_Morada_1.setText("Sin jugador");
        jugador_Morada_2.setText("Sin jugador");
        jugador_Morada_3.setText("Sin jugador");
        jugador_Morada_4.setText("Sin jugador");

        jugador_Roja_1.setText("Sin jugador");
        jugador_Roja_2.setText("Sin jugador");
        jugador_Roja_3.setText("Sin jugador");
        jugador_Roja_4.setText("Sin jugador");

        jugador_Verde_1.setText("Sin jugador");
        jugador_Verde_2.setText("Sin jugador");
        jugador_Verde_3.setText("Sin jugador");
        jugador_Verde_4.setText("Sin jugador");
    }

    public static String WhichTurnoSeleccionado(){
        if (Turno_1.isSelected()){
            return "1";
        }
        if (Turno_2.isSelected()) {
            return "2";
        }
        if (Turno_3.isSelected()) {
            return "3";
        }
        if (Turno_4.isSelected()) {
            return "4";
        }
        if (Turno_5.isSelected()) {
            return "5";
        }else{
            return "0";
        }
    }

    public static String WhichPistaSeleccionada(){
        if (Seleccionado_Azul.isVisible()) {
            return "azul";
        }
        if (Seleccionado_Morado.isVisible()) {
            return "morada";
        }
        if (Seleccionado_Rojo.isVisible()) {
            return "roja";
        }
        if (Seleccionado_Verde.isVisible()) {
            return "verde";
        }else{
            return "0";
        }
    }

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
    public static String PistaSeleccionada;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendario;
    private javax.swing.JPanel PanelFechaTurno;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelPistas;
    private javax.swing.JPanel PanelTurnos;
    public static javax.swing.JLabel Pista_Azul;
    public static javax.swing.JLabel Pista_Morada;
    public static javax.swing.JLabel Pista_Roja;
    public static javax.swing.JLabel Pista_Verde;
    public static javax.swing.JLabel Seleccionado_Azul;
    public static javax.swing.JLabel Seleccionado_Morado;
    public static javax.swing.JLabel Seleccionado_Rojo;
    public static javax.swing.JLabel Seleccionado_Verde;
    public static javax.swing.JToggleButton Turno_1;
    public static javax.swing.JToggleButton Turno_2;
    public static javax.swing.JToggleButton Turno_3;
    public static javax.swing.JToggleButton Turno_4;
    public static javax.swing.JToggleButton Turno_5;
    private javax.swing.JPanel bg;
    public static javax.swing.JLabel bloqueado_azul;
    public static javax.swing.JLabel bloqueado_morado;
    public static javax.swing.JLabel bloqueado_rojo;
    public static javax.swing.JLabel bloqueado_verde;
    private javax.swing.JButton bloquear;
    private javax.swing.JButton botonCancelarReserva;
    private javax.swing.JButton desbloquear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel jugador_Azul_1;
    public static javax.swing.JLabel jugador_Azul_2;
    public static javax.swing.JLabel jugador_Azul_3;
    public static javax.swing.JLabel jugador_Azul_4;
    public static javax.swing.JLabel jugador_Morada_1;
    public static javax.swing.JLabel jugador_Morada_2;
    public static javax.swing.JLabel jugador_Morada_3;
    public static javax.swing.JLabel jugador_Morada_4;
    public static javax.swing.JLabel jugador_Roja_1;
    public static javax.swing.JLabel jugador_Roja_2;
    public static javax.swing.JLabel jugador_Roja_3;
    public static javax.swing.JLabel jugador_Roja_4;
    public static javax.swing.JLabel jugador_Verde_1;
    public static javax.swing.JLabel jugador_Verde_2;
    public static javax.swing.JLabel jugador_Verde_3;
    public static javax.swing.JLabel jugador_Verde_4;
    private javax.swing.JComboBox<String> seleccionarUsuario;
    private javax.swing.JLabel textoTurnos;
    // End of variables declaration//GEN-END:variables
}
