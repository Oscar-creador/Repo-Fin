package edu.upv.poo.dataaccess;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación del Data Access Object de LibroInventario, que representa el
 * view de libros_inventario_existencia que son los libros con la cantidad de
 * estos disponibles en el inventario.
 * @author luisroberto
 */
public class LibroInventarioExistenciaVDbDao 
        implements LibroInventarioExistenciaVDao {
    
    private final Connection connection;
    
    public LibroInventarioExistenciaVDbDao (Connection connection) {
        this.connection = connection;
    }

    @Override
    public LibroInventarioExistenciaV getById(int libroId) throws Exception {
        LibroInventarioExistenciaV libroInvEx = null;
        String sql = "SELECT * FROM libros_inventario_existencia_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroId);
            try (ResultSet r = stmt.executeQuery()) {
                libroInvEx = r.next() ? toObj(r) : null;
            }
        } catch(SQLException ex){
            System.out.println("ERROR SQL: "+ ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }
        return libroInvEx;
    }

    @Override
    public LibroInventarioExistenciaV[] searchByTitulo(String titulo) throws Exception {

        ArrayList<LibroInventarioExistenciaV> l = new ArrayList<>();
        String sql = "SELECT * FROM libros_inventario_existencia_v WHERE titulo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(this.toObj(r));
            }
        } catch (Exception ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }
        return l.toArray(new LibroInventarioExistenciaV[] {});
    }
    
    private LibroInventarioExistenciaV toObj(ResultSet r) throws Exception {
        LibroInventarioExistenciaV libroInvEx = new LibroInventarioExistenciaV();
        libroInvEx.setId(r.getInt("id"));
        libroInvEx.setTitulo(r.getString("titulo"));
        libroInvEx.setTipoRecursoId(r.getInt("tipo_recurso_id"));
        libroInvEx.setTipoRecursoNombre(r.getString("tipo_recurso_nombre"));
        libroInvEx.setTipoRecursoActivo(r.getBoolean("tipo_recurso_activo"));
        libroInvEx.setEdicion(r.getString("edicion"));
        libroInvEx.setEditorialId(r.getInt("editorial_id"));
        libroInvEx.setEditorialNombre(r.getString("editorial_nombre"));
        libroInvEx.setEditorialPais(r.getString("editorial_pais"));
        libroInvEx.setEditorialEmail(r.getString("editorial_emial"));
        libroInvEx.setTipoRecursoActivo(r.getBoolean("editorial_activo"));
        libroInvEx.setAutores(r.getString("autores"));
        libroInvEx.setIsbn(r.getString("isbn"));
        libroInvEx.setActivo(r.getBoolean("activo"));
        libroInvEx.setCantidadEnInventario(r.getInt("cantidad_en_inventario"));
        
        return libroInvEx;
    }

    @Override
    public LibroInventarioExistenciaV[] getAll() throws Exception {
        ArrayList<LibroInventarioExistenciaV> l = new ArrayList<>();
        String sql = "SELECT * FROM libros_inventario_existencia_v ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(this.toObj(r));
            }
        } catch (Exception ex) {
            System.out.println("ERROR: "+ ex.getMessage());
        }
        return l.toArray(new LibroInventarioExistenciaV[] {});
    }
    
}
