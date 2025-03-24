/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import com.idat.arquetipotrabajofinal.controller.AlumnoController;
import com.idat.arquetipotrabajofinal.model.Alumno;
import com.idat.arquetipotrabajofinal.util.IconUtil;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Solaris
 */
public class AlumnoInternalFrame extends JInternalFrame {

    private JTable alumnoTable;
    private DefaultTableModel tableModel;
    private JButton btnAgregar, btnEditar, btnEliminar, btnActualizar;
    private AlumnoController alumnoController;

    public AlumnoInternalFrame(AlumnoController controller) {
        this.alumnoController = controller;

        setTitle("Gestión de Alumnos");
        setSize(600, 400);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setLayout(new BorderLayout());
        setFrameIcon(IconUtil.resizeIcon("/icons/alumno.png", 16, 16));

        initComponents();
        cargarAlumnos();
    }

    private void initComponents() {
        // Modelo de la tabla
        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Email"}, 0);
        alumnoTable = new JTable(tableModel);
        add(new JScrollPane(alumnoTable), BorderLayout.CENTER);

        // Panel de botones CRUD
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos de los botones
        btnAgregar.addActionListener(this::agregarAlumno);
        btnEditar.addActionListener(this::editarAlumno);
        btnEliminar.addActionListener(this::eliminarAlumno);
        btnActualizar.addActionListener(e -> cargarAlumnos());
    }

    /**
     * Carga los alumnos desde la base de datos y actualiza la tabla.
     */
    private void cargarAlumnos() {
        tableModel.setRowCount(0); // Limpiar tabla
        List<Alumno> alumnos = alumnoController.obtenerAlumnos();
        for (Alumno alumno : alumnos) {
            tableModel.addRow(new Object[]{alumno.getId(), alumno.getName(), alumno.getEmail()});
        }
    }

    /**
     * Agrega un nuevo alumno mediante un cuadro de diálogo.
     */
    private void agregarAlumno(ActionEvent e) {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:");
        String email = JOptionPane.showInputDialog(this, "Ingrese el email:");

        if (nombre != null && email != null) {
            Alumno nuevoAlumno = new Alumno(0, nombre, email);
            alumnoController.agregarAlumno(nuevoAlumno);
            cargarAlumnos();
        }
    }

    /**
     * Edita el alumno seleccionado.
     */
    private void editarAlumno(ActionEvent e) {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para editar.");
            return;
        }

        int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
        String nombreActual = (String) tableModel.getValueAt(filaSeleccionada, 1);
        String emailActual = (String) tableModel.getValueAt(filaSeleccionada, 2);

        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombreActual);
        String nuevoEmail = JOptionPane.showInputDialog(this, "Nuevo email:", emailActual);

        if (nuevoNombre != null && nuevoEmail != null) {
            Alumno alumnoEditado = new Alumno(id, nuevoNombre, nuevoEmail);
            alumnoController.actualizarAlumno(alumnoEditado);
            cargarAlumnos();
        }
    }

    /**
     * Elimina el alumno seleccionado.
     */
    private void eliminarAlumno(ActionEvent e) {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para eliminar.");
            return;
        }

        int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este alumno?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            alumnoController.eliminarAlumno(id);
            cargarAlumnos();
        }
    }
}