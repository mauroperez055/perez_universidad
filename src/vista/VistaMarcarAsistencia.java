
package vista;

import control.AlumnoData;
import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Materia;

public class VistaMarcarAsistencia extends javax.swing.JInternalFrame {

    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private Alumno alumnoSeleccionado;
    private Materia materiaSeleccionada;
    private ArrayList<Alumno> alumnosConCursada;
    private ArrayList<Materia> materiasActivas;
    private float asist;
    private int contador = 30;
    private String fechaActual;
    
    public VistaMarcarAsistencia(CursadaData cursadaData, AlumnoData alumnoData, MateriaData materiaData) throws SQLException {
        initComponents();
        this.cursadaData = cursadaData;
        this.alumnoData = alumnoData;
        this.materiaData = materiaData;
        this.alumnosConCursada = cursadaData.alumnosConCursada();
        this.fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        cboMateriasActivas.setEnabled(false);
        btnGuardarAsistencia.setEnabled(false);
     
        txtFechaAsist.setEditable(false);
        txtFechaAsist.setText(fechaActual);

        for (Alumno alu : alumnosConCursada) {
            cboAlumnosActivos.addItem(alu.getApellido() + " " + alu.getNombre());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboAlumnosActivos = new javax.swing.JComboBox<>();
        cboMateriasActivas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardarAsistencia = new javax.swing.JButton();
        txtFechaAsist = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Formulario de Asistencia");

        cboAlumnosActivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        cboAlumnosActivos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAlumnosActivosItemStateChanged(evt);
            }
        });

        cboMateriasActivas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        cboMateriasActivas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMateriasActivasItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione una materia:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de Asistencia:");

        btnGuardarAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarAsistencia.setText("Guardar Asistencia");
        btnGuardarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(jLabel1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboAlumnosActivos, 0, 141, Short.MAX_VALUE)
                                .addComponent(cboMateriasActivas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaAsist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnGuardarAsistencia)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMateriasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaAsist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnGuardarAsistencia)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsistenciaActionPerformed
        // TODO add your handling code here:
        if (alumnoSeleccionado == null || materiaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno y una materia.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            asist = asist +1;
            System.out.println("asist: " + asist);
            float porcentajeAsist = (asist *100) / 30;
            Year anio = Year.now();
            int idAlumno = alumnoSeleccionado.getIdAlumno();
            int idMateria = materiaSeleccionada.getIdMateria();
            Integer idCursada = cursadaData.buscarIdCursada(idAlumno, idMateria, anio);
        
            cursadaData.marcarAsistencia(idCursada, porcentajeAsist);
            JOptionPane.showMessageDialog(this, "Asistencia guardada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el id de la cursada", "Atención", HEIGHT);
            return;
        }
    }//GEN-LAST:event_btnGuardarAsistenciaActionPerformed

    private void cboAlumnosActivosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAlumnosActivosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
                return;
        }
        
        cboMateriasActivas.removeAllItems();
        cboMateriasActivas.addItem("--");
        
        String itemSeleccionado = (String) cboAlumnosActivos.getSelectedItem();
        alumnoSeleccionado = null;
        
        if (itemSeleccionado.equals("--") || itemSeleccionado == null) {
            alumnoSeleccionado = null;
            cboMateriasActivas.setEnabled(false);
            btnGuardarAsistencia.setEnabled(false);
            
            return;
        }
        
        for (Alumno alu : alumnosConCursada) {
            String nombreCompleto = alu.getApellido() + " " + alu.getNombre();
            if (nombreCompleto.equals(itemSeleccionado)) {
                alumnoSeleccionado = alu;
                break;
            }
        }
        
        if (alumnoSeleccionado == null) {
            return;
        }
        
        try {
            materiasActivas = cursadaData.materiasInscriptas(alumnoSeleccionado.getIdAlumno());
          
            cboMateriasActivas.setEnabled(true);
//            btnGuardarAsistencia.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(this, "No se pudieron obtener las materias del alumno.");
            return;
        }
        
        for (Materia mat : materiasActivas) {
            cboMateriasActivas.addItem(mat.getNombre());
        }
 
    }//GEN-LAST:event_cboAlumnosActivosItemStateChanged

    private void cboMateriasActivasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMateriasActivasItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
                return;
        }
        
        String itemSeleccionado = (String) cboMateriasActivas.getSelectedItem();
        materiaSeleccionada = null;
        
        if (itemSeleccionado.equals("--") || itemSeleccionado == null) {
            materiaSeleccionada = null;
            btnGuardarAsistencia.setEnabled(false);
            return;
        }
        
        for (Materia mat: materiasActivas) {
            
            if (mat.getNombre().equals(itemSeleccionado)) {
                materiaSeleccionada = mat;
            }
        }
        
        if (materiaSeleccionada == null) {
            return;
        }
        
        btnGuardarAsistencia.setEnabled(true);

    }//GEN-LAST:event_cboMateriasActivasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarAsistencia;
    private javax.swing.JComboBox<String> cboAlumnosActivos;
    private javax.swing.JComboBox<String> cboMateriasActivas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtFechaAsist;
    // End of variables declaration//GEN-END:variables
}
