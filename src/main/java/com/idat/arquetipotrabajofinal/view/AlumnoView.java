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
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlumnoView extends JFrame {
    
    private static final Logger LOGGER = LogManager.getLogger(AlumnoView.class);
    
    private JTable alumnoTable;
    private DefaultTableModel tableModel;
    private JButton btnMostrar, btnLimpiar, btnAgregar, btnActualizar, btnEliminar;
    private JTextField txtNombre, txtEmail;
    private AlumnoController alumnoController;

    public AlumnoView() {
        alumnoController = new AlumnoController();

        setTitle("Registro de Alumnos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 📌 Modelo de la tabla
        String[] columnNames = {"ID", "Nombre", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        alumnoTable = new JTable(tableModel);
        add(new JScrollPane(alumnoTable), BorderLayout.CENTER);

        // 📌 Panel de entrada de datos
        JPanel panelDatos = new JPanel(new GridLayout(2, 2));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panelDatos.add(txtEmail);
        add(panelDatos, BorderLayout.NORTH);

        // 📌 Panel de botones
        JPanel panelBotones = new JPanel();
        btnMostrar = new JButton("Mostrar");
        btnLimpiar = new JButton("Limpiar");
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        // 📌 Cargar datos al iniciar
        cargarDatos();

        // 📌 Eventos de botones
        btnMostrar.addActionListener(e -> cargarDatos());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnAgregar.addActionListener(e -> agregarAlumno());
        btnActualizar.addActionListener(e -> actualizarAlumno());
        btnEliminar.addActionListener(e -> eliminarAlumno());
    }

    // ✅ Cargar datos en la tabla
    private void cargarDatos() {
        tableModel.setRowCount(0); // Limpiar tabla
        List<Alumno> alumnos = alumnoController.obtenerAlumnos();

        for (Alumno alumno : alumnos) {
            tableModel.addRow(new Object[]{alumno.getId(), alumno.getName(), alumno.getEmail()});
        }
        LOGGER.info("Datos cargados en la tabla.");
    }

    // ✅ Limpiar los campos de entrada
    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
        alumnoTable.clearSelection();
    }

    // ✅ Agregar nuevo alumno
    private void agregarAlumno() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();

        if (!nombre.isEmpty() && !email.isEmpty()) {
            Alumno nuevoAlumno = new Alumno(0, nombre, email);
            alumnoController.agregarAlumno(nuevoAlumno);
            cargarDatos();
            limpiarCampos();
            LOGGER.info("Alumno agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    // ✅ Actualizar alumno seleccionado
    private void actualizarAlumno() {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) tableModel.getValueAt(filaSeleccionada, 0);
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();

            if (!nombre.isEmpty() && !email.isEmpty()) {
                Alumno alumnoActualizado = new Alumno(id, nombre, email);
                alumnoController.actualizarAlumno(alumnoActualizado);
                cargarDatos();
                limpiarCampos();
                LOGGER.info("Alumno actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para actualizar.");
        }
    }

    // ✅ Eliminar alumno seleccionado
    private void eliminarAlumno() {
        int filaSeleccionada = alumnoTable.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) tableModel.getValueAt(filaSeleccionada, 0);

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que desea eliminar al alumno?", "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                alumnoController.eliminarAlumno(id);
                cargarDatos();
                limpiarCampos();
                LOGGER.info("Alumno eliminado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para eliminar.");
        }
    }
}