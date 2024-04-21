package iesmm.pmdm.airsofttracker.dao;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iesmm.pmdm.airsofttracker.dao.connection.Conexion;

public class DaoImpl implements dao {

    private Connection connection;
    private static String LOGTAG = ":::Dao";

    public DaoImpl() {
        try {
            connection = Conexion.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            showSQLErrors(e);
        } catch (Exception e) {
            Log.e(LOGTAG, "Error al obtener la conexión: ", e);
        }
    }

    @Override
    public int authenticateUser(String username, String password) {
        // Valor de retorno
        int idReturn = -1;
        // Consulta
        String query = "SELECT * FROM jugadores WHERE usuario=? AND contrasenya =?";
        try {
            // Preparamos la consulta
            PreparedStatement statement = connection.prepareStatement(query);
            // Añadimos los parámetros
            statement.setString(1, username);
            statement.setString(2, password);
            // Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();
            // Verificamos si hay algún resultado
            if (resultSet.next()) {
                // Obtenemos el valor del ID de usuario de la primera fila
                idReturn = resultSet.getInt("id_usuario");
            }
        } catch (SQLException e) {
            // Mostramos los errores
            showSQLErrors(e);
        }
        // Devolvemos el valor de retorno
        return idReturn;
    }

    private static void showSQLErrors (SQLException e){
        Log.e(LOGTAG, "Error al ejecutar la consulta: ", e);
        Log.e(LOGTAG, "SQLState: " + e.getSQLState());
        Log.e(LOGTAG, "Error Code: " + e.getErrorCode());
        Log.e(LOGTAG, "Message: " + e.getMessage());
    }

    public Connection getConnection() {
        return this.connection;
    }
}
