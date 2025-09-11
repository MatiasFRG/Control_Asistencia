/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    private Conexion conexion = new Conexion();

    public Usuario login(String correo, String clave) {
        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE usu_correo=? AND usu_password=?";
        try (Connection cn = conexion.conectado();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new Usuario(
                        rs.getInt("usu_rut"),
                        rs.getString("usu_nombre"),
                        rs.getString("usu_apellido"),
                        rs.getString("usu_correo"),
                        rs.getString("usu_password"),
                        rs.getString("rol")
                );
            }
        } catch (Exception e) {
            System.out.println("❌ Error en login: " + e.getMessage());
        }
        return user;
    }
}