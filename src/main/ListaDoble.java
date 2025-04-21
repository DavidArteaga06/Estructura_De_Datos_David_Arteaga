/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Estudiante
 */
public class ListaDoble {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;
    
    public ListaDoble() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    
    public boolean estaVacia() {
        return primero == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public void insertarOrdenado(Cliente cliente) {
    Nodo nuevoNodo = new Nodo(cliente);
    
    // Caso 1: Lista vacía
    if (estaVacia()) {
        primero = nuevoNodo;
        ultimo = nuevoNodo;
    } 
    // Caso 2: Insertar al inicio (cédula menor que la del primero)
    else if (cliente.getCedula().compareTo(primero.getCliente().getCedula()) < 0) {
        nuevoNodo.setSiguiente(primero);
        primero.setAnterior(nuevoNodo);
        primero = nuevoNodo;
    } 
    // Caso 3: Insertar al final (cédula mayor que la del último)
    else if (cliente.getCedula().compareTo(ultimo.getCliente().getCedula()) > 0) {
        ultimo.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(ultimo);
        ultimo = nuevoNodo;
    } 
    // Caso 4: Insertar en medio de la lista
    else {
        Nodo actual = primero;
        // Recorremos hasta encontrar la posición correcta
        while (actual != null && cliente.getCedula().compareTo(actual.getCliente().getCedula()) > 0) {
            actual = actual.getSiguiente();
        }
        
        // Verificar si ya existe la cédula o si el nodo actual es nulo
        if (actual == null) {
            // Debería ser manejado por el caso 3, pero por seguridad:
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        } 
        else if (cliente.getCedula().equals(actual.getCliente().getCedula())) {
            System.out.println("Error: Ya existe un cliente con la cédula " + cliente.getCedula());
            return;
        } 
        else {
            // Insertar antes del nodo actual
            nuevoNodo.setSiguiente(actual);
            
            // Verificar que actual.getAnterior() no sea null
            if (actual.getAnterior() != null) {
                nuevoNodo.setAnterior(actual.getAnterior());
                actual.getAnterior().setSiguiente(nuevoNodo);
            }
            
            actual.setAnterior(nuevoNodo);
        }
    }
    
    tamaño++;
}
    
    public void listarHaciaDerecha() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE CLIENTES (HACIA LA DERECHA) ---");
        Nodo actual = primero;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". " + actual.getCliente().toString());
            actual = actual.getSiguiente();
            contador++;
        }
        System.out.println("Total de clientes: " + tamaño);
    }
    
    public void listarHaciaIzquierda() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE CLIENTES (HACIA LA IZQUIERDA) ---");
        Nodo actual = ultimo;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". " + actual.getCliente().toString());
            actual = actual.getAnterior();
            contador++;
        }
        System.out.println("Total de clientes: " + tamaño);
    }
}

