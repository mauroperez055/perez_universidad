
package vista;

import control.AlumnoData;
import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

public class VistaMatPorAlu extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private CursadaData cursadaData;
    private ArrayList<Alumno> alumnosActivos;
    private Alumno alumnoSeleccionado;
    private Cursada cursada;
    private ArrayList<Materia> materiasActivas; 
    private DefaultTableModel modelo;
    private ArrayList<Cursada> cursadasRegistradas; 
    
    public VistaMatPorAlu(AlumnoData alumnoData, MateriaData materiaData, CursadaData cursadaData) throws SQLException {
        initComponents();
        this.alumnoData = alumnoData;
        this.materiaData = materiaData;
        this.cursadaData = cursadaData;
        this.alumnosActivos = alumnoData.listarActivos();
        this.modelo = (DefaultTableModel) tblMateriasActivas.getModel();
        
        VistaPrincipal.borraFilasTabla(modelo);
        
        for (Alumno alu : alumnosActivos) {
            cboAlumnosActivos.addItem(alu.getApellido() + " " + alu.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboAlumnosActivos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriasActivas = new javax.swing.JTable();
        btnGuardarNota = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cargar Nota Final ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        cboAlumnosActivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        cboAlumnosActivos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAlumnosActivosItemStateChanged(evt);
            }
        });

        tblMateriasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID MATERIA", "NOMBRE MATERIA", "ASISTENCIA (%)", "NOTA FINAL", "AÑO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMateriasActivas);

        btnGuardarNota.setText("Guardar Nota");
        btnGuardarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnGuardarNota)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAlumnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardarNota)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboAlumnosActivosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAlumnosActivosItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
                return;
        }

        String itemSeleccionado = (String) cboAlumnosActivos.getSelectedItem();
        alumnoSeleccionado = null;


        tblMateriasActivas.clearSelection();
        VistaPrincipal.borraFilasTabla(modelo);

        if (itemSeleccionado.equals("--") || itemSeleccionado == null) {
            alumnoSeleccionado = null;
            tblMateriasActivas.clearSelection();

            VistaPrincipal.borraFilasTabla(modelo);

            return;
        }

        for (Alumno alu : alumnosActivos) {
            String nombreCompleto = alu.getApellido() + " " + alu.getNombre();
            if (nombreCompleto.equals(itemSeleccionado)) {
                    alumnoSeleccionado = alu; 
                    break;
            }
        }
        
        if (alumnoSeleccionado == null) {
            return;
        }

        VistaPrincipal.borraFilasTabla(modelo);
            
        try {
            int idAlumno = alumnoSeleccionado.getIdAlumno();
            cursadasRegistradas = cursadaData.cursadasRegistradas(idAlumno);
            VistaPrincipal.cargarTblMatConNota(cursadasRegistradas, tblMateriasActivas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener las materias del alumno.", "Atención", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return;
        }
    }//GEN-LAST:event_cboAlumnosActivosItemStateChanged

    private void btnGuardarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNotaActionPerformed
        // TODO add your handling code here:
        int fila = tblMateriasActivas.getSelectedRow();
        Year anio = Year.of(Integer.parseInt(tblMateriasActivas.getValueAt(fila, 4).toString()));
        double nota = Double.parseDouble(tblMateriasActivas.getValueAt(fila, 3).toString());
        int idMateria = Integer.parseInt(tblMateriasActivas.getValueAt(fila, 0).toString());
        
        int idAlumno = alumnoSeleccionado.getIdAlumno();
        try {
            int idCursada = cursadaData.buscarIdCursada(idAlumno, idMateria, anio);
            System.out.println("cursada id: " + idCursada);
            
            cursadaData.cargarNota(idCursada, nota);
            JOptionPane.showMessageDialog(this, "Nota guardada correctamente!", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la nota.", "Atención", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnGuardarNotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarNota;
    private javax.swing.JComboBox<String> cboAlumnosActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMateriasActivas;
    // End of variables declaration//GEN-END:variables
}
