/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main2;

/**
 *
 * @author Estudiante
 */
public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    /**
     * Inserta un cliente en la lista de forma ordenada por cédula.
     * @param nuevoCliente
     */
    public void insertarOrdenado(Cliente nuevoCliente) {
        Nodo nuevoNodo = new Nodo(nuevoCliente);

        if (cabeza == null || nuevoCliente.getCedula().compareTo(cabeza.cliente.getCedula()) < 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && nuevoCliente.getCedula().compareTo(actual.siguiente.cliente.getCedula()) > 0) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    /**
     * Lista todos los clientes desde el primer nodo hasta el último.
     */
    public void listarClientes() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("\n--- Lista de Clientes ---");
        while (actual != null) {
            System.out.println(actual.cliente);
            actual = actual.siguiente;
        }
    }
}
