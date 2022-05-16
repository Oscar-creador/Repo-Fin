package edu.upv.poo.dataaccess;

/**
 * Representa el Data Access Object de Alumno con las operaciones CRUD comunes.
 * @author luisroberto
 */
public interface AlumnoDao {
    
    Alumno getById(int alumnoId) throws Exception;
    
    Alumno getByMatricula(int matricula) throws Exception;
    
    Alumno[] getByCarrera(int carreraId) throws Exception;
    
    int insert(Alumno i) throws Exception;
    
    void update(Alumno i) throws Exception;
}
