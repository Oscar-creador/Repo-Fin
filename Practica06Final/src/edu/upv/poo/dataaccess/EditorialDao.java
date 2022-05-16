package edu.upv.poo.dataaccess;

/**
 * Definición del Data Access Object de Editorial (tabla editoriales).
 * @author luisroberto
 */
public interface EditorialDao {
    
    Editorial getById(int editorialId) throws Exception;
    
    Editorial[] getAll() throws Exception;
    
    int insert(Editorial i) throws Exception;
    
    void update(Editorial i) throws Exception;
}
