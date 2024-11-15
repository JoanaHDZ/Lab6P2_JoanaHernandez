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
                    System.out.println();
                    break;
                case 2:
                   triangulo();
                    System.out.println();
                    break;
                case 3:
                    intercambio();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Salida");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while(opcion != 4);
    } // fin main
 
    public static void tablas() {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Ingrese tamano:");
       int filas = sc.nextInt();
        boolean[][] matriz = new boolean[filas][2];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            matriz[i][0] = random.nextBoolean();
            matriz[i][1] = random.nextBoolean();
        }
        
        System.out.println("Matriz generada:");
        for (boolean[] fila : matriz) {
            System.out.println((fila[0] ? 1 : 0) + " " + (fila[1] ? 1 : 0));
        }
        
        System.out.println("Ingrese operacion logica (pvq) (p^q)");
        String op = sc.next();
        
        boolean [][] resultado = new boolean [filas][3];
        for (int i = 0; i < filas; i++) {
            resultado[i][0] = matriz[i][0];
            resultado[i][1] = matriz[i][1];
            if (op.equals("pvq")) {
                resultado[i][2] = matriz[i][0] || matriz[i][1];
            } else if (op.equals("p^q")) {
                resultado[i][2] = matriz[i][0] && matriz[i][1];
            }
        }
        
        System.out.println("Resultado:");
        for (boolean[] fila : resultado) {
            System.out.println((fila[0] ? 1 : 0) + " " + (fila[1] ? 1 : 0) + " " + (fila[2] ? 1 : 0));
        }
        
    } //fin tablas
    
    public static void triangulo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tamano");
        int tam = sc.nextInt();
        int [][] piramide = new int [tam][tam];
        
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    piramide[i][j] = 1; 
                } else {
                    piramide[i][j] = piramide[i - 1][j - 1] + piramide[i - 1][j];
                }
            }
        }

        
        System.out.println("Piramide:");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("[" + piramide[i][j] + "]");
            }
            System.out.println();
        }
    }//fin triangulo
    
    public static void intercambio (){
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Ingrese tamano de matriz) ");
        int n = sc.nextInt();
        int [][] matriz = new int[n][n];
        
        for (int i =0; i < n; i++) {
            for (int j=0; j<n; j++) {
                matriz[i][j] = ran.nextInt(10);
            }
        }
        
         System.out.println("Matriz original:");
        for (int[] fila : matriz) {
            for (int val : fila) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        
        System.out.println("Ingrese el cambio... ejemplo: f1-c1");
        String cambio = sc.next();
        String [] part1 = cambio.split("-");
        char tipo1 = part1[0].charAt(0);
        int num1 = Integer.parseInt(part1[0].substring(1));
        char tipo2 = part1[1].charAt(0);
        int num2 = Integer.parseInt(part1[1].substring(1));
        
        if(tipo1 == 'f' && tipo1 == 'f') {
            int[] x = matriz[num1];
            matriz[num1] = matriz[num2];
            matriz[num2] = x;
        } else if (tipo1 == 'f' && tipo2 == 'c') {
            for (int i = 0; i < n; i++) {
                int x = matriz[num1][i];
                matriz[num1][i] = matriz[i][num2];
                matriz[i][num2] = x;
            }
        } else if (tipo1 == 'c' && tipo2 == 'c') {
            for (int i = 0; i < n; i++) {
                int x = matriz[i][num1];
                matriz[i][num1] = matriz[i][num2];
                matriz[i][num2] = x;
            }
        } else if (tipo1 == 'c' && tipo2 == 'f') {
            for (int i = 0; i < n; i++) {
                int x = matriz[i][num2];
                matriz[i][num2] = matriz[i][num1];
                matriz[i][num1] = x;
            }
        }
        
        System.out.println("Matriz modificada:");
        for (int[] fila : matriz) {
            for (int i : fila) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }//fin intercambio
    
} // fin programa
