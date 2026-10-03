package main.java.co.laberinto.Laberintos;

import java.util.Scanner;

public class Laberinto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] laberinto = new int[7][7];
        int tareasCompletadas = 0;
        int tareasObjetivo = 5;
        int jugadorFila = 1;
        int jugadorCol = 1;
        generarNuevoMapa(laberinto, tareasCompletadas);
        while (tareasCompletadas < tareasObjetivo) {
            if (laberinto[jugadorFila][jugadorCol] == 3) {
                tareasCompletadas++;
                System.out.println("\n¡Excelente! Tarea completada (" + tareasCompletadas + "/" + tareasObjetivo + ")");
                if (tareasCompletadas < tareasObjetivo) {
                    System.out.println("¡Generando el siguiente nivel del laberinto...!\n");
                    generarNuevoMapa(laberinto, tareasCompletadas);
                    jugadorFila = 1;
                    jugadorCol = 1;
                }
            }
        }
        System.out.println("¡Felicidades! Completaste todas las tareas y escapaste del laberinto infinito.");
        scanner.close();
    }
    public static void generarNuevoMapa(int[][] matriz, int nivel) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 || i == matriz.length - 1 || j == 0 || j == matriz[i].length - 1) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        matriz[matriz.length - 2][matriz[0].length - 2] = 3;
    }
}
