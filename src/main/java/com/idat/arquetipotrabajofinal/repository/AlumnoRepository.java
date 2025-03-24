/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.repository;

import com.idat.arquetipotrabajofinal.config.ConexionBD;
import java.util.List;
import org.apache.logging.log4j.Logger;
import com.idat.arquetipotrabajofinal.model.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Solaris
 */
public class AlumnoRepository {
    
    private static final Logger logger = LogManager.getLogger(AlumnoRepository.class);

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                alumnos.add(alumno);
            }
            logger.info("✅ Se obtuvieron {} alumnos de la BD.", alumnos.size());

        } catch (SQLException e) {
            logger.error("❌ Error al obtener alumnos", e);
        }
        return alumnos;
    }

    public boolean insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (name, email) VALUES (?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, alumno.getName());
            pstmt.setString(2, alumno.getEmail());

            int filas = pstmt.executeUpdate();
            logger.info("✅ Alumno insertado correctamente: {}", alumno);
            return filas > 0;

        } catch (SQLException e) {
            logger.error("❌ Error al insertar alumno", e);
            return false;
        }
    }

    public boolean actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, alumno.getName());
            pstmt.setString(2, alumno.getEmail());
            pstmt.setInt(3, alumno.getId());

            int filas = pstmt.executeUpdate();
            logger.info("✅ Alumno actualizado correctamente: {}", alumno);
            return filas > 0;

        } catch (SQLException e) {
            logger.error("❌ Error al actualizar alumno", e);
            return false;
        }
    }

    public boolean eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int filas = pstmt.executeUpdate();
            logger.info("✅ Alumno eliminado correctamente con ID: {}", id);
            return filas > 0;

        } catch (SQLException e) {
            logger.error("❌ Error al eliminar alumno", e);
            return false;
        }
    }
}