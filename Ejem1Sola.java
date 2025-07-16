/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Semana9;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell 7490
 */
public class Ejem1Sola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos desea ingresar?"));
        
        
        String[] productos = new String[n];
        for (int i = 0; i < n; i++) {
            productos[i] = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1) + ":");
        }
        
        Tienda tienda = new Tienda(productos);
        StringBuilder resultado = new StringBuilder();
        resultado.append(tienda.obtenerMatrizVentas()).append("\n");
        resultado.append(tienda.obtenerVentasPorProducto()).append("\n");
        resultado.append(tienda.obtenerDiaConMasVentas()).append("\n");
        resultado.append(tienda.obtenerProductoMasVendido());

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
