/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main2;

import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        Scanner scanner = new Scanner(System.in);
        ListaSimple listaClientes = new ListaSimple();
        int opcion;

        do {
            try {
                System.out.println("\n===== GESTIÓN DE CLIENTES =====");
                System.out.println("1. Insertar cliente");
                System.out.println("2. Listar clientes hacia la derecha");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> insertarCliente(scanner, listaClientes);
                    case 2 -> listaClientes.listarClientes();
                    case 3 -> System.out.println("Gracias por usar la aplicación. ¡Hasta pronto!");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = 0;
            }
        } while (opcion != 3);
    }

    /**
     * Método para insertar un cliente en la lista.
     */
    private static void insertarCliente(Scanner scanner, ListaSimple lista) {
        System.out.println("\n--- INSERTAR NUEVO CLIENTE ---");

        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(cedula, nombre);
        lista.insertarOrdenado(nuevoCliente);

        System.out.println("Cliente insertado correctamente.");
    }
}
