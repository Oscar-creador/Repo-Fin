package edu.upv.poo.dataaccess;

import java.sql.*;
import java.util.ArrayList;

/**
 * Implementa la funcionalidad de data access para Carreras.
 * @author luisroberto
 */
public class CarreraDbDao implements CarreraDao {

    private final Connection connection;
    
    /**
     * Inicializa una nueva instancia de CarreraDbDao.
     * @param connection Objeto connection a usar para la DB.
     */
    public CarreraDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Carrera getById(int carreraId) throws Exception {
        String sql = "SELECT * FROM carreras WHERE id = ?";
        Carrera i = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // CallableStatement sp = connection.prepareCall(sql); // stored proc
            stmt.setInt(1, carreraId);
            try (ResultSet r = stmt.executeQuery()) {
                i = r.next() ? new Carrera(r) : null;
            }
        }
        return i;
    }

    @Override
    public Carrera[] getAll() throws Exception {
        ArrayList<Carrera> l = new ArrayList<>();
        String sql = "SELECT * FROM carreras WHERE Activo = 1 ORDER BY nombre";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(new Carrera(r));
            }
        }
        return l.toArray(new Carrera[] {});
    }

    @Override
    public int insert(Carrera i) throws Exception {
        
        // Operación de insert a DB.
        String sql =  // SQL command de insert.
                "INSERT INTO carreras (nombre, activo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {  // peraración de la operación
            stmt.setString(1, i.getNombre());  // establecemos 1er parametro marcado con '?'
            stmt.setBoolean(2, i.isActivo());  // establecemos 2do param marcado con '?'
            stmt.execute();  // ejecución del comando en DB.
        }
        // end operación de insert.
        
        // operación de obtener el id del registro insertado.
        sql = "SELECT last_insert_id() id";  // sql command par obtener el ultimo id (del registro que se insertó).
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet r = stmt.executeQuery()) {
                r.next();
                i.setId(r.getInt("id"));
            }
        }
        
        return i.getId();
    }

    @Override
    public void update(Carrera i) throws Exception {
        String sql = "UPDATE carreras SET nombre = ?, activo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, i.getNombre());
            stmt.setBoolean(2, i.isActivo());
            stmt.setInt(3, i.getId());
            stmt.execute();
        }
    }    
}
