package edu.upv.poo.dataaccess;

import java.time.LocalDate;

/**
 * Representa un Alumno en DB.
 * @author luisroberto
 */
public class Alumno {
    
    private int id;
    private String nombre;
    private String apellidos;
    private int carreraId;
    private Carrera carrera;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private String genero;
    private int matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
     public int getMatricula() {
        return matricula;
    }
     
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }
    
    public Carrera getCarrera() { return carrera;}
    
    public void setCarrera(Carrera value) {carrera = value;}

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
