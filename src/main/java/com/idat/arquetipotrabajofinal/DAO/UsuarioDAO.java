/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.DAO;

import com.idat.arquetipotrabajofinal.config.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.idat.arquetipotrabajofinal.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Solaris
 */
public class UsuarioDAO {
    
    private static final Logger logger = LogManager.getLogger(UsuarioDAO.class);

    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.executeUpdate();
            
            logger.info("✅ Usuario insertado correctamente: " + usuario);
        } catch (SQLException e) {
            logger.error("❌ Error al insertar usuario", e);
        }
    }

    public Usuario obtenerUsuario(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        Usuario usuario = null;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(rs.getString("username"), rs.getString("password"));
                logger.info("✅ Usuario encontrado: " + usuario);
            } else {
                logger.warn("⚠️ Usuario no encontrado: " + username);
            }
        } catch (SQLException e) {
            logger.error("❌ Error al obtener usuario", e);
        }
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET password = ? WHERE username = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getPassword());
            stmt.setString(2, usuario.getUsername());
            stmt.executeUpdate();
            
            logger.info("✅ Usuario actualizado correctamente: " + usuario);
        } catch (SQLException e) {
            logger.error("❌ Error al actualizar usuario", e);
        }
    }

    public void eliminarUsuario(String username) {
        String sql = "DELETE FROM usuarios WHERE username = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.executeUpdate();
            
            logger.info("✅ Usuario eliminado correctamente: " + username);
        } catch (SQLException e) {
            logger.error("❌ Error al eliminar usuario", e);
        }
    }
}
