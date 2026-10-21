
package vista;

import control.AlumnoData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Alumno;
import java.sql.SQLException;

public class VistaAlumno extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private Alumno alumnoSeleccionado;

    public VistaAlumno(AlumnoData alumnoData) {
        initComponents();
        this.alumnoData = alumnoData;
        dcFechaNac.getDateEditor().setEnabled(false);
        btnActualizar.setEnabled(false);
        btnAlta.setEnabled(false);
        btnBaja.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbxActivo = new javax.swing.JCheckBox();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Formulario Alumno");

        pnlDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre/s:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Apellido/s:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Activo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("DNI: ");

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        dcFechaNac.setMaxSelectableDate(new java.util.Date(1246373999000L));
        dcFechaNac.setMinSelectableDate(new java.util.Date(-62135755110000L));

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxActivo)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellido))
                    .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbxActivo))
                .addGap(14, 14, 14))
        );

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlta.setText("Dar de Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBaja.setText("Dar de Baja");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setToolTipText("Ingrese el dni del alumno");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)))
                .addGap(18, 18, 18)
                .addComponent(btnAlta)
                .addGap(18, 18, 18)
                .addComponent(btnBaja)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAlta)
                    .addComponent(btnBaja))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        VistaPrincipal.validarEnteros(evt, txtDni);
    }//GEN-LAST:event_txtDniKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!VistaPrincipal.validarCamposVacios(pnlDatos)) {
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
            return;
        }
        
        try {
            int dni = Integer.parseInt(txtDni.getText());
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            
            Date fechaElegida = dcFechaNac.getDate();
            if (fechaElegida == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha de nacimiento.");
                return;
            }
            
            LocalDate fechaNac = fechaElegida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println(fechaNac);
            
            boolean activo = cbxActivo.isSelected();
            System.out.println(activo);
            
            Alumno alumnoNuevo = new Alumno(dni, apellido, nombre, fechaNac, activo);
            alumnoData.agregarAlumno(alumnoNuevo);
            
            JOptionPane.showMessageDialog(this, "Alumno guardado con éxito.!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "Ya existe un alumno registrado con ese DNI.", "DNI duplicado", JOptionPane.WARNING_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
                cbxActivo.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el alumno: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
            }
        } 
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        VistaPrincipal.validarEnteros(evt, txtDni);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        if (txtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el dni del alumno.", "Atención", JOptionPane.WARNING_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
            return;
        }
        
        try {
            
            int dni = Integer.parseInt(txtBuscar.getText());
        
            alumnoSeleccionado = alumnoData.buscarAlumno(dni);
            
            if (alumnoSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el alumno.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
                return;
            }
            
            txtDni.setText(String.valueOf(alumnoSeleccionado.getDni()));
            txtNombre.setText(alumnoSeleccionado.getNombre());
            txtApellido.setText(alumnoSeleccionado.getApellido());
            dcFechaNac.setDate(java.sql.Date.valueOf(alumnoSeleccionado.getFechaNac()));
            cbxActivo.setSelected(alumnoSeleccionado.isActivo());
            
            if (cbxActivo.isSelected()) {
                btnBaja.setEnabled(true);
                btnAlta.setEnabled(false);
            } else {
                btnAlta.setEnabled(true);
                btnBaja.setEnabled(false);
            }
            
            cbxActivo.setEnabled(false);
            btnActualizar.setEnabled(true);
            btnGuardar.setEnabled(false);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se encontró el alumno.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
        cbxActivo.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnAlta.setEnabled(false);
        btnBaja.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            
            int dni = Integer.parseInt(txtDni.getText());
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            
            Date fechaElegida = dcFechaNac.getDate();
            if (fechaElegida == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha de nacimiento.");
                return;
            }
            
            LocalDate fechaNac = fechaElegida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println(fechaNac);
            
            alumnoSeleccionado.setDni(dni);
            alumnoSeleccionado.setApellido(apellido);
            alumnoSeleccionado.setNombre(nombre);
            alumnoSeleccionado.setFechaNac(fechaNac);

            alumnoData.actualizarAlumno(alumnoSeleccionado);
            
            JOptionPane.showMessageDialog(this, "Alumno actualizado con éxito.!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
            btnActualizar.setEnabled(false);
            btnGuardar.setEnabled(true);
            cbxActivo.setEnabled(true);
            btnAlta.setEnabled(false);
            btnBaja.setEnabled(false);
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "Ya existe un alumno registrado con ese DNI.", "DNI duplicado", JOptionPane.WARNING_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
                cbxActivo.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el alumno: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscar);
            }
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        // TODO add your handling code here:
        try {
            alumnoData.altaLogica(alumnoSeleccionado);
            cbxActivo.setSelected(true);
            JOptionPane.showMessageDialog(this, "Alumno dado de alta correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            btnAlta.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta al alumno", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        try {
            alumnoData.bajaLogica(alumnoSeleccionado);
            cbxActivo.setSelected(false);
            JOptionPane.showMessageDialog(this, "Alumno dado de baja correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            btnBaja.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta al alumno", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbxActivo;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
