/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

import com.idat.arquetipotrabajofinal.model.Alumno;

/**
 *
 * @author Solaris
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class AlumnoView extends JFrame {
    
    private JTable alumnoTable;
    private JButton btnMostrar, btnLimpiar;

    public AlumnoView(List<Alumno> alumnos) {
        setTitle("Registro de Alumnos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Nombre", "Email"};
        Object[][] data = new Object[alumnos.size()][3];
        for (int i = 0; i < alumnos.size(); i++) {
            data[i][0] = alumnos.get(i).getId();
            data[i][1] = alumnos.get(i).getName();
            data[i][2] = alumnos.get(i).getEmail();
        }

        alumnoTable = new JTable(data, columnNames);
        add(new JScrollPane(alumnoTable), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnMostrar = new JButton("Mostrar");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
}
