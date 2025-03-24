/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import com.idat.arquetipotrabajofinal.model.Alumno;
import com.idat.arquetipotrabajofinal.util.IconUtil;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Solaris
 */
public class AlumnoInternalFrame extends JInternalFrame{
    
    private JTable alumnoTable;
    private JButton btnMostrar, btnLimpiar;
    private JScrollPane scrollPane;
    
    public AlumnoInternalFrame(List<Alumno> alumnos) {
        setTitle("Gestión de Alumnos");
        setSize(400, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new BorderLayout()); // Usa BorderLayout para un mejor ajuste
        
        // Cambiar el icono de la ventana hija
        setFrameIcon(IconUtil.resizeIcon("/icons/alumno.png", 16, 16));

        String[] columnNames = {"ID", "Nombre", "Email"};
        Object[][] data = new Object[alumnos.size()][3];
        for (int i = 0; i < alumnos.size(); i++) {
            data[i][0] = alumnos.get(i).getId();
            data[i][1] = alumnos.get(i).getName();
            data[i][2] = alumnos.get(i).getEmail();
        }

        alumnoTable = new JTable(data, columnNames);
        scrollPane = new JScrollPane(alumnoTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnMostrar = new JButton("Mostrar");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);
        
        // Hacer visible el JInternalFrame
        setVisible(true);
    }
}
