package edu.upv.poo.dataaccess;

/**
 * 
 * @author luisroberto
 */
public interface CarreraDao {
    
    Carrera getById(int carreraId) throws Exception;
    
    Carrera[] getAll() throws Exception;
    
    int insert(Carrera i) throws Exception;
    
    void update(Carrera i) throws Exception;
}
