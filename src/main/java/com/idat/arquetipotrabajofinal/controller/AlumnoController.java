/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.controller;

import com.idat.arquetipotrabajofinal.view.AlumnoView;

import com.idat.arquetipotrabajofinal.model.Alumno;
import com.idat.arquetipotrabajofinal.view.AlumnoInternalFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;

/**
 *
 * @author Solaris
 */
public class AlumnoController {
    
    //private AlumnoView alumnoView;
    private List<Alumno> alumnos;

    public AlumnoController() {
        alumnos = new ArrayList<>();
        loadDummyData();
        //alumnoView = new AlumnoView(alumnos);
    }

    private void loadDummyData() {
        alumnos.add(new Alumno(1, "Juan Perez", "juan@example.com"));
        alumnos.add(new Alumno(2, "Maria Lopez", "maria@example.com"));
        alumnos.add(new Alumno(3, "Carlos Sanchez", "carlos@example.com"));
    }
    
    //public void mostrarVista() {
    //    alumnoView.setVisible(true);
    //}
    
    public void mostrarVista(JDesktopPane desktopPane) {
        AlumnoInternalFrame alumnoFrame = new AlumnoInternalFrame(alumnos);
        desktopPane.add(alumnoFrame);
        alumnoFrame.setVisible(true);
    }

}
