/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import com.idat.arquetipotrabajofinal.config.LookAndFeelManager;
import com.idat.arquetipotrabajofinal.controller.AlumnoController;
import com.idat.arquetipotrabajofinal.controller.MainController;
import com.idat.arquetipotrabajofinal.util.IconUtil;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Solaris
 */
public class MainView extends JFrame {
    
    
    private JDesktopPane desktopPane; // Para manejar el ineternal Frame
    
    private JToolBar toolBar;
    private JButton btnGestionAlumnos, btnBuscarAlumno;

    public MainView() {
        setTitle("Sistema de Registro de Alumnos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
         // Cambiar el icono de la aplicación
        setIconImage(new ImageIcon(getClass().getResource("/icons/software.png")).getImage());
        
        // Crear el área de trabajo
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);
            
        // Crear la barra de herramientas
        toolBar = new JToolBar();

        // Botón "Gestión de Alumnos" con icono
        btnGestionAlumnos = new JButton(IconUtil.resizeIcon("/icons/alumno.png", 24, 24));
        btnGestionAlumnos.setToolTipText("Gestión de Alumnos");
        btnGestionAlumnos.setFocusable(false);
        btnGestionAlumnos.addActionListener(e -> abrirGestionAlumnos());

        // Botón "Buscar Alumno" con icono
        btnBuscarAlumno =  new JButton(IconUtil.resizeIcon("/icons/buscar.png", 24, 24));
        btnBuscarAlumno.setToolTipText("Buscar Alumno");
        btnBuscarAlumno.setFocusable(false);
        btnBuscarAlumno.addActionListener(e -> abrirBuscarAlumno());

        // Agregar botones a la barra de herramientas
        toolBar.add(btnGestionAlumnos);
        toolBar.add(btnBuscarAlumno);

        // Agregar la barra de herramientas a la parte superior de la ventana
        add(toolBar, BorderLayout.NORTH);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú principal "Opciones"
        JMenu menuOpciones = new JMenu("Opciones");

        // Opción "Gestión de Alumnos"
        JMenuItem itemGestionAlumnos = new JMenuItem("Gestión de Alumnos");
        //itemGestionAlumnos.addActionListener(e -> new AlumnoController().mostrarVista());
        itemGestionAlumnos.addActionListener(e -> new AlumnoController().mostrarVista(desktopPane));

        // Opción "Buscar Alumno"
        JMenuItem itemBuscarAlumno = new JMenuItem("Buscar Alumno");
        itemBuscarAlumno.addActionListener(e -> new BuscarAlumnoView().setVisible(true));

        // Agregar opciones al menú
        menuOpciones.add(itemGestionAlumnos);
        menuOpciones.add(itemBuscarAlumno);

        
        // Agregar el footer a la ventana principal
        add(new FooterPanel(), java.awt.BorderLayout.SOUTH);
        
        // Menú para cambiar Look and Feel
        JMenu menuLookAndFeel = new JMenu("Look & Feel");

        for (String lookName : LookAndFeelManager.getAvailableLookAndFeels()) {
            JMenuItem menuItem = new JMenuItem(lookName);
            menuItem.addActionListener(e -> LookAndFeelManager.setLookAndFeel(this, lookName));
            menuLookAndFeel.add(menuItem);
        }

        menuOpciones.add(menuLookAndFeel);
        
        // Opción "Salir"
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuOpciones.addSeparator(); // Línea divisoria
        menuOpciones.add(itemSalir);
        
        // Agregar menú a la barra
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);
        
    }
    
    private void abrirGestionAlumnos() {
        //new AlumnoController().mostrarVista();
        new AlumnoController().mostrarVista(desktopPane);
    }
    
        private void abrirBuscarAlumno() {
        new BuscarAlumnoView().setVisible(true);
    }
}
