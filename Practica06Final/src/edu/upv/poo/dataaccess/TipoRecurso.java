package edu.upv.poo.dataaccess;

/**
 * Representa un tipo de recurso (tipo de libro).
 * @author luisroberto
 */
public class TipoRecurso {
    
    private int id;
    private String nombre;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
      return this.nombre;
    }
}
