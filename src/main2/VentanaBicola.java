/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.DefaultListModel;

public class VentanaBicola extends JFrame {
    private JTextField entrada;
    private final JList<String> listaValores;
    private final DefaultListModel<String> modeloLista;
    private Bicola bicola;

    public VentanaBicola() {
        setTitle("Bicola con Lista Simple");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        bicola = new Bicola();
        entrada = new JTextField(10);
        modeloLista = new DefaultListModel<>();
        listaValores = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaValores);

        // Panel superior con campo de entrada
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Valor:"));
        panelSuperior.add(entrada);

        // Panel de botones con mejor distribución
        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnIzq = new JButton("Insertar izquierda");
        JButton btnDer = new JButton("Insertar derecha");
        JButton btnAtiIzq = new JButton("Atender izquierda");
        JButton btnAtiDer = new JButton("Atender derecha");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnIzq);
        panelBotones.add(btnDer);
        panelBotones.add(btnAtiIzq);
        panelBotones.add(btnAtiDer);
        panelBotones.add(btnSalir);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Acción para insertar desde la izquierda
        btnIzq.addActionListener(e -> {
            try {
                int val = Integer.parseInt(entrada.getText());
                bicola.insertarIzquierda(val);
                entrada.setText("");
                actualizarLista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción para insertar desde la derecha
        btnDer.addActionListener(e -> {
            try {
                int val = Integer.parseInt(entrada.getText());
                bicola.insertarDerecha(val);
                entrada.setText("");
                actualizarLista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Atender por la izquierda y actualizar
        btnAtiIzq.addActionListener(e -> {
            Integer val = bicola.atenderIzquierda();
            JOptionPane.showMessageDialog(this, "Atendido izquierda: " + val, "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
            actualizarLista();
        });

        // Atender por la derecha y actualizar
        btnAtiDer.addActionListener(e -> {
            Integer val = bicola.atenderDerecha();
            JOptionPane.showMessageDialog(this, "Atendido derecha: " + val, "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
            actualizarLista();
        });

        // Salir
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void actualizarLista() {
        modeloLista.clear();
        for (String valor : bicola.listar().split(" ")) {
            modeloLista.addElement(valor);
        }
    }
}