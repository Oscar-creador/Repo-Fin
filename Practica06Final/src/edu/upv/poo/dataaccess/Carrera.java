package edu.upv.poo.dataaccess;

import java.sql.*;

/**
 * Representa un registro de una Carrera en DB.
 * POJO  -> Plain Old Java Object.
 * @author luisroberto
 */
public class Carrera {
    
    private int id;
    private String nombre;
    private boolean activo;

    public Carrera(ResultSet r) throws Exception {
        setId(r.getInt("id"));
        setNombre(r.getString("nombre"));
        setActivo(r.getBoolean("activo"));
    }
    
    public Carrera() { }
    
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
        return String.format("[%03d] - %s", getId(), getNombre());
    }
}
