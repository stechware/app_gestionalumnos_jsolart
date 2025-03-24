/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import com.idat.arquetipotrabajofinal.controller.AlumnoController;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

import com.idat.arquetipotrabajofinal.model.Alumno;

/**
 *
 * @author Solaris
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlumnoView extends JFrame {

    private static final Logger logger = LogManager.getLogger(AlumnoView.class);

    private JTable alumnoTable;
    private DefaultTableModel tableModel;
    private JTextField txtNombre, txtEmail;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnRefrescar;
    private AlumnoController alumnoController;

    public AlumnoView() {
        alumnoController = new AlumnoController();

        setTitle("Registro de Alumnos");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(2, 2, 5, 5));
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelFormulario.add(txtEmail);
        add(panelFormulario, BorderLayout.NORTH);

        // Tabla de alumnos
        String[] columnNames = {"ID", "Nombre", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        alumnoTable = new JTable(tableModel);
        add(new JScrollPane(alumnoTable), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnRefrescar = new JButton("Refrescar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);
        add(panelBotones, BorderLayout.SOUTH);

        // Cargar datos al inicio
        cargarAlumnos();

        // Eventos de botones
        btnAgregar.addActionListener(e -> agregarAlumno());
        btnActualizar.addActionListener(e -> actualizarAlumno());
        btnEliminar.addActionListener(e -> eliminarAlumno());
        btnRefrescar.addActionListener(e -> cargarAlumnos());
    }

    private void cargarAlumnos() {
        List<Alumno> alumnos = alumnoController.obtenerAlumnos();
        tableModel.setRowCount(0); // Limpiar la tabla

        for (Alumno alumno : alumnos) {
            tableModel.addRow(new Object[]{alumno.getId(), alumno.getName(), alumno.getEmail()});
        }
    }

    private void agregarAlumno() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese todos los datos.");
            return;
        }

        boolean resultado = alumnoController.agregarAlumno(nombre, email);
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Alumno agregado correctamente.");
            cargarAlumnos();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar alumno.");
        }
    }

    private void actualizarAlumno() {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para actualizar.");
            return;
        }

        int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese los nuevos datos.");
            return;
        }

        boolean resultado = alumnoController.actualizarAlumno(id, nombre, email);
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Alumno actualizado.");
            cargarAlumnos();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }

    private void eliminarAlumno() {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para eliminar.");
            return;
        }

        int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean resultado = alumnoController.eliminarAlumno(id);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Alumno eliminado.");
                cargarAlumnos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
    }
}