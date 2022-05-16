/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.upv.poo.ui;


import edu.upv.poo.App;
import edu.upv.poo.dataaccess.LibroInventarioV;
import edu.upv.poo.dataaccess.LibroInventarioVDbDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class LibroInventarioList extends javax.swing.JFrame {
    
    LibroInventarioV[] inventarioVs = null;
    
    /**
     * Creates new form LibroInventarioList
     * 
     */
    
    public LibroInventarioList() {
        initComponents();
        try(Connection connection = App.getConnection()){
            LibroInventarioVDbDao lidbdao = new LibroInventarioVDbDao(connection);
            ArrayList<LibroInventarioV> libroInventarioVRepository = lidbdao.getByLibroTitulo("");
            inventarioVs = libroInventarioVRepository.toArray(new LibroInventarioV[0]);
            llenarTablaLibroInventarioV();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        llenarTablaLibroInventarioV();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificarInv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibroInventarioV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnModificarInv.setBackground(new java.awt.Color(25, 118, 210));
        btnModificarInv.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarInv.setText("Modificar Inventario");
        btnModificarInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarInvMouseClicked(evt);
            }
        });
        btnModificarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarInvActionPerformed(evt);
            }
        });

        tblLibroInventarioV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo de recurso", "Titulo de libro", "Editorial", "Autores", "Estado", "Disponbile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLibroInventarioV);

        jLabel1.setText("Título del libro para buscar en el inventario: ");

        btnBuscar.setBackground(new java.awt.Color(25, 118, 210));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTitulo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarInvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarInvMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String titulo = txtTitulo.getText();
        if (titulo != ""){
            try (Connection connection = App.getConnection()){
                LibroInventarioVDbDao libroInventarioVDao = new LibroInventarioVDbDao(connection);
                try{
                    ArrayList<LibroInventarioV> libroInventarioVRepository = libroInventarioVDao.getByLibroTitulo(titulo);
                    inventarioVs = libroInventarioVRepository.toArray(new LibroInventarioV[0]);
                    llenarTablaLibroInventarioV();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
     /**
     * 
     * Overloading del método buscar
     * 
     */
    private void btnBuscarActionPerformed() {
        String titulo = txtTitulo.getText();
        if (titulo != ""){
            try (Connection connection = App.getConnection()){
                LibroInventarioVDbDao libroInventarioVDao = new LibroInventarioVDbDao(connection);
                try{
                    ArrayList<LibroInventarioV> libroInventarioVRepository = libroInventarioVDao.getByLibroTitulo(titulo);
                    inventarioVs = libroInventarioVRepository.toArray(new LibroInventarioV[0]);
                    llenarTablaLibroInventarioV();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
                }
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 
        
    private void btnModificarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarInvActionPerformed
        int ix = tblLibroInventarioV.getSelectedRow();
        if(ix == -1)return;
        LibroInventarioForm form = new LibroInventarioForm(inventarioVs[ix]);
        form.setLibroInventarioListener(this::editarInventario);
        form.setVisible(true);
    }//GEN-LAST:event_btnModificarInvActionPerformed
    
    
    private void llenarTablaLibroInventarioV(){
        if (inventarioVs == null) return;
        
        DefaultTableModel model = (DefaultTableModel)tblLibroInventarioV.getModel();
        
        while (model.getRowCount() > 0) model.removeRow(0);
        for (int i = 0; i < inventarioVs.length; i++) {
            model.insertRow(i, getRowOf(inventarioVs[i]));
        }
    }
    
    private Object[] getRowOf(LibroInventarioV li) {
        return new Object[] {
            li.getTipoRecursoNombre(),
            li.getTitulo(),
            li.getEditorialNombre(),
            li.getAutores(),
            li.getEstado(),
            li.isDisponible()
        };
    }
    
    private void editarInventario(){
        btnBuscarActionPerformed();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificarInv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLibroInventarioV;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}