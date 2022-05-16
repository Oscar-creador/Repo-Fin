package edu.upv.poo.dataaccess;

/**
 * Representa un elemento del view libros_inventario_v, que corresponde a un
 * libro del inventario.
 * @author luisroberto
 */
public class LibroInventarioV {
    
    private int inventarioId;
    private int id;  
    private String titulo;
    private int tipoRecursoId;
    private String tipoRecursoNombre;
    private String edicion;
    private String editorialNombre;
    private String editorialPais;
    private String editorialEmail;
    private String autores;
    private String isbn;
    private String estado;
    private boolean disponible;

    /**
     * Identificador del registro de libros_inventario.
     * @return el id de libros_inventario
     */
    public int getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(int inventarioId) {
        this.inventarioId = inventarioId;
    }

    /**
     * Identificador del libro.
     * @return 
     */
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

    public String getTipoRecursoNombre() {
        return tipoRecursoNombre;
    }

    public void setTipoRecursoNombre(String tipoRecursoNombre) {
        this.tipoRecursoNombre = tipoRecursoNombre;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getEditorialNombre() {
        return editorialNombre;
    }

    public void setEditorialNombre(String editorialNombre) {
        this.editorialNombre = editorialNombre;
    }

    public String getEditorialPais() {
        return editorialPais;
    }

    public void setEditorialPais(String editorialPais) {
        this.editorialPais = editorialPais;
    }

    public String getEditorialEmail() {
        return editorialEmail;
    }

    public void setEditorialEmail(String editorialEmail) {
        this.editorialEmail = editorialEmail;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
