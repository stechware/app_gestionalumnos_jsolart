/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Solaris
 */
public class BuscarAlumnoView extends JFrame{
    private JTextField txtBuscar;
    private JButton btnBuscar;

    public BuscarAlumnoView() {
        setTitle("Buscar Alumno");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBuscar = new JLabel("Ingrese Nombre:");
        lblBuscar.setBounds(20, 20, 120, 25);
        add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(150, 20, 200, 25);
        add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 60, 100, 30);
        add(btnBuscar);
    }
}
