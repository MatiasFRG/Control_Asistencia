/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Conexion conexion = new Conexion();

    // 🔹 Mantengo tu login original
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

    // 🔹 Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection cn = conexion.conectado();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getInt("usu_rut"),
                        rs.getString("usu_nombre"),
                        rs.getString("usu_apellido"),
                        rs.getString("usu_correo"),
                        rs.getString("usu_password"),
                        rs.getString("rol")
                );
                lista.add(user);
            }
        } catch (Exception e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    // 🔹 Crear usuario
    public boolean crearUsuario(Usuario u) {
        String sql = "INSERT INTO usuarios (usu_rut, usu_nombre, usu_apellido, usu_correo, usu_password, rol) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.conectado();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, u.getRut());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getRol());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al crear usuario: " + e.getMessage());
            return false;
        }
    }

    // 🔹 Modificar usuario
    public boolean modificarUsuario(Usuario u) {
        String sql = "UPDATE usuarios SET usu_nombre=?, usu_apellido=?, usu_correo=?, usu_password=?, rol=? WHERE usu_rut=?";
        try (Connection cn = conexion.conectado();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getRol());
            ps.setInt(6, u.getRut());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al modificar usuario: " + e.getMessage());
            return false;
        }
    }

    // 🔹 Eliminar usuario
    public boolean eliminarUsuario(int rut) {
        String sql = "DELETE FROM usuarios WHERE usu_rut=?";
        try (Connection cn = conexion.conectado();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, rut);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}