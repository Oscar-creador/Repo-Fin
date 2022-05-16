package edu.upv.poo.dataaccess;

/**
 * Definición del Data Access Object de la tabla libros_inventario.
 * @author luisroberto
 */
public interface LibroInventarioDao {
 
    /**
     * Obtiene un registro por su identificador.
     * @param libroInventarioId
     * @return Object LibroInventario si se encontró, de otra forma null.
     * @throws Exception 
     */
    LibroInventario getById(int libroInventarioId) throws Exception;
    
    /**
     * Agrega un nuevo registro.
     * @param i Objeto LibroInventario con los datos que queremos insertar.
     * @return El id del registro insertado.
     * @throws Exception 
     */
    int insert(LibroInventario i) throws Exception;
    
    /**
     * Actualiza un registro.
     * @param i Objeto LibroInventario que representa el registro a actualizar.
     * @throws Exception 
     */
    void update(LibroInventario i) throws Exception;
    
    void updateById(LibroInventario i)throws Exception;
}
