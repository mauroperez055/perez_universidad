
package vista;

import com.toedter.calendar.JDateChooser;
import control.AlumnoData;
import control.Conexion;
import control.CursadaData;
import control.MateriaData;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

public class VistaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPrincipal.class.getName());
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private CursadaData cursadaData;
    private Conexion conexion;

    public VistaPrincipal() {
        initComponents();
        conexion = new Conexion("jdbc:mysql://localhost/perezmauro_universidad", "root", "");
        alumnoData = new AlumnoData(conexion);
        materiaData = new MateriaData(conexion);
        cursadaData = new CursadaData(conexion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuSalir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCargarAlumno = new javax.swing.JMenuItem();
        mnuInscribir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuCargarMateria = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuListarAlu = new javax.swing.JMenuItem();
        mnuListarMat = new javax.swing.JMenuItem();
        mnuAluPorMat = new javax.swing.JMenuItem();
        mnuMatPorAlu = new javax.swing.JMenuItem();
        mnuMarcarAsist = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión ULP");
        setLocation(new java.awt.Point(350, 150));
        setPreferredSize(new java.awt.Dimension(784, 600));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        mnuSalir.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuSalir.add(jMenuItem1);

        jMenuBar1.add(mnuSalir);

        jMenu2.setText("Alumno");

        mnuCargarAlumno.setText("Gestión de Alumno");
        mnuCargarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargarAlumnoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCargarAlumno);

        mnuInscribir.setText("Gestión de Inscripción");
        mnuInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInscribirActionPerformed(evt);
            }
        });
        jMenu2.add(mnuInscribir);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Materia");

        mnuCargarMateria.setText("Gestión de Materia");
        mnuCargarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargarMateriaActionPerformed(evt);
            }
        });
        jMenu3.add(mnuCargarMateria);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        mnuListarAlu.setText("Listar Alumnos ");
        mnuListarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarAluActionPerformed(evt);
            }
        });
        jMenu4.add(mnuListarAlu);

        mnuListarMat.setText("Listar Materias");
        mnuListarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarMatActionPerformed(evt);
            }
        });
        jMenu4.add(mnuListarMat);

        mnuAluPorMat.setText("Alumnos por Materia");
        mnuAluPorMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAluPorMatActionPerformed(evt);
            }
        });
        jMenu4.add(mnuAluPorMat);

        mnuMatPorAlu.setText("Cargar Nota ");
        mnuMatPorAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMatPorAluActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMatPorAlu);

        mnuMarcarAsist.setText("Marcar Asistencia");
        mnuMarcarAsist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcarAsistActionPerformed(evt);
            }
        });
        jMenu4.add(mnuMarcarAsist);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCargarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCargarAlumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAlumno formAlumno = new VistaAlumno(alumnoData);
        formAlumno.setVisible(true);
        escritorio.add(formAlumno);
        formAlumno.moveToFront();
    }//GEN-LAST:event_mnuCargarAlumnoActionPerformed

    private void mnuListarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarAluActionPerformed
        try {
            // TODO add your handling code here:
            escritorio.removeAll();
            escritorio.repaint();
            VistaListarAlumnos listarAlumnos = new VistaListarAlumnos(alumnoData);
            listarAlumnos.setVisible(true);
            escritorio.add(listarAlumnos);
            listarAlumnos.moveToFront();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la vista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_mnuListarAluActionPerformed

    private void mnuListarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarMatActionPerformed
        try {
            // TODO add your handling code here:
            escritorio.removeAll();
            escritorio.repaint();
            VistaListarMaterias listarMaterias = new VistaListarMaterias(materiaData);
            listarMaterias.setVisible(true);
            escritorio.add(listarMaterias);
            listarMaterias.moveToFront();
        } catch (SQLException ex) {
            System.getLogger(VistaPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_mnuListarMatActionPerformed

    private void mnuInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInscribirActionPerformed
        // TODO add your handling code here:
        try {
            escritorio.removeAll();
            escritorio.repaint();
            VistaCursada vistaCursada = new VistaCursada(alumnoData, materiaData, cursadaData);
            vistaCursada.setVisible(true);
            escritorio.add(vistaCursada);
            vistaCursada.moveToFront();
        } catch (SQLException ex) {
            System.getLogger(VistaPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_mnuInscribirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuAluPorMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAluPorMatActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAluPorMat vistaAluPorMat;
        try {
            vistaAluPorMat = new VistaAluPorMat(cursadaData, materiaData);
            vistaAluPorMat.setVisible(true);
            escritorio.add(vistaAluPorMat);
            vistaAluPorMat.moveToFront();
        } catch (SQLException ex) {
            System.getLogger(VistaPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_mnuAluPorMatActionPerformed

    private void mnuMatPorAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMatPorAluActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        try {
            VistaMatPorAlu vistaMatPorAlu = new VistaMatPorAlu(alumnoData, materiaData, cursadaData);
            vistaMatPorAlu.setVisible(true);
            escritorio.add(vistaMatPorAlu);
            vistaMatPorAlu.moveToFront();
        } catch (SQLException ex) {
            System.getLogger(VistaPrincipal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_mnuMatPorAluActionPerformed

    private void mnuCargarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCargarMateriaActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            escritorio.removeAll();
            escritorio.repaint();
            VistaMateria formMateria = new VistaMateria(materiaData, cursadaData);
            formMateria.setVisible(true);
            escritorio.add(formMateria);
            formMateria.moveToFront();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la vista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_mnuCargarMateriaActionPerformed

    private void mnuMarcarAsistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcarAsistActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            escritorio.removeAll();
            escritorio.repaint();
            VistaMarcarAsistencia formAsistencia = new VistaMarcarAsistencia(cursadaData, alumnoData, materiaData);
            formAsistencia.setVisible(true);
            escritorio.add(formAsistencia);
            formAsistencia.moveToFront();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la vista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_mnuMarcarAsistActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VistaPrincipal().setVisible(true));
    }
    
    public static void validarEnteros(java.awt.event.KeyEvent evt, JTextField jText) {
        char caracter = evt.getKeyChar();

        if (!Character.isDigit(caracter)) {
            evt.consume();
        }
    }
    
    public static void desActivarCampos(JPanel panel, boolean valor) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField 
                || comp instanceof JComboBox 
                || comp instanceof JCheckBox) {
            comp.setEnabled(valor);
            }
        }
    }
    
    public static boolean validarCamposVacios(JPanel jPanel) {
        
        for (int i = 0; i < jPanel.getComponents().length; i++) {
            
            if (jPanel.getComponents()[i] instanceof JTextField) {
                JTextField caja = (JTextField) jPanel.getComponents()[i];
                if (caja.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Atención!", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                
            }
            
            if (jPanel.getComponents()[i] instanceof JComboBox) {
                JComboBox combo = (JComboBox) jPanel.getComponents()[i];
                if (combo.getSelectedItem() == null || !combo.isEnabled() || combo.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una cateegoría.", "Atención!", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }

        }
        return true;
    }
    
    public static void limpiarCampos(JPanel  jPanel, JTextField txtBuscar) {
        JComboBox combo = null;
        for (int i = 0; i < jPanel.getComponents().length; i++) {
            if (jPanel.getComponents()[i] instanceof JTextField) {
                JTextField caja = (JTextField) jPanel.getComponents()[i];
                caja.setText("");
            }
            
            if (jPanel.getComponents()[i] instanceof JCheckBox) {
                JCheckBox check = (JCheckBox) jPanel.getComponents()[i];
                check.setSelected(false);
            }
            
            if (jPanel.getComponents()[i] instanceof JDateChooser) {
                JDateChooser date = (JDateChooser) jPanel.getComponents()[i];
                date.getDateEditor().setDate(null);
            }
            
            txtBuscar.setText("");

        }
    }
    
    public static void borraFilasTabla(DefaultTableModel modelo) {
        int filas = modelo.getRowCount() -1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public static void cargarTablaAlumnos(ArrayList<Alumno> alumnos, JTable jTable) {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        borraFilasTabla(modelo);
        for (Alumno alu : alumnos) {
            modelo.addRow(new Object[] {
                alu.getIdAlumno(),
                alu.getDni(),
                alu.getApellido(),
                alu.getNombre(),
                alu.getFechaNac(),
                alu.isActivo()
            });
        }
        
    }
    
    public static void cargarTablaMaterias(ArrayList<Materia> materias, JTable jTable) {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        borraFilasTabla(modelo);
        
        for (Materia mat : materias) {
            modelo.addRow(new Object[] {
                mat.getIdMateria(),
                mat.getNombre(),
                mat.isActivo()
            });
        }
        
    }
    
    public static void cargarTblMatConNota(ArrayList<Cursada> cursadasRegistradas, JTable jTable) {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        borraFilasTabla(modelo);
        
        for (Cursada curs : cursadasRegistradas) {
            modelo.addRow(new Object[] {
                curs.getMateria().getIdMateria(),
                curs.getMateria().getNombre(),
                curs.getAsist(),
                curs.getNota(),
                curs.getAnio()
            });
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnuAluPorMat;
    private javax.swing.JMenuItem mnuCargarAlumno;
    private javax.swing.JMenuItem mnuCargarMateria;
    private javax.swing.JMenuItem mnuInscribir;
    private javax.swing.JMenuItem mnuListarAlu;
    private javax.swing.JMenuItem mnuListarMat;
    private javax.swing.JMenuItem mnuMarcarAsist;
    private javax.swing.JMenuItem mnuMatPorAlu;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables
}
