package edu.upv.poo.dataaccess;

/**
 * Define el Data Access Object de tipo recurso (tabla tipos_recursos).
 * @author luisroberto
 */
public interface TipoRecursoDao {
    
    TipoRecurso[] getAll() throws Exception;
    TipoRecurso getById(int tipoId) throws Exception;    
}
