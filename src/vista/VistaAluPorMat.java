
package vista;

import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Materia;

public class VistaAluPorMat extends javax.swing.JInternalFrame {

    private ArrayList<Materia> materiasActivas;
    private ArrayList<Alumno> alumnosPorMat;
    private MateriaData materiaData;
    private DefaultTableModel modelo;
    private Materia materiaSeleccionada;
    private CursadaData cursadaData;
    private ArrayList<Alumno> alumnosMateria;
    
    public VistaAluPorMat(CursadaData cursadaData, MateriaData materiaData) throws SQLException {
        initComponents();
        this.cursadaData = cursadaData;
        this.materiasActivas = materiaData.listarMateriasActivas();
        this.modelo = (DefaultTableModel) tblAlumnosActivos.getModel();
        
        VistaPrincipal.borraFilasTabla(modelo);
        
        for (Materia mat : materiasActivas) {
            cboMaterias.addItem(mat.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboMaterias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnosActivos = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Alumnos Por Materia");

        cboMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        cboMaterias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMateriasItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione una materia:");

        tblAlumnosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID ALUMNO", "DNI", "APELLIDO", "NOMBRE", "FECHA DE NAC", "ACTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlumnosActivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMateriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMateriasItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
                return;
        }

        String itemSeleccionado = (String) cboMaterias.getSelectedItem();
        materiaSeleccionada = null;

        tblAlumnosActivos.clearSelection();
        VistaPrincipal.borraFilasTabla(modelo);

        if (itemSeleccionado.equals("--") || itemSeleccionado == null) {
            materiaSeleccionada = null;

            VistaPrincipal.borraFilasTabla(modelo);

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

        VistaPrincipal.borraFilasTabla(modelo);
            
        try {
            int idMateria = materiaSeleccionada.getIdMateria();
            alumnosMateria = cursadaData.alumnosPorMat(idMateria);
            VistaPrincipal.cargarTablaAlumnos(alumnosMateria, tblAlumnosActivos);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener los alumnos de la materia.", "Atención", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return;
        }
    }//GEN-LAST:event_cboMateriasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlumnosActivos;
    // End of variables declaration//GEN-END:variables
}
