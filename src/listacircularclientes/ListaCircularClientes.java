/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listacircularclientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListaCircularClientes extends JFrame {
    
    private final JTextField cedulaField;
    private final JTextField nombreField;
    private final JTextArea resultadoArea;
    private final JButton insertarButton;
    private final JButton listarButton;
    private final JButton salirButton;
    
    // Variables de la lista circular
    private Nodo inicio = null;
    
    public ListaCircularClientes() {
        // Configuracion de la ventana principal
        setTitle("Lista Circular de Clientes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de formulario para insertar clientes
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Insertar Cliente"));
        
        formPanel.add(new JLabel("Cedula:"));
        cedulaField = new JTextField(10);
        formPanel.add(cedulaField);
        
        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        formPanel.add(nombreField);
        
        insertarButton = new JButton("Insertar Cliente");
        insertarButton.addActionListener((ActionEvent e) -> {
            insertarCliente();
        });
        formPanel.add(insertarButton);
        
        mainPanel.add(formPanel, BorderLayout.NORTH);
        
        // Panel central para mostrar resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones para acciones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        listarButton = new JButton("Listar Clientes");
        listarButton.addActionListener((ActionEvent e) -> {
            listarClientes();
        });
        buttonPanel.add(listarButton);
        
        salirButton = new JButton("Salir");
        salirButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        buttonPanel.add(salirButton);
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Agregar panel principal a la ventana
        add(mainPanel);
    }
    
    // Metodo para insertar un cliente en la lista circular
    private void insertarCliente() {
        String cedula = cedulaField.getText().trim();
        String nombre = nombreField.getText().trim();
        
        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese cedula y nombre del cliente", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Nodo nuevoNodo = new Nodo(cedula, nombre);
        
        // Si la lista esta vacia
        if (inicio == null) {
            inicio = nuevoNodo;
            nuevoNodo.siguiente = inicio; // Apunta a si mismo (circular)
        } else {
            // Encontrar el ultimo nodo
            Nodo ultimo = inicio;
            while (ultimo.siguiente != inicio) {
                ultimo = ultimo.siguiente;
            }
            
            // Insertar el nuevo nodo al final
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente = inicio;
        }
        
        
        JOptionPane.showMessageDialog(this, "Cliente insertado correctamente", 
                "Exito", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar campos
        cedulaField.setText("");
        nombreField.setText("");
        cedulaField.requestFocus();
    }
    
    // Metodo para listar todos los clientes
    private void listarClientes() {
        if (inicio == null) {
            resultadoArea.setText("No hay clientes en la lista.");
            return;
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("LISTA DE CLIENTES:\n\n");
        
        Nodo actual = inicio;
        int contador = 1;
        
        do {
            resultado.append(contador).append(". Cedula: ").append(actual.cedula)
                    .append(" - Nombre: ").append(actual.nombre).append("\n");
            actual = actual.siguiente;
            contador++;
        } while (actual != inicio);
        
        resultadoArea.setText(resultado.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListaCircularClientes().setVisible(true);
        });
    }

   
}