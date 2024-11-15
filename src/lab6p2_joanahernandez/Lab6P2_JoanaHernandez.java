/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p2_joanahernandez;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author joana
 */
public class Lab6P2_JoanaHernandez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tabla de verdad");
            System.out.println("2. Triangulo de patrones");
            System.out.println("3. Intercambio de filas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    tablas();
                    break;
                case 2:
                   // rotacionCircular();
                    break;
                case 3:
                    //bono();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while(opcion != 4);
    } // fin main
 
    public static void tablas() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ingrese tamano:");
        int fila = scanner.nextInt();
        int col = 2;
        
        String [][] matriz = new String[fila][col];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                matriz[i][j] = String.valueOf(random.nextInt(0) + 1);
            }
        }
        System.out.println("Matriz original:");
        printing(matriz);
        
    } //fin tablas
    
    public static void printing(String[][] matriz) {
        for (String[] fila : matriz) {
            for (String valor : fila) {
                System.out.print("[" + valor + "]");
            }
            System.out.println();
        }
    }
    
} // fin programa
