/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Solaris
 */
public class ConexionBD {
    
    private static final Logger logger = LogManager.getLogger(ConexionBD.class);

    private static final String URL = "jdbc:mysql://localhost:3306/alumnosdb";
    private static final String USER = "root"; // Cambia esto si usas otro usuario
    private static final String PASSWORD = "solaris"; // Cambia esto si usas una contraseña

    public static Connection conectar() {
        Connection conexion = null;
        try {
            logger.info("Iniciando Arquetipo TrabajoFinal Desde log4j");

            // Cargar el driver de MySQL (opcional en versiones modernas de Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("✅ Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {
            logger.error("❌ Error: No se encontró el driver de MySQL.", e);
        } catch (SQLException e) {
            logger.error("❌ Error: No se pudo conectar a la base de datos.", e);
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                logger.info("🔌 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            logger.warn("⚠️ Error al cerrar la conexión.", e);
        }
    }
}
