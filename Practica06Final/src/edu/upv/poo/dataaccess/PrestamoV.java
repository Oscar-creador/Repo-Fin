package edu.upv.poo.dataaccess;

import java.time.LocalDateTime;

/**
 * Representa un registro del view de prestamos_v.
 * @author luisroberto
 */
public class PrestamoV {
    
    private int id;
    private int libroInventarioId;
    private int libroId;
    private String libroTitulo;
    private String libroTipoRecursoNombre;
    private String libroEdicion;
    private String libroEditorialNombre;
    private String libroAutores;
    private String libroIsbn;
    private String libroEstado;
    private int alumnoId;
    private String alumnoNombre;
    private String alumnoApellidos;
    private String alumnoCarreraNombre;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDebeDevolver;
    private LocalDateTime fechaDevuelto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLibroInventarioId() {
        return libroInventarioId;
    }

    public void setLibroInventarioId(int libroInventarioId) {
        this.libroInventarioId = libroInventarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public String getLibroTitulo() {
        return libroTitulo;
    }

    public void setLibroTitulo(String libroTitulo) {
        this.libroTitulo = libroTitulo;
    }

    public String getLibroTipoRecursoNombre() {
        return libroTipoRecursoNombre;
    }

    public void setLibroTipoRecursoNombre(String libroTipoRecursoNombre) {
        this.libroTipoRecursoNombre = libroTipoRecursoNombre;
    }

    public String getLibroEdicion() {
        return libroEdicion;
    }

    public void setLibroEdicion(String libroEdicion) {
        this.libroEdicion = libroEdicion;
    }

    public String getLibroEditorialNombre() {
        return libroEditorialNombre;
    }

    public void setLibroEditorialNombre(String libroEditorialNombre) {
        this.libroEditorialNombre = libroEditorialNombre;
    }

    public String getLibroAutores() {
        return libroAutores;
    }

    public void setLibroAutores(String libroAutores) {
        this.libroAutores = libroAutores;
    }

    public String getLibroIsbn() {
        return libroIsbn;
    }

    public void setLibroIsbn(String libroIsbn) {
        this.libroIsbn = libroIsbn;
    }

    public String getLibroEstado() {
        return libroEstado;
    }

    public void setLibroEstado(String libroEstado) {
        this.libroEstado = libroEstado;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getAlumnoApellidos() {
        return alumnoApellidos;
    }

    public void setAlumnoApellidos(String alumnoApellidos) {
        this.alumnoApellidos = alumnoApellidos;
    }

    public String getAlumnoCarreraNombre() {
        return alumnoCarreraNombre;
    }

    public void setAlumnoCarreraNombre(String alumnoCarreraNombre) {
        this.alumnoCarreraNombre = alumnoCarreraNombre;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDebeDevolver() {
        return fechaDebeDevolver;
    }

    public void setFechaDebeDevolver(LocalDateTime fechaDebeDevolver) {
        this.fechaDebeDevolver = fechaDebeDevolver;
    }

    public LocalDateTime getFechaDevuelto() {
        return fechaDevuelto;
    }

    public void setFechaDevuelto(LocalDateTime fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }
    
    
}
