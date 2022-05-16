package edu.upv.poo.dataaccess;

/**
 * Definición del Data Access Object del view libros_inventario_existencia_v.
 * @author luisroberto
 */
public interface LibroInventarioExistenciaVDao {
    
    /**
     * Obtiene un registro de libros_inventario_existencia_v por el 
     * identificador del Libro.
     * @param libroId Identificador del libro.
     * @return Un objeto LibroInventarioExistenciaV si se encontró; de otra 
     * forma, null.
     * @throws java.lang.Exception
     */
    LibroInventarioExistenciaV getById(int libroId) throws Exception;
    
    LibroInventarioExistenciaV[] getAll()throws Exception;
    
    /**
     * Obtiene los resultados de la búsqueda de un libro según su titulo.
     * @param titulo Titulo o parte del titulo a buscar.
     * @return Un array de LibroInventarioExistenciaV con los resultados.
     * @throws Exception 
     */
    LibroInventarioExistenciaV[] searchByTitulo(String titulo) throws Exception;
}
