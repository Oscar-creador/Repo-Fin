package edu.upv.poo;

import java.sql.*;
import edu.upv.poo.dataaccess.*;
import edu.upv.poo.ui.MainGUI;

/**
 *
 * @author luisroberto
 */
public class App {

    private static final String DB_URL = 
            "jdbc:mysql://127.0.0.1:3306/biblioteca";
    
    private static final String DB_USERNAME = "root";
    
    private static final String DB_PASSWORD = "123456";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainGUI main = new MainGUI();
        main.setVisible(true);
        main.setTitle("Menu");
        
    }
    
    public static Connection getConnection() throws SQLException {
        //DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
    
    public static CarreraDao getCarreraDao(Connection connection) {
        // return new CarreraDbDaoOracle(connection);
        return new CarreraDbDao(connection);
    }
    
    public static EditorialDbDao getEditorialDao(Connection connection) {
        return new EditorialDbDao(connection);
    }

    public static LibroDbDao getLibrosDao(Connection connection) {
        return new LibroDbDao(connection);
    }
    
    public static LibroInventarioDbDao getLibrosInventarioDao(Connection connection) {
        return new LibroInventarioDbDao(connection);
    }
    
    public static LibroInventarioExistenciaVDbDao getLibrosInventarioExistenciaVDao(Connection connection) {
        return new LibroInventarioExistenciaVDbDao(connection);
    }
    
    public static TipoRecursoDbDao getTipoRecursoDao(Connection connection) {
        return new TipoRecursoDbDao(connection);
    }
    
    public static PrestamoVDbDao getPrestamosVDao(Connection connection) {
        return new PrestamoVDbDao(connection);
    }
    
    public static PrestamoDbDao getPrestamosDao(Connection connection) {
        return new PrestamoDbDao(connection);
    }
    
    public static AlumnoDbDao getAlumnosDao(Connection connection) {
        return new AlumnoDbDao(connection);
    }
}
