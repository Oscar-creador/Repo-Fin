package edu.upv.poo.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.util.ArrayList;

/**
 * Implementación del Data Access Object de Libro.
 * @author luisroberto
 */
public class LibroDbDao implements LibroDao {

    private final Connection connection;
    
    
    public LibroDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Libro getById(int libroId) throws Exception {
        Libro i = null;
        String sql = "SELECT * FROM libros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroId);
            try (ResultSet r = stmt.executeQuery()) {
                if (r.next()) i = toObj(r);
            }
        }
        return i;
    }

    @Override
    public int insert(Libro i) throws Exception {
        String sql = "CALL insert_libro(?, ?, ?, ?, ?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, i.getTitulo());
            stmt.setInt(2, i.getTipoRecursoId());
            stmt.setString(3, i.getEdicion());
            stmt.setObject(4, i.getEditorialId());  // NOTA: Se maneja así porque es un int que puede ser null.
            stmt.setString(5, i.getAutores());
            stmt.setString(6, i.getIsbn());
            stmt.setBoolean(7, i.isActivo());
            try (ResultSet r = stmt.executeQuery()) {
                r.next();
                i.setId(r.getInt("id"));
            }
        }
        return i.getId();
    }

    @Override
    public void update(Libro i) throws Exception {
        String sql = "CALL update_libro(?, ?, ?, ?, ?, ?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, i.getId());
            stmt.setString(2, i.getTitulo());
            stmt.setInt(3, i.getTipoRecursoId());
            stmt.setString(4, i.getEdicion());
            stmt.setObject(5, i.getEditorialId());  // NOTA: Se maneja así porque es un int que puede ser null.
            stmt.setString(6, i.getAutores());
            stmt.setString(7, i.getIsbn());
            stmt.setBoolean(8, i.isActivo());
            stmt.execute();
        }
    }
    
    private Libro toObj(ResultSet r) throws Exception {
        Libro i = new Libro();
        i.setId(r.getInt("id"));
        i.setTitulo(r.getString("titulo"));
        i.setTipoRecursoId(r.getInt("tipo_recurso_id"));
        i.setEdicion(r.getString("edicion"));
        i.setEditorialId((Integer)r.getObject("editorial_id")); // NOTA: Se maneja así porque es un int que puede ser null.
        i.setAutores(r.getString("autores"));
        i.setIsbn(r.getString("isbn"));
        i.setActivo(r.getBoolean("activo"));
        return i;
    }

    @Override
    public Libro[] getAll() throws Exception {
        ArrayList<Libro> l = new ArrayList<>();
        String sql = "SELECT * FROM libros ORDER BY id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new Libro[] {});
    }
}
