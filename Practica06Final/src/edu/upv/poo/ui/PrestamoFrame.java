/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo.ui;


import edu.upv.poo.App;
import edu.upv.poo.DateUtils;
import edu.upv.poo.dataaccess.PrestamoV;
import edu.upv.poo.dataaccess.PrestamoVDbDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class PrestamoFrame extends javax.swing.JFrame {
    
    PrestamoV[] prestamos = null;
    
    /**
     * Creates new form LibroInventarioList
     * 
     */
    
    public PrestamoFrame() {
        initComponents();
        try(Connection connection = App.getConnection()){
            prestamos = App.getPrestamosVDao(connection).getAll();
            llenarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JTextField();
        btnDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregar.setBackground(new java.awt.Color(25, 118, 210));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setActionCommand("");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "id del libro en inventario", "libro id", "titulo del libro", "tipo de recurso del libro", "edicion del libro", "editorial del libro", "autores del libro", "isbn del libro", "estado del libro", "matricula", "nombre del alumno", "apellidos del alumno", "carrera del alumno", "fecha de prestamo", "fecha de devoluci??n", "fecha devuelto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(15).setResizable(false);
            tbl.getColumnModel().getColumn(16).setResizable(false);
        }

        jLabel1.setText("Fecha de devoluci??n :");

        btnBuscar.setBackground(new java.awt.Color(25, 118, 210));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha de pr??stamo:");

        btnDevolver.setBackground(new java.awt.Color(25, 118, 210));
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Date fecha = DateUtils.parseDate(txtTitulo.getText());
        Date fecha1 = DateUtils.parseDate(txtTitulo1.getText());
        if (fecha != null){
            try (Connection connection = App.getConnection()){
                PrestamoVDbDao pvdbdao = new PrestamoVDbDao(connection);
                try{
                    prestamos = pvdbdao.getByFechaPrestamoRango(fecha,fecha1);
                    llenarTabla();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        PrestamoAgregarFrame frame = new PrestamoAgregarFrame(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        PrestamoDevolucionFrame framePrestamoDevolucion = new PrestamoDevolucionFrame();
        framePrestamoDevolucion.setVisible(true);
        framePrestamoDevolucion.setTitle("Prestamos devoluci??n");
    }//GEN-LAST:event_btnDevolverActionPerformed
     /**
     * 
     * Overloading del m??todo buscar
     * 
     */
    private void btnBuscarActionPerformed() {
        Date fecha = DateUtils.parseDate(txtTitulo.getText());
        if (fecha != null){
            try (Connection connection = App.getConnection()){
                PrestamoVDbDao pvdbdao = new PrestamoVDbDao(connection);
                try{
                    prestamos = pvdbdao.getByFechaPrestamoRango(fecha,fecha);
                    llenarTabla();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void llenarTabla(){
        if (prestamos == null) return;
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
        for (int i = 0; i < prestamos.length; i++) {
            model.insertRow(i, getRowOf(prestamos[i]));
        }
    }
    
    private Object[] getRowOf(PrestamoV p) {
        return new Object[] {
            p.getId(),
            p.getLibroInventarioId(),
            p.getLibroId(),
            p.getLibroTitulo(),
            p.getLibroTipoRecursoNombre(),
            p.getLibroEdicion(),
            p.getLibroEditorialNombre(),
            p.getLibroAutores(),
            p.getLibroIsbn(),
            p.getLibroEstado(),
            p.getAlumnoId(),
            p.getAlumnoNombre(),
            p.getAlumnoApellidos(),
            p.getAlumnoCarreraNombre(),
            p.getFechaPrestamo(),
            p.getFechaDebeDevolver(),
            p.getFechaDevuelto()
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTitulo1;
    // End of variables declaration//GEN-END:variables

}
