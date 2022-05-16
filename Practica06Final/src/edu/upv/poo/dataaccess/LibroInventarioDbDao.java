package edu.upv.poo.dataaccess;

import java.sql.*;

/**
 * Implementación del Data Access Object de LibroInventario, que representa un
 * registro de la tabla libros_inventario.
 * @author luisroberto
 */
public class LibroInventarioDbDao implements LibroInventarioDao {
    
    private final Connection connection;
    
    /**
     * Inicializa una nueva instancia de LibroInventarioDbDao.
     * @param connection Objeto Connection a usar.
     */
    public LibroInventarioDbDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public LibroInventario getById(int libroInventarioId) throws Exception {
        // TODO: Implementación de la funcionalidad.
        LibroInventario libroInv = null;
        String sql = "SELECT * FROM libros_inventario_v WHERE inventario_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, libroInventarioId);
            try (ResultSet r = stmt.executeQuery()) {
                libroInv = r.next() ? toObj(r) : null;
            }
        }
        return libroInv; 
    }

    @Override
    public int insert(LibroInventario i) throws Exception {
        // TODO: Implementación de la funcionalidad.
        String sql = "CALL sp_insertar_libInventario(?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, i.getLibroId());
            stmt.setString(2, i.getEstado());
            stmt.setBoolean(3, i.isDisponible());
            try (ResultSet r = stmt.executeQuery()) {
                r.next();
                i.setId(r.getInt("id"));
            }
        }
        return i.getId();
    }

    @Override
    public void update(LibroInventario i) throws Exception {
        // TODO: Implementación de la funcionalidad.
        String sql = "CALL update_libInventario(?, ?, ?, ?)";
         try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, i.getId());
                stmt.setInt(2, i.getLibroId());
                stmt.setString(3, i.getEstado());
                stmt.setBoolean(4, i.isDisponible());
                stmt.execute();
         }
    }

    private LibroInventario toObj(ResultSet r) throws Exception{
        LibroInventario l = new LibroInventario();
        l.setId(r.getInt("inventario_id"));
        l.setLibroId(r.getInt("id"));
        l.setEstado(r.getString("estado"));
        l.setDisponible(r.getBoolean("disponible"));
        return l;
    }

    @Override
    public void updateById(LibroInventario i) throws Exception {
        String sql = "UPDATE libros_inventario SET estado = ? WHERE id = ?";
        
    }
}
