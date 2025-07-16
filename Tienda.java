/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana9;

import java.util.Random;
//import javax.swing.JOptionPane;

/**
 *
 * @author Dell 7490
 */
public class Tienda {

    private String[] productos;
    private int[][] ventas;
    private final String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", " domingo"};

    public Tienda() { //constructor vacío
    }
   
    public Tienda(String[] productos) { //constructor con los atributos
        this.productos = productos;
        this.ventas = new int[7][productos.length]; //para que el primero sea matriz 7xN
        generarVentasAleatorias();
    }
    private void generarVentasAleatorias() {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < productos.length; j++) {
                ventas[i][j] = rand.nextInt(10); // entre 0 y 9
            }
        }
    }
    /* esto para solicitarle los datos a la persona
    
    private void solicitarVentas() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < productos.length; j++) {
                String input;
                int cantidad;
                do {
                    input = JOptionPane.showInputDialog("Ingrese ventas de " + productos[j] + " el " + dias[i] + ":");
                    try {
                        cantidad = Integer.parseInt(input);
                        if (cantidad < 0) throw new NumberFormatException();
                        ventas[i][j] = cantidad;
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero válido (mayor o igual a 0).");
                    }
                } while (true);
            }
        }
    }
    */
     
    
    public String obtenerMatrizVentas() {
        StringBuilder sb = new StringBuilder("Matriz de ventas:\n");
        sb.append(String.format("%-12s", "Día"));
        for (String prod : productos) {
            sb.append(String.format("%-10s", prod));
        }
        sb.append("\n");

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%-12s", dias[i]));
            for (int j = 0; j < productos.length; j++) {
                sb.append(String.format("%-10d", ventas[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public String obtenerVentasPorProducto() {
        StringBuilder sb = new StringBuilder("Total de ventas por producto:\n");
        for (int j = 0; j < productos.length; j++) {
            int total = 0;
            for (int i = 0; i < 7; i++) {
                total += ventas[i][j];
            }
            sb.append(productos[j]).append(": ").append(total).append("\n");
        }
        return sb.toString();
    }
    public String obtenerDiaConMasVentas() {
        int max = 0;
        int indice = 0;

        for (int i = 0; i < 7; i++) {
            int total = 0;
            for (int j = 0; j < productos.length; j++) {
                total += ventas[i][j];
            }
            if (total > max) {
                max = total;
                indice = i;
            }
        }
        return "Día con más ventas: " + dias[indice] + " (Total: " + max + ")";
    }
    public String obtenerProductoMasVendido() {
        int max = 0;
        int indice = 0;

        for (int j = 0; j < productos.length; j++) {
            int total = 0;
            for (int i = 0; i < 7; i++) {
                total += ventas[i][j];
            }
            if (total > max) {
                max = total;
                indice = j;
            }
        }

        return "Producto más vendido: " + productos[indice] + " (Total: " + max + ")";
    }
}