package iesmm.pmdm.airsofttracker.dao.connection;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String URI = "jdbc:mysql://192.168.56.1:3306/airsofttracker";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private static Connection con = null;

    public Conexion() throws SQLException {
        // Añadimos el driver
        try {
            DriverManager.setLoginTimeout(5);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Log.e(":::Conexion", "Error al cargar el driver: ", e);
        }
        // Realizamos la conexión
        con = DriverManager.getConnection(URI, USER, PASSWORD);
    }

    public static Connection getConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            new Conexion();
        }
        return con;
    }
}