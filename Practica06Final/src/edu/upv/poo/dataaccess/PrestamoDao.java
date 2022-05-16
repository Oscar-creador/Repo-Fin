package edu.upv.poo.dataaccess;

/**
 * Definición del Data Access Object de la tabla prestamos.
 * @author luisroberto
 */
public interface PrestamoDao {
    
    /**
     * Obtiene un registro (objeto de tipo Prestamo) por su id.
     * @param prestamoId El identificador del registro del prestamo a obtener.
     * @return Objeto Prestamo si se encontró; de otra forma, null.
     * @throws Exception 
     */
    Prestamo getById(int prestamoId) throws Exception;
    
    /**
     * Inserta un registro en tabla prestamos.
     * @param i Objeto Prestamo que representa el registro a insertar.
     * @return El id del registo insertado.
     * @throws Exception 
     */
    int insert(Prestamo i) throws Exception;
    
    /**
     * Actualiza un registro de la tabla prestamos.
     * @param i Objeto Prestamo que representa el registro a actualizar.
     * @throws Exception 
     */
    void update(Prestamo i) throws Exception;
}
