/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.arquetipotrabajofinal.controller;

import com.idat.arquetipotrabajofinal.view.LoginView;
import com.idat.arquetipotrabajofinal.view.MainView;

/**
 *
 * @author Solaris
 */
public class MainController {
    
    private MainView mainView;
    private LoginView loginView;

    public MainController() {
        // Mostrar la pantalla de login primero
        loginView = new LoginView(this);
        loginView.setVisible(true);
    }

    public void onLoginSuccess() {
        // Si el login es correcto, se cierra la ventana de login y se abre el menú principal
        loginView.dispose();
        mainView = new MainView();
        mainView.setVisible(true);
    }   
}
