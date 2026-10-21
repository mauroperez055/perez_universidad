
package vista;

import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Materia;

public class VistaMateria extends javax.swing.JInternalFrame {

    private MateriaData materiaData;
    private CursadaData cursadaData;
    private Materia materiaSeleccionada;
    
    public VistaMateria(MateriaData materiaData, CursadaData cursadaData) throws SQLException {
        initComponents();
        this.materiaData = materiaData;
        this.cursadaData = cursadaData;
        btnActualizarMat.setEnabled(false);
        btnAltaMat.setEnabled(false);
        btnBajaMat.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreMat = new javax.swing.JTextField();
        cbxActivo = new javax.swing.JCheckBox();
        btnGuardarMat = new javax.swing.JButton();
        btnActualizarMat = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAltaMat = new javax.swing.JButton();
        btnBajaMat = new javax.swing.JButton();
        btnBuscarMat = new javax.swing.JButton();
        txtBuscarMat = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Formulario Materia");

        pnlDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Activa:");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxActivo)
                    .addComponent(txtNombreMat, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbxActivo))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnGuardarMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarMat.setText("Guardar");
        btnGuardarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMatActionPerformed(evt);
            }
        });

        btnActualizarMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarMat.setText("Actualizar");
        btnActualizarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMatActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAltaMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAltaMat.setText("Dar de Alta");
        btnAltaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaMatActionPerformed(evt);
            }
        });

        btnBajaMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBajaMat.setText("Dar de Baja");
        btnBajaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaMatActionPerformed(evt);
            }
        });

        btnBuscarMat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarMat.setText("Buscar");
        btnBuscarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMatActionPerformed(evt);
            }
        });

        txtBuscarMat.setToolTipText("Ingrese el ID de la materia");
        txtBuscarMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarMatKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscarMat)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnGuardarMat)
                                    .addGap(27, 27, 27)
                                    .addComponent(btnActualizarMat)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnAltaMat)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnBajaMat))
                                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMat)
                    .addComponent(txtBuscarMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarMat)
                    .addComponent(btnActualizarMat)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAltaMat)
                    .addComponent(btnBajaMat))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMatKeyTyped
        // TODO add your handling code here:
        VistaPrincipal.validarEnteros(evt, txtBuscarMat);
    }//GEN-LAST:event_txtBuscarMatKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
        cbxActivo.setEnabled(true);
        btnActualizarMat.setEnabled(false);
        btnGuardarMat.setEnabled(true);
        btnAltaMat.setEnabled(false);
        btnBajaMat.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMatActionPerformed
        // TODO add your handling code here:
        if (!VistaPrincipal.validarCamposVacios(pnlDatos)) {
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            return;
        }
        
        try {
            String nombre = txtNombreMat.getText().trim();
            boolean activo = cbxActivo.isSelected();
            
            Materia materiaNueva = new Materia(nombre, activo);
            materiaData.agregarMateria(materiaNueva);
            JOptionPane.showMessageDialog(this, "Materia guardada con éxito.!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "Ya existe una materia registrada con ese nombre.", "Nombre duplicado", JOptionPane.WARNING_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la materia: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            }
        }
    }//GEN-LAST:event_btnGuardarMatActionPerformed

    private void btnBuscarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMatActionPerformed
        // TODO add your handling code here:
        
        if (txtBuscarMat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el id de la materia.", "Atención", JOptionPane.WARNING_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            return;
        }
        
        try {
            
            int idMateria = Integer.parseInt(txtBuscarMat.getText());
            
            materiaSeleccionada = materiaData.buscarMateriaId(idMateria);
            
            if (materiaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la materia.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
                btnActualizarMat.setEnabled(false);
                btnGuardarMat.setEnabled(true);
                return;
            }
            
            txtNombreMat.setText(materiaSeleccionada.getNombre());
            cbxActivo.setSelected(materiaSeleccionada.isActivo());
            
            if (cbxActivo.isSelected()) {
                btnBajaMat.setEnabled(true);
                btnAltaMat.setEnabled(false);
            } else {
                btnAltaMat.setEnabled(true);
                btnBajaMat.setEnabled(false);
            }
            
            cbxActivo.setEnabled(false);
            btnActualizarMat.setEnabled(true);
            btnGuardarMat.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se encontró la materia.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
        }
    }//GEN-LAST:event_btnBuscarMatActionPerformed

    private void btnAltaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaMatActionPerformed
        // TODO add your handling code here:
        try {
            materiaData.altaLogica(materiaSeleccionada);
            cbxActivo.setSelected(true);
            JOptionPane.showMessageDialog(this, "Materia dada de alta correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            btnAltaMat.setEnabled(false);
            cbxActivo.setEnabled(true);
            btnGuardarMat.setEnabled(true);
            btnActualizarMat.setEnabled(false);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta la materia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnAltaMatActionPerformed

    private void btnBajaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaMatActionPerformed
        // TODO add your handling code here:
        
        try {
            int idMateria = materiaSeleccionada.getIdMateria();
            
            if (cursadaData.materiaTieneInscriptos(idMateria)) {
                JOptionPane.showMessageDialog(
                        this, 
                        "No se puede dar de baja la materia porque tiene alumnos inscriptos.", 
                        "Atención", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            materiaData.bajaLogica(materiaSeleccionada);
            cbxActivo.setSelected(false);
            JOptionPane.showMessageDialog(this, "Materia dada de baja correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            btnBajaMat.setEnabled(false);
            cbxActivo.setEnabled(true);
            btnGuardarMat.setEnabled(true);
            btnActualizarMat.setEnabled(false);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo verificar si la materia tiene alumnos inscriptos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnBajaMatActionPerformed

    private void btnActualizarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMatActionPerformed
        // TODO add your handling code here:
        try {
            
            String nombre = txtNombreMat.getText().trim();
            
            materiaSeleccionada.setNombre(nombre);

            materiaData.actualizarMateria(materiaSeleccionada);
            
            JOptionPane.showMessageDialog(this, "Materia actualizada con éxito.!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            btnActualizarMat.setEnabled(false);
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "Ya existe una materia registrada con ese nombre.", "Nombre duplicado", JOptionPane.WARNING_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
                cbxActivo.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la materia: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                VistaPrincipal.limpiarCampos(pnlDatos, txtBuscarMat);
            }
        }
    }//GEN-LAST:event_btnActualizarMatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarMat;
    private javax.swing.JButton btnAltaMat;
    private javax.swing.JButton btnBajaMat;
    private javax.swing.JButton btnBuscarMat;
    private javax.swing.JButton btnGuardarMat;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txtBuscarMat;
    private javax.swing.JTextField txtNombreMat;
    // End of variables declaration//GEN-END:variables
}
