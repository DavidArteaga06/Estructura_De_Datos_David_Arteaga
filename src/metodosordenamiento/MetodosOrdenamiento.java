/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodosordenamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class MetodosOrdenamiento extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JComboBox<String> methodComboBox;
    private JTextField arraySizeField;
    private JButton generateButton;
    private JButton sortButton;
    private JButton exitButton;
    private JTextArea originalArrayArea;
    private JTextArea sortedArrayArea;
    private JLabel timeLabel;
    private JTextArea stepsArea;
    
    private int[] array;
    private int[] originalArray;
    private Random random = new Random();
    
    public MetodosOrdenamiento() {
        setTitle("Metodos de Ordenamiento");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        addListeners();
        
        setVisible(true);
    }
    
    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        
        titleLabel = new JLabel("METODOS DE ORDENAMIENTO", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel controlsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        controlsPanel.add(new JLabel("Seleccione metodo:"));
        String[] methods = {"Metodo Burbuja", "Metodo Secuencial", "Metodo Quicksort"};
        methodComboBox = new JComboBox<>(methods);
        controlsPanel.add(methodComboBox);
        
        controlsPanel.add(new JLabel("Tamaño del arreglo:"));
        arraySizeField = new JTextField("10");
        controlsPanel.add(arraySizeField);
        
        generateButton = new JButton("Generar Arreglo");
        controlsPanel.add(generateButton);
        
        sortButton = new JButton("Ordenar");
        controlsPanel.add(sortButton);
        
        topPanel.add(controlsPanel, BorderLayout.CENTER);
        
        exitButton = new JButton("Salir");
        topPanel.add(exitButton, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        JPanel arraysPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        
        JPanel originalPanel = new JPanel(new BorderLayout());
        originalPanel.add(new JLabel("Arreglo Original:"), BorderLayout.NORTH);
        originalArrayArea = new JTextArea(3, 40);
        originalArrayArea.setEditable(false);
        JScrollPane originalScroll = new JScrollPane(originalArrayArea);
        originalPanel.add(originalScroll, BorderLayout.CENTER);
        arraysPanel.add(originalPanel);
        
        JPanel sortedPanel = new JPanel(new BorderLayout());
        sortedPanel.add(new JLabel("Arreglo Ordenado:"), BorderLayout.NORTH);
        sortedArrayArea = new JTextArea(3, 40);
        sortedArrayArea.setEditable(false);
        JScrollPane sortedScroll = new JScrollPane(sortedArrayArea);
        sortedPanel.add(sortedScroll, BorderLayout.CENTER);
        
        timeLabel = new JLabel("Tiempo: ");
        sortedPanel.add(timeLabel, BorderLayout.SOUTH);
        
        arraysPanel.add(sortedPanel);
        
        mainPanel.add(arraysPanel, BorderLayout.CENTER);
        
        JPanel stepsPanel = new JPanel(new BorderLayout());
        stepsPanel.add(new JLabel("Pasos de ejecucion:"), BorderLayout.NORTH);
        stepsArea = new JTextArea(10, 40);
        stepsArea.setEditable(false);
        JScrollPane stepsScroll = new JScrollPane(stepsArea);
        stepsPanel.add(stepsScroll, BorderLayout.CENTER);
        
        mainPanel.add(stepsPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void addListeners() {
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateArray();
            }
        });
        
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortArray();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    private void generateArray() {
        try {
            int size = Integer.parseInt(arraySizeField.getText());
            if (size <= 0 || size > 1000) {
                JOptionPane.showMessageDialog(this, "El tamaño debe estar entre 1 y 1000", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(100);
            }
            
            originalArray = Arrays.copyOf(array, array.length);
            originalArrayArea.setText(Arrays.toString(array));
            sortedArrayArea.setText("");
            stepsArea.setText("");
            timeLabel.setText("Tiempo: ");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void sortArray() {
        if (array == null || array.length == 0) {
            JOptionPane.showMessageDialog(this, "Primero genere un arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        array = Arrays.copyOf(originalArray, originalArray.length);
        stepsArea.setText("");
        
        int methodIndex = methodComboBox.getSelectedIndex();
        long startTime = System.nanoTime();
        
        switch (methodIndex) {
            case 0:
                bubbleSort(array);
                break;
            case 1:
                selectionSort(array);
                break;
            case 2:
                stepsArea.append("Iniciando QuickSort...\n");
                quickSort(array, 0, array.length - 1);
                break;
        }
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000.0;
        
        sortedArrayArea.setText(Arrays.toString(array));
        timeLabel.setText("Tiempo: " + duration + " ms");
    }
    
    private void bubbleSort(int[] arr) {
        stepsArea.append("Iniciando Metodo Burbuja...\n");
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    if (i % 5 == 0 && j % 5 == 0) {
                        stepsArea.append("Intercambiando " + temp + " y " + arr[j] + "\n");
                    }
                }
            }
            
            if (i % 5 == 0) {
                stepsArea.append("Pasada " + (i+1) + ": " + Arrays.toString(arr) + "\n");
            }
        }
        
        stepsArea.append("Ordenamiento Burbuja completado.\n");
    }
    
    private void selectionSort(int[] arr) {
        stepsArea.append("Iniciando Metodo Secuencial (Seleccion)...\n");
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            
            if (i % 5 == 0) {
                stepsArea.append("Pasada " + (i+1) + ": Colocando " + arr[i] + " en posicion " + i + "\n");
                stepsArea.append("Estado actual: " + Arrays.toString(arr) + "\n");
            }
        }
        
        stepsArea.append("Ordenamiento Secuencial completado.\n");
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            stepsArea.append("Pivote: " + arr[pi] + " en posicion " + pi + "\n");
            stepsArea.append("Subarreglo actual: " + Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)) + "\n");
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MetodosOrdenamiento z = new MetodosOrdenamiento();
            }
        });
    }
}