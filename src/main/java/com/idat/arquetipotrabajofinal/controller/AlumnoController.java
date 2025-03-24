/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.controller;

import com.idat.arquetipotrabajofinal.view.AlumnoView;

import com.idat.arquetipotrabajofinal.model.Alumno;
import com.idat.arquetipotrabajofinal.repository.AlumnoRepository;
import com.idat.arquetipotrabajofinal.view.AlumnoInternalFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Solaris
 */
public class AlumnoController {
    
    private static final Logger logger = LogManager.getLogger(AlumnoController.class);
    private final AlumnoRepository alumnoRepository;
    
    public AlumnoController() {
        this.alumnoRepository = new AlumnoRepository();
    }

    /**
     * Obtiene la lista de alumnos desde la base de datos.
     */
    public List<Alumno> obtenerAlumnos() {
        return alumnoRepository.obtenerAlumnos();
    }

    /**
     * Agrega un nuevo alumno a la base de datos.
     */
    public boolean agregarAlumno(String nombre, String email) {
        Alumno alumno = new Alumno(0, nombre, email);
        boolean resultado = alumnoRepository.insertarAlumno(alumno);
        if (resultado) {
            logger.info("✅ Alumno agregado correctamente: {}", alumno);
        }
        return resultado;
    }

    /**
     * Actualiza un alumno existente en la base de datos.
     */
    public boolean actualizarAlumno(int id, String nombre, String email) {
        Alumno alumno = new Alumno(id, nombre, email);
        boolean resultado = alumnoRepository.actualizarAlumno(alumno);
        if (resultado) {
            logger.info("✅ Alumno actualizado correctamente: {}", alumno);
        }
        return resultado;
    }

    /**
     * Elimina un alumno de la base de datos por su ID.
     */
    public boolean eliminarAlumno(int id) {
        boolean resultado = alumnoRepository.eliminarAlumno(id);
        if (resultado) {
            logger.info("✅ Alumno eliminado correctamente con ID: {}", id);
        }
        return resultado;
    }

    /**
     * Muestra la vista de alumnos dentro de un JDesktopPane.
     */
    public void mostrarVista(JDesktopPane desktopPane) {
        List<Alumno> alumnos = obtenerAlumnos();
        AlumnoInternalFrame alumnoFrame = new AlumnoInternalFrame(alumnos);
        desktopPane.add(alumnoFrame);
        alumnoFrame.setVisible(true);
    }
}