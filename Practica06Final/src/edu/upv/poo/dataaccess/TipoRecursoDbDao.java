package edu.upv.poo.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class TipoRecursoDbDao implements TipoRecursoDao{
    
    private final Connection connection;
    
    public TipoRecursoDbDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public TipoRecurso[] getAll() throws Exception {
        ArrayList<TipoRecurso> l = new ArrayList<>();
        String sql = "SELECT * FROM tipos_recursos WHERE Activo = 1 ORDER BY nombre";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new TipoRecurso[] {});
    }
    
    private TipoRecurso toObj(ResultSet r) throws Exception {
        TipoRecurso i = new TipoRecurso();
        i.setId(r.getInt("id"));
        i.setNombre(r.getString("nombre"));
        i.setActivo(r.getBoolean("activo"));
        return i;
    }

    @Override
    public TipoRecurso getById(int tipoId) throws Exception {
        TipoRecurso i = null;
        String sql = "SELECT * FROM tipos_recursos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, tipoId);
            try (ResultSet r = stmt.executeQuery()) {
                if (r.next()) i = toObj(r);
            }
        }
        return i;
    }
    
}
