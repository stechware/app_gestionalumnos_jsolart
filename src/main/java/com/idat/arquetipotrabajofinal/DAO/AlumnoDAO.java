/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.DAO;

import com.idat.arquetipotrabajofinal.config.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.idat.arquetipotrabajofinal.model.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Solaris
 */
public class AlumnoDAO {
    
    private static final Logger logger = LogManager.getLogger(AlumnoDAO.class);

    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (id, name, email) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setInt(1, alumno.getId());
            stmt.setString(2, alumno.getName());
            stmt.setString(3, alumno.getEmail());
            stmt.executeUpdate();
            
            logger.info("✅ Alumno insertado correctamente: " + alumno);
        } catch (SQLException e) {
            logger.error("❌ Error al insertar alumno", e);
        }
    }

    public Alumno obtenerAlumno(int id) {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        Alumno alumno = null;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                alumno = new Alumno(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                logger.info("✅ Alumno encontrado: " + alumno);
            } else {
                logger.warn("⚠️ Alumno no encontrado con ID: " + id);
            }
        } catch (SQLException e) {
            logger.error("❌ Error al obtener alumno", e);
        }
        return alumno;
    }

    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET name = ?, email = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setString(1, alumno.getName());
            stmt.setString(2, alumno.getEmail());
            stmt.setInt(3, alumno.getId());
            stmt.executeUpdate();
            
            logger.info("✅ Alumno actualizado correctamente: " + alumno);
        } catch (SQLException e) {
            logger.error("❌ Error al actualizar alumno", e);
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            logger.info("✅ Alumno eliminado correctamente con ID: " + id);
        } catch (SQLException e) {
            logger.error("❌ Error al eliminar alumno", e);
        }
    }
}
