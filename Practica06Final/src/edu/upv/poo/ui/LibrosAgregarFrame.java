/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upv.poo.ui;

import edu.upv.poo.App;
import edu.upv.poo.dataaccess.Editorial;
import edu.upv.poo.dataaccess.EditorialDbDao;
import edu.upv.poo.dataaccess.Libro;
import edu.upv.poo.dataaccess.LibroDbDao;
import edu.upv.poo.dataaccess.TipoRecurso;
import edu.upv.poo.dataaccess.TipoRecursoDbDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class LibrosAgregarFrame extends javax.swing.JFrame {
    

    private LibrosAgregarFrame.LibroGuardadoListener libroGuardadoListener;
    public static final String ACCION_ALTA = "Alta";
    public static final String ACCION_EDITAR = "Editar";
    private final String accion;
    private Libro libro;
    

    /**
     * Creates new form LibrosAgregarFrame
     */
    public LibrosAgregarFrame() {
        initComponents();
        accion = null;
    }
    
    public LibrosAgregarFrame(Libro libro) {
        initComponents();
        //agregar datos a los combobox
        this.llenarComboBoxs();
        accion = libro == null ? ACCION_ALTA : ACCION_EDITAR;
        this.libro = libro;
        if(accion.equals(ACCION_EDITAR)){
            this.txt_titulo.setText(libro.getTitulo());
            this.txt_edicion.setText(libro.getEdicion());
            this.txt_autores.setText(libro.getAutores());
            this.txt_isbn.setText(libro.getIsbn());
            Editorial e = null;
            TipoRecurso tr = null;
            try(Connection connection1 = App.getConnection()){
                e = App.getEditorialDao(connection1).getById(libro.getEditorialId());
                tr = App.getTipoRecursoDao(connection1).getById(libro.getTipoRecursoId());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            }
            int size = cbx_editorial.getItemCount();
            for (int i = 0; i < size; i++) {
                Object item = cbx_editorial.getItemAt(i);
                if(item == e){this.cbx_editorial.setSelectedItem(item);break;}
            }
            
            size = cbx_tipoRecurso.getItemCount();
            for (int i = 0; i < size; i++) {
                Object item = cbx_tipoRecurso.getItemAt(i);
                if(item == tr){this.cbx_tipoRecurso.setSelectedItem(item);break;}
            }
            
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

        lbl_editorialId1 = new javax.swing.JLabel();
        txt_1 = new javax.swing.JTextField();
        txt_3 = new javax.swing.JTextField();
        lbl_titulo = new javax.swing.JLabel();
        lbl_tipoRecursoId = new javax.swing.JLabel();
        lbl_editorialId = new javax.swing.JLabel();
        lbl_edicion = new javax.swing.JLabel();
        lbl_autores = new javax.swing.JLabel();
        lbl_isbn = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        txt_edicion = new javax.swing.JTextField();
        txt_isbn = new javax.swing.JTextField();
        txt_autores = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        cbx_tipoRecurso = new javax.swing.JComboBox<>();
        cbx_editorial = new javax.swing.JComboBox<>();

        lbl_editorialId1.setText("Editorial Id:");

        txt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_1ActionPerformed(evt);
            }
        });

        txt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_titulo.setText("Titulo:");

        lbl_tipoRecursoId.setText("Tipo Recurso:");

        lbl_editorialId.setText("Editorial:");

        lbl_edicion.setText("Edici??n:");

        lbl_autores.setText("Autores:");

        lbl_isbn.setText("ISBN:");

        txt_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tituloActionPerformed(evt);
            }
        });

        txt_edicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edicionActionPerformed(evt);
            }
        });

        txt_isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_isbnActionPerformed(evt);
            }
        });

        txt_autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_autoresActionPerformed(evt);
            }
        });

        btn_guardar.setBackground(new java.awt.Color(25, 118, 210));
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        cbx_tipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoRecursoActionPerformed(evt);
            }
        });

        cbx_editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_editorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tipoRecursoId)
                            .addComponent(lbl_edicion)
                            .addComponent(lbl_editorialId)
                            .addComponent(lbl_autores)
                            .addComponent(lbl_isbn)
                            .addComponent(lbl_titulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(txt_isbn, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(txt_edicion, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(txt_autores, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(cbx_tipoRecurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbx_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_tipoRecursoId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbx_tipoRecurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_edicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_edicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_editorialId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbx_editorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_autores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_autores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_1ActionPerformed

    private void txt_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tituloActionPerformed

    private void txt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_3ActionPerformed

    private void txt_edicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_edicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_edicionActionPerformed

    private void txt_isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_isbnActionPerformed

    private void txt_autoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_autoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_autoresActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(accion.equals(ACCION_ALTA))libro = new Libro();
        libro.setTitulo(this.txt_titulo.getText());
        TipoRecurso tipoRecurso = (TipoRecurso) this.cbx_tipoRecurso.getSelectedItem();//cast
        libro.setTipoRecursoId(tipoRecurso.getId());
        libro.setEdicion(this.txt_edicion.getText());
        Editorial editorial = (Editorial) this.cbx_editorial.getSelectedItem();//cast
        libro.setEditorialId(editorial.getId());
        libro.setAutores(this.txt_autores.getText());
        libro.setIsbn(this.txt_isbn.getText());
        libro.setActivo(true);
        try (Connection connection = App.getConnection()) {
            LibroDbDao libroDbDao = new LibroDbDao(connection);
        
            if (getLibroGuardadoListener() != null) {
                getLibroGuardadoListener().libroGuardado(accion, libro);
            }
            if (accion.equals(ACCION_ALTA))
                libroDbDao.insert(libro);
            if (accion.equals(ACCION_EDITAR))
                libroDbDao.update(libro);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Guardado con exito. " ,"Exito!", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void cbx_tipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipoRecursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_tipoRecursoActionPerformed

    private void cbx_editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_editorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_editorialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<Editorial> cbx_editorial;
    private javax.swing.JComboBox<TipoRecurso> cbx_tipoRecurso;
    private javax.swing.JLabel lbl_autores;
    private javax.swing.JLabel lbl_edicion;
    private javax.swing.JLabel lbl_editorialId;
    private javax.swing.JLabel lbl_editorialId1;
    private javax.swing.JLabel lbl_isbn;
    private javax.swing.JLabel lbl_tipoRecursoId;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_1;
    private javax.swing.JTextField txt_3;
    private javax.swing.JTextField txt_autores;
    private javax.swing.JTextField txt_edicion;
    private javax.swing.JTextField txt_isbn;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables

    private void llenarComboBoxs() {
        ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
        
        ArrayList<TipoRecurso> tipoRecursos = new ArrayList<TipoRecurso>();
        
        try(Connection connection = App.getConnection()) {
            EditorialDbDao editorialDbDao = new EditorialDbDao(connection);
            TipoRecursoDbDao tipoRecursoDbDao = new TipoRecursoDbDao(connection);
            Editorial editorialesA[] = editorialDbDao.getAll();
            for(Editorial editorial : editorialesA){
                editoriales.add(editorial);
            }
            TipoRecurso tipoRecursosA[] = tipoRecursoDbDao.getAll();
            for(TipoRecurso tipoRecurso : tipoRecursosA){
                tipoRecursos.add(tipoRecurso);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        for(Editorial editorial :editoriales){
            this.cbx_editorial.addItem(editorial);
        }
        for(TipoRecurso tipoRecurso : tipoRecursos){
            this.cbx_tipoRecurso.addItem(tipoRecurso);
        }
       
        
    }
    
    public void setLibroGuardadoListener(LibrosAgregarFrame.LibroGuardadoListener l) {
        this.libroGuardadoListener = l;
    }
    
    public LibrosAgregarFrame.LibroGuardadoListener getLibroGuardadoListener() {
        return libroGuardadoListener;
    }
        
    public interface LibroGuardadoListener {
        void libroGuardado(String accion, Libro libroGuardado);        
    }
}
