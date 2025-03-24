/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.view;

import com.idat.arquetipotrabajofinal.controller.MainController;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Solaris
 */
public class LoginView extends JFrame{
    
    private static final Logger logger = LogManager.getLogger(MainController.class);
    
    /*
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private MainController controller;

    public LoginView(MainController controller) {
        this.controller = controller;
        
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuario:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Ingresar");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
        add(loginButton);
    }

    private void validarLogin() {
        String usuario = usernameField.getText();
        String clave = new String(passwordField.getPassword());

        // Validación simple
        if (usuario.equals("admin") && clave.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            controller.onLoginSuccess();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private MainController controller;

    public LoginView(MainController controller) {
        
        this.controller = controller;
        
        setTitle("Login");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Panel principal con padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes
        
        // Etiqueta Usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        // Campo Usuario
        gbc.gridx = 1;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        // Etiqueta Contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Contraseña:"), gbc);

        // Campo Contraseña
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Botón de Login centrado
        loginButton = new JButton("Ingresar");
        loginButton.setBackground(new Color(51, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(e -> validarLogin());
        usernameField.addKeyListener(new EnterKeyListener());
        passwordField.addKeyListener(new EnterKeyListener());

        add(panel);
    }

    private void validarLogin() {
        String usuario = usernameField.getText();
        String clave = new String(passwordField.getPassword());

        // Validación simple
        if (usuario.equals("admin") && clave.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            logger.info("Inicio de sesión exitoso");
            controller.onLoginSuccess();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       // Clase interna para detectar tecla Enter
    private class EnterKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                validarLogin();
            }
        }
    }
}
