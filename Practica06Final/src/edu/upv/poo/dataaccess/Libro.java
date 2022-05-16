package edu.upv.poo.dataaccess;

/**
 * Representa un registro de la tabla de libros.
 * @author luisroberto
 */
public class Libro {
    
    private int id;
    private String titulo;
    private int tipoRecursoId;
    private String edicion;
    private Integer editorialId;
    private String autores;
    private String isbn;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(int tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
      return this.titulo;
    }
}
