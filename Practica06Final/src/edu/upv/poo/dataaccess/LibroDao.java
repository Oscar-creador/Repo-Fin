package edu.upv.poo.dataaccess;

/**
 * Definición del Data Access Object de libros.
 * @author luisroberto
 */
public interface LibroDao {
    
    /**
     * Obtiene un registro (objeto Libro) por su id.
     * @param libroId El identificador del libro a obtener.
     * @return Objeto Libro si se encontró; de otra forma, null.
     * @throws Exception 
     */
    Libro getById(int libroId) throws Exception;
    
    Libro[] getAll()throws Exception;
    
    /**
     * Inserta un registro en tabla libros.
     * @param i Objeto Libro que representa el registro a insertar.
     * @return El id del registro insertado.
     * @throws Exception 
     */
    int insert(Libro i) throws Exception;
    
    /**
     * Actualiza un registro en tabla libros.
     * @param i Objeto Libro que representa el registro a actualizar.
     * @throws Exception 
     */
    void update(Libro i) throws Exception;    
}
