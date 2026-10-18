
package vista;

import control.AlumnoData;
import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

public class VistaCursada extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private CursadaData cursadaData;
    private ArrayList<Alumno> alumnos;
    private Alumno alumnoSeleccionado;
    private Materia materiaSeleccionada;
    private ArrayList<Materia> materias; // lista de materias activas
    private ArrayList<Materia> materiasInscriptas; 
    private ArrayList<Materia> materiasNoInscriptas;
    private DefaultTableModel modelo;
    
    public VistaCursada(AlumnoData alumnoData, MateriaData materiaData, CursadaData cursadaData) throws SQLException {
        initComponents();
        this.alumnoData = alumnoData;
        this.materiaData = materiaData;
        this.cursadaData = cursadaData;
        this.alumnos = alumnoData.listarActivos();
        this.materias = materiaData.listarMateriasActivas();
        this.modelo = (DefaultTableModel) tblMateriasActivas.getModel();
        
        btnInscribir.setEnabled(false);
        btnDesinscribir.setEnabled(false);
        rbtnInscriptas.setEnabled(false);
        rbtnNoInscriptas.setEnabled(false);
        lblMensaje.setVisible(false);
        
        VistaPrincipal.borraFilasTabla(modelo);
        
        for (Alumno alu : alumnos) {
            cboxAlumnosActivos.addItem(alu.getApellido() + " " + alu.getNombre());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgInscriptas = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cboxAlumnosActivos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriasActivas = new javax.swing.JTable();
        btnInscribir = new javax.swing.JButton();
        btnDesinscribir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbtnInscriptas = new javax.swing.JRadioButton();
        rbtnNoInscriptas = new javax.swing.JRadioButton();
        lblMensaje = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Inscripción a Materias");

        cboxAlumnosActivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        cboxAlumnosActivos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxAlumnosActivosItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Alumnos:");

        tblMateriasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID MATERIA", "NOMBRE MATERIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMateriasActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriasActivasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMateriasActivas);

        btnInscribir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnDesinscribir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesinscribir.setText("Desinscribir");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Materias:");

        rbgInscriptas.add(rbtnInscriptas);
        rbtnInscriptas.setText("Inscriptas");
        rbtnInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInscriptasActionPerformed(evt);
            }
        });

        rbgInscriptas.add(rbtnNoInscriptas);
        rbtnNoInscriptas.setText("No Inscriptas");
        rbtnNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoInscriptasActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btnInscribir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesinscribir)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(rbtnInscriptas)
                                .addGap(93, 93, 93)
                                .addComponent(rbtnNoInscriptas))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(lblMensaje)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbtnInscriptas)
                    .addComponent(rbtnNoInscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnDesinscribir))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxAlumnosActivosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxAlumnosActivosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
                return;
        }

        String itemSeleccionado = (String) cboxAlumnosActivos.getSelectedItem();

        if (itemSeleccionado.equals("--") || itemSeleccionado == null) {
            alumnoSeleccionado = null;
            materiaSeleccionada = null;
            materiasInscriptas = null;

            rbtnInscriptas.setEnabled(false);
            rbtnNoInscriptas.setEnabled(false);
            lblMensaje.setVisible(false);

            btnInscribir.setEnabled(false);
            btnDesinscribir.setEnabled(false);

            VistaPrincipal.borraFilasTabla(modelo);
            rbgInscriptas.clearSelection();

            return;
        }

        for (Alumno alu : alumnos) {
            String nombreCompleto = alu.getApellido() + " " + alu.getNombre();

            if (nombreCompleto.equals(itemSeleccionado)) {
                    alumnoSeleccionado = alu; //obtengo el alumno seleccionado del comboBox
                    break;
            }
        }

        if (alumnoSeleccionado == null) {
            return;
        }

        VistaPrincipal.borraFilasTabla(modelo);
        rbgInscriptas.clearSelection();
        rbtnInscriptas.setEnabled(true);  
        rbtnNoInscriptas.setEnabled(true);
            
        try {
            int idAlumno = alumnoSeleccionado.getIdAlumno();
            materiasInscriptas = cursadaData.materiasInscriptas(idAlumno);
            materiasNoInscriptas = cursadaData.materiasNoInscriptas(idAlumno);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener las materias del alumno.", "Atención", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return;
        }
    }//GEN-LAST:event_cboxAlumnosActivosItemStateChanged

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void tblMateriasActivasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriasActivasMouseClicked
        // TODO add your handling code here:
        int fila = tblMateriasActivas.getSelectedRow();
        
        if (fila >= 0) {
            try {
                int idMateria = (int) tblMateriasActivas.getModel().getValueAt(fila, 0);
                materiaSeleccionada = materiaData.buscarMateriaId(idMateria); //obtengo la materia elegida de la tabla
                System.out.println(materiaSeleccionada.toString());
            } catch (SQLException ex) {
                System.getLogger(VistaCursada.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } else {
            materiaSeleccionada = null;
        }
    }//GEN-LAST:event_tblMateriasActivasMouseClicked

    private void rbtnInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInscriptasActionPerformed
        // TODO add your handling code here:
        if (alumnoSeleccionado == null) {
            return;
        }
        btnInscribir.setEnabled(false);
        btnDesinscribir.setEnabled(true);
        lblMensaje.setText("Seleccione una materia para Desinscribirse.");
        lblMensaje.setVisible(true);
        VistaPrincipal.cargarTablaMaterias(materiasInscriptas, tblMateriasActivas);
    }//GEN-LAST:event_rbtnInscriptasActionPerformed

    private void rbtnNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoInscriptasActionPerformed
        // TODO add your handling code here:
        if (alumnoSeleccionado == null) {
            return;
        }
        btnDesinscribir.setEnabled(false);
        btnInscribir.setEnabled(true);
        lblMensaje.setText("Seleccione una materia para Inscribirse.");
        lblMensaje.setVisible(true);
        VistaPrincipal.cargarTablaMaterias(materiasNoInscriptas, tblMateriasActivas);
    }//GEN-LAST:event_rbtnNoInscriptasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesinscribir;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<String> cboxAlumnosActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.ButtonGroup rbgInscriptas;
    private javax.swing.JRadioButton rbtnInscriptas;
    private javax.swing.JRadioButton rbtnNoInscriptas;
    private javax.swing.JTable tblMateriasActivas;
    // End of variables declaration//GEN-END:variables
}
