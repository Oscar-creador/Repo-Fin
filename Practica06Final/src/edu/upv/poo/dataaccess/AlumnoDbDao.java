package edu.upv.poo.dataaccess;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementa la funcionalidad Data Access Object para alumno.
 * @author luisroberto
 */
public class AlumnoDbDao implements AlumnoDao {

    private final Connection connection;
    
    /**
     * Inicializa una nueva instancia de AlumnoDbDao.
     * @param connection Objeto Connection a usar.
     */
    public AlumnoDbDao(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Alumno getById(int alumnoId) throws Exception {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos_v WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, alumnoId);
            try (ResultSet r = stmt.executeQuery()) {
                alumno = r.next() ? toObj(r) : null;
            }
        }
        return alumno;
    }

    @Override
    public Alumno[] getByCarrera(int carreraId) throws Exception {
        ArrayList<Alumno> l = new ArrayList<>();
        String sql = "SELECT * FROM alumnos_v WHERE carrera_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carreraId);
            try (ResultSet r = stmt.executeQuery()) {
                while (r.next()) l.add(toObj(r));
            }
        }
        return l.toArray(new Alumno[] {});
    }

    @Override
    public int insert(Alumno i) throws Exception {
        
        // Cuando ejecutamos un stored procedure, definimos la cantidad de 
        // parámetros con '?'. Nota: ver definición del stored procedure en
        // la base de datos.
        String sql = "CALL insert_alumno(?, ?, ?, ?, ?, ?)";
        
        // Usamos el objeto CallableStatement
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            
            // Agregamos los parámetros del stored procedure en orden.
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getApellidos());
            stmt.setString(3, i.getGenero());
            stmt.setInt(4, i.getCarreraId());
            stmt.setObject(5, i.getFechaIngreso());
            stmt.setObject(6, i.getFechaNacimiento());
            
            // El stored procedure regresa una consulta (instrucción SELECT),
            // por lo que obtenemos el resultset para obtener le resultado,
            // para este caso es el id del registro insertado.
            try (ResultSet r = stmt.executeQuery()) {
                r.next();  // nos movemos a la primera fila de la consulta
                i.setId(r.getInt("id"));  // obtenemos el resultado, el id...
            }
        }
        return i.getId();
    }

    @Override
    public void update(Alumno i) throws Exception {
        String sql = "CALL update_alumno(?, ?, ?, ?, ?, ?, ?)";
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setInt(1, i.getId());
            stmt.setString(2, i.getNombre());
            stmt.setString(3, i.getApellidos());
            stmt.setString(4, i.getGenero());
            stmt.setInt(5, i.getCarreraId());
            stmt.setObject(6, i.getFechaIngreso());
            stmt.setObject(7, i.getFechaNacimiento());
            stmt.execute();  // este stored procedure no regresa resultado, por lo que uasmos execute().
        }
    }
    
    private Alumno toObj(ResultSet r) throws Exception {
        Alumno i = new Alumno();
        i.setId(r.getInt("id"));
        i.setNombre(r.getString("nombre"));
        i.setApellidos(r.getString("apellidos"));
        i.setCarreraId(r.getInt("carrera_id"));
        i.setFechaIngreso(r.getObject("fecha_ingreso", LocalDate.class));        
        i.setFechaNacimiento(r.getObject("fecha_nacimiento", LocalDate.class));
        i.setGenero(r.getString("genero"));
        Carrera carrera = new Carrera();
        carrera.setId(r.getInt("carrera_id"));
        carrera.setNombre(r.getString("carrera_nombre"));
        carrera.setActivo(r.getBoolean("carrera_activo"));
        i.setCarrera(carrera);
        return i;
    }

    @Override
    public Alumno getByMatricula(int matricula) throws Exception {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos_v WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            try (ResultSet r = stmt.executeQuery()) {
                alumno = r.next() ? toObj(r) : null;
            }
        }
        return alumno;
    }
}
