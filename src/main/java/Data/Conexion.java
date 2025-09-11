/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection cn;
    
    // Configura tus datos de conexión aquí
    private final String url = "jdbc:mysql://localhost:3306/control_asistencia"; // <-- cambia "tu_basedatos"
    private final String user = "root"; // <-- cambia si tu usuario es distinto
    private final String password = "palomas132.,"; // <-- coloca tu contraseña de MySQL
    
    // Método para conectar
    public Connection conectado() {
        try {
            // Cargar el driver (opcional desde JDBC 4, pero recomendable)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexión establecida con la BD");
            
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el Driver de MySQL -> " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión a la BD -> " + e.getMessage());
        }
        return cn;
    }
    
    // Método para desconectar
    public void desconectar() {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
                System.out.println("🔌 Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al cerrar la conexión -> " + e.getMessage());
        }
    }
}
