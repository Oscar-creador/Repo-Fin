package edu.upv.poo.dataaccess;

import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Implementación de la funcionalidad de data access object para Prestamo.
 * @author luisroberto
 */
public class PrestamoDbDao implements PrestamoDao {

    private final Connection connection;
    
    public PrestamoDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Prestamo getById(int prestamoId) throws Exception {
        Prestamo i = null;
        String sql = "SELECT * FROM prestamos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, prestamoId);
            try (ResultSet r = stmt.executeQuery()) {
                if (r.next()) i = toObj(r);
            }
        }
        return i;
    }

    @Override
    public int insert(Prestamo i) throws Exception {
        // Operación de insert a DB.
        String sql =  // SQL command de insert.
                "INSERT INTO prestamos (libro_inventario_id, alumno_id, "
                + "fecha_prestamo, fecha_devuelto, fecha_debe_devolver, "
                + "disponible) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {  // peraración de la operación
            stmt.setInt(1, i.getLibroInventarioId());
            stmt.setInt(2, i.getAlumnoId());
            stmt.setObject(3, i.getFechaPrestamo());
            stmt.setObject(4, i.getFechaDevuelto());
            stmt.setObject(5, i.getFechaDebeDevolver());
            stmt.setBoolean(6, i.isDisponible());  
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
    public void update(Prestamo i) throws Exception {
        String sql = "UPDATE prestamos SET libro_inventario_id = ?, "
                + "alumno_id = ?, fecha_prestamo = ?, fecha_devuelto = ?, "
                + "fecha_debe_devolver = ?, disponible = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, i.getLibroInventarioId());
            stmt.setInt(2, i.getAlumnoId());
            stmt.setObject(3, i.getFechaPrestamo());
            stmt.setObject(4, i.getFechaDevuelto());
            stmt.setObject(5, i.getFechaDebeDevolver());
            stmt.setBoolean(6, i.isDisponible());
            stmt.setInt(7, i.getId());
            stmt.execute();
        }
    }
    
    private Prestamo toObj(ResultSet r) throws Exception {
        Prestamo i = new Prestamo();
        i.setId(r.getInt("id"));
        i.setLibroInventarioId(r.getInt("libro_inventario_id"));
        i.setAlumnoId(r.getInt("alumno_id"));
        i.setFechaPrestamo(r.getObject("fecha_prestamo", LocalDateTime.class));
        i.setFechaDebeDevolver(r.getObject("fecha_debe_devolver", LocalDateTime.class));
        i.setFechaDevuelto(r.getObject("fecha_devuelto", LocalDateTime.class));
        return i;
    }
    
}
