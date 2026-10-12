
package vista;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPrincipal.class.getName());

    public VistaPrincipal() {
        initComponents();
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
        mnuMarcarAsist = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuCargarMateria = new javax.swing.JMenuItem();
        mnuCargarNota = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuListarAlu = new javax.swing.JMenuItem();
        mnuListarMat = new javax.swing.JMenuItem();
        mnuAluPorMat = new javax.swing.JMenuItem();
        mnuMatPorAlu = new javax.swing.JMenuItem();

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
            .addGap(0, 503, Short.MAX_VALUE)
        );

        mnuSalir.setText("Archivo");

        jMenuItem1.setText("Salir");
        mnuSalir.add(jMenuItem1);

        jMenuBar1.add(mnuSalir);

        jMenu2.setText("Alumno");

        mnuCargarAlumno.setText("Cargar Alumno");
        mnuCargarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCargarAlumnoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCargarAlumno);

        mnuInscribir.setText("Inscripción a Materia");
        jMenu2.add(mnuInscribir);

        mnuMarcarAsist.setText("Marcar Asistencia");
        jMenu2.add(mnuMarcarAsist);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Materia");

        mnuCargarMateria.setText("Cargar Materia");
        jMenu3.add(mnuCargarMateria);

        mnuCargarNota.setText("Cargar Nota ");
        jMenu3.add(mnuCargarNota);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        mnuListarAlu.setText("Listar Alumnos ");
        jMenu4.add(mnuListarAlu);

        mnuListarMat.setText("Listar Materias");
        jMenu4.add(mnuListarMat);

        mnuAluPorMat.setText("Alumnos por Materia");
        jMenu4.add(mnuAluPorMat);

        mnuMatPorAlu.setText("Materias por Alumno");
        jMenu4.add(mnuMatPorAlu);

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
        VistaAlumno alu = new VistaAlumno();
        alu.setVisible(true);
        escritorio.add(alu);
        alu.moveToFront();
    }//GEN-LAST:event_mnuCargarAlumnoActionPerformed

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
    
    public static void cargarComboBox(JComboBox cboBox) {
        cboBox.removeAllItems();
        cboBox.addItem("");
        
//        for (Categoria cat : Categoria.values()) {
//            cboBox.addItem(cat.name());
//        }
    }
    
//    public static boolean validarCamposVacios(JPanel jPanel, JTextField txtPrecio) {
//        
//        for (int i = 0; i < jPanel.getComponents().length; i++) {
//            
//            if (jPanel.getComponents()[i] instanceof JTextField) {
//                JTextField caja = (JTextField) jPanel.getComponents()[i];
//                if (caja.getText().trim().isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Atención!", JOptionPane.WARNING_MESSAGE);
//                    return false;
//                }
//                
//                if (caja == txtPrecio && !validarPrecio(caja)) {
//                    JOptionPane.showMessageDialog(null, "Debe ingresar un precio válido.", "Atención!", JOptionPane.ERROR_MESSAGE);
//                    txtPrecio.setText("");
//                    return false;
//                }
//            }
//            
//            if (jPanel.getComponents()[i] instanceof JComboBox) {
//                JComboBox combo = (JComboBox) jPanel.getComponents()[i];
//                if (combo.getSelectedItem() == null || !combo.isEnabled() || combo.getSelectedItem().toString().isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Debe seleccionar una cateegoría.", "Atención!", JOptionPane.WARNING_MESSAGE);
//                    return false;
//                }
//            }
//            
//            if (jPanel.getComponents()[i] instanceof JSpinner) {
//                JSpinner spin = (JSpinner) jPanel.getComponents()[i];
//                if ((int) spin.getValue() < 0) {
//                    JOptionPane.showMessageDialog(null, "El stock no puede ser negativo.", "Atención!", JOptionPane.WARNING_MESSAGE);
//                    return false;
//                }
//            }
//
//        }
//        return true;
//    }

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
    private javax.swing.JMenuItem mnuCargarNota;
    private javax.swing.JMenuItem mnuInscribir;
    private javax.swing.JMenuItem mnuListarAlu;
    private javax.swing.JMenuItem mnuListarMat;
    private javax.swing.JMenuItem mnuMarcarAsist;
    private javax.swing.JMenuItem mnuMatPorAlu;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables
}
