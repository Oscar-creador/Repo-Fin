package edu.upv.poo.dataaccess;

import java.util.Date;

/**
 * Definición del Data Access Object del view prestamos_v.
 * @author luisroberto
 */
public interface PrestamoVDao {
    
    /**
     * Obtiene un registro (objeto tipo PrestamoV) por su id.
     * @param prestamoId El id del registro del prestamo.
     * @return Objeto PrestamoV si se encontró; de otra forma, null.
     * @throws Exception 
     */
    PrestamoV getById(int prestamoId) throws Exception;
    
    /**
     * Obtiene los registro (array de PrestamoV) de los prestamos de libros
     * de un alumno es específico.
     * @param alumnoId Identificador del alumno.
     * @return
     * @throws Exception 
     */
    PrestamoV[] getByAlumno(int alumnoId) throws Exception;
    
    /**
     * Obtiene los registros (array de PrestamoV) que corresponden a un libro
     * del inventario en específico.
     * @param libroInventarioId
     * @return
     * @throws Exception 
     */
    PrestamoV[] getByLibroInventario(int libroInventarioId) throws Exception;
    
    /**
     * Obtiene los registros (array de PrestamoV) que corresponden a los 
     * prestamos realizados entre cierto rango de fechas;
     * @param fechaPrestamoI
     * @param fechaPrestamoT
     * @return
     * @throws Exception 
     */
    PrestamoV[] getByFechaPrestamoRango(
            Date fechaPrestamoI, Date fechaPrestamoT) throws Exception;
    
    PrestamoV[] getAll() throws Exception;
}
