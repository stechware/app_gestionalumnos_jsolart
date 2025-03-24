/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Solaris
 */
public class FooterPanel extends JPanel{
    public FooterPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(230, 230, 230)); // Color gris claro

        JLabel lblCopyright = new JLabel("© 2025 Sistema de Registro de Alumnos - Todos los derechos reservados.");
        lblCopyright.setFont(new Font("Arial", Font.PLAIN, 12));

        add(lblCopyright);
        
        JLabel lblCurso = new JLabel("IDAT - Desarrollo Avanzado de Aplicaciones");
        lblCurso.setFont(new Font("Arial", Font.PLAIN, 12));

        add(lblCurso);
    }
}
