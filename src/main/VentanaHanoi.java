/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;

public class VentanaHanoi extends JFrame {
    public VentanaHanoi() {
        setTitle("Torres de Hanoi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        PanelHanoi panel = new PanelHanoi();
        add(panel);
        setVisible(true);
        panel.iniciar();
    }
}
