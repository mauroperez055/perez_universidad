
package vista;

import control.MateriaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Materia;
import java.sql.SQLException;

public class VistaListarMaterias extends javax.swing.JInternalFrame {

    private MateriaData materiaData;
    private ArrayList<Materia> materias;
    
    public VistaListarMaterias(MateriaData materiaData) throws SQLException {
        initComponents();
        this.materiaData = materiaData;
        this.materias = materiaData.listarMaterias();
        VistaPrincipal.cargarTablaMaterias(materias, tblMaterias);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnMaterias = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        rbtnTodas = new javax.swing.JRadioButton();
        rbtnActivas = new javax.swing.JRadioButton();
        rbtnInactivas = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Listado de Materias");

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "ACTIVA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMaterias);

        rbtnMaterias.add(rbtnTodas);
        rbtnTodas.setText("Todas");
        rbtnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodasActionPerformed(evt);
            }
        });

        rbtnMaterias.add(rbtnActivas);
        rbtnActivas.setText("Activas");
        rbtnActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivasActionPerformed(evt);
            }
        });

        rbtnMaterias.add(rbtnInactivas);
        rbtnInactivas.setText("Inactivas");
        rbtnInactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInactivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(rbtnTodas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnActivas)
                .addGap(122, 122, 122)
                .addComponent(rbtnInactivas)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTodas)
                    .addComponent(rbtnActivas)
                    .addComponent(rbtnInactivas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodasActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            materias = materiaData.listarMaterias();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar las materias.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VistaPrincipal.cargarTablaMaterias(materias, tblMaterias);
    }//GEN-LAST:event_rbtnTodasActionPerformed

    private void rbtnActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivasActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            materias = materiaData.listarMateriasActivas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar las materias.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VistaPrincipal.cargarTablaMaterias(materias, tblMaterias);
    }//GEN-LAST:event_rbtnActivasActionPerformed

    private void rbtnInactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInactivasActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            materias = materiaData.listarMateriasInactivas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar las materias.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        VistaPrincipal.cargarTablaMaterias(materias, tblMaterias);
    }//GEN-LAST:event_rbtnInactivasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnActivas;
    private javax.swing.JRadioButton rbtnInactivas;
    private javax.swing.ButtonGroup rbtnMaterias;
    private javax.swing.JRadioButton rbtnTodas;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables
}
