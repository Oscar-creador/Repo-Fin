package edu.upv.poo.dataaccess;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author luisroberto
 */
public class LibroInventarioVDbDao implements LibroInventarioVDao {

    private Connection connection;
    
    public LibroInventarioVDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public LibroInventarioV[] getByLibroId(int libroId) throws Exception {
        ArrayList<LibroInventarioV> l = new ArrayList<>();
        String sql = "SELECT * FROM libros_inventario_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroId);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new LibroInventarioV[0]);
    }

    @Override
    public LibroInventarioV getByLibroInventarioId(int libroInventarioId) throws Exception {
        String sql = "SELECT * FROM libros_inventario_v WHERE inventario_id = ?";
        LibroInventarioV l;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroInventarioId);
            try (ResultSet r = stmt.executeQuery()) {
                l = toObj(r);
            }
        }
        
        return l;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<LibroInventarioV> getByLibroTitulo(String libroTitulo) throws Exception {
        String sql = "SELECT * FROM libros_inventario_v WHERE titulo LIKE ?";
        
        LibroInventarioV libroInventarioV = null;
        ArrayList<LibroInventarioV> libroInventarioVs = new ArrayList<>();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,"%"+ libroTitulo+"%");
            try(ResultSet r = stmt.executeQuery()){
                while(r.next()){
                    //System.out.println("JEJEJ");
                    libroInventarioV = toObj(r);
                    libroInventarioVs.add(libroInventarioV);
                    
                } 
            } 
        }
        return libroInventarioVs;
    }
    
    /**
     * Obtiene un objeto de tipo LibroInventarioV a partir del ResultSet.
     * @param r
     * @return
     * @throws Exception 
     */
    private LibroInventarioV toObj(ResultSet r) throws Exception {
        LibroInventarioV i = new LibroInventarioV();
        i.setId(r.getInt("id"));
        i.setInventarioId(r.getInt("inventario_id"));
        i.setTitulo(r.getString("titulo"));
        i.setTipoRecursoId(r.getInt("tipo_recurso_id"));
        i.setTipoRecursoNombre(r.getString("tipo_recurso_nombre"));
        i.setEdicion(r.getString("edicion"));
        i.setEditorialNombre(r.getString("editorial_nombre"));
        i.setEditorialPais(r.getString("editorial_pais"));
        i.setEditorialEmail(r.getString("editorial_emial"));
        i.setAutores(r.getString("autores"));
        i.setIsbn(r.getString("isbn"));
        i.setEstado(r.getString("estado"));
        i.setDisponible(r.getBoolean("disponible"));
        return i;
    }
}
