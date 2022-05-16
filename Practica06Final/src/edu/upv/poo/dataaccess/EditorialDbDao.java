package edu.upv.poo.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class EditorialDbDao implements EditorialDao{
    
    private final Connection connection;
    
    public EditorialDbDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Editorial getById(int editorialId) throws Exception {
        Editorial i = null;
        String sql = "SELECT * FROM editoriales WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, editorialId);
            try (ResultSet r = stmt.executeQuery()) {
                if (r.next()) i = toObj(r);
            }
        }
        return i;
    }

    @Override
    public Editorial[] getAll() throws Exception {
        ArrayList<Editorial> l = new ArrayList<>();
        String sql = "SELECT * FROM editoriales WHERE Activo = 1 ORDER BY nombre";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new Editorial[] {});
    }

    @Override
    public int insert(Editorial i) throws Exception {
        // Operación de insert a DB.
        String sql =  // SQL command de insert.
                "INSERT INTO editoriales (nombre, pais, email, activo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {  // peraración de la operación
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getPais());
            stmt.setString(3, i.getEmail());
            stmt.setBoolean(4, i.isActivo());  
            stmt.execute();  
        }

        sql = "SELECT last_insert_id() id";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                r.next();
                i.setId(r.getInt("id"));
            }
        }
        return i.getId();
    }

    @Override
    public void update(Editorial i) throws Exception {
        String sql = "UPDATE editoriales SET nombre = ?, pais = ?, email = ?, activo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getPais());
            stmt.setString(3, i.getEmail());
            stmt.setBoolean(4, i.isActivo());
            stmt.setInt(5, i.getId());
            stmt.execute();
        }
    }
    
    private Editorial toObj(ResultSet r) throws Exception {
        Editorial i = new Editorial();
        i.setId(r.getInt("id"));
        i.setNombre(r.getString("nombre"));
        i.setPais(r.getString("pais"));
        i.setEmail(r.getString("email"));
        i.setActivo(r.getBoolean("activo"));

        return i;
    }
    
}
