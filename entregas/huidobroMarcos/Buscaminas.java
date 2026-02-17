package huidobroMarcos;

import java.util.Scanner;
import java.util.Random;

public class Buscaminas {

    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int TOTAL_MINAS = 5;
    private static final int MAX_EXPLOSIONES = 3;

    private static boolean[][] tableroMinas = new boolean[FILAS][COLUMNAS];
    private static char[][] tableroVisible = new char[FILAS][COLUMNAS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generadorAleatorio = new Random();

        System.out.println("Juego Buscaminas iniciado.");

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                tableroVisible[fila][columna] = '-';
            }
        }

        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int filaAleatoria = generadorAleatorio.nextInt(FILAS);
            int columnaAleatoria = generadorAleatorio.nextInt(COLUMNAS);
            if (!tableroMinas[filaAleatoria][columnaAleatoria]) {
                tableroMinas[filaAleatoria][columnaAleatoria] = true;
                minasColocadas++;
            }
        }

        int contadorExplosiones = 0;
        int contadorCeldasLiberadas = 0;

        while (contadorExplosiones < MAX_EXPLOSIONES && contadorCeldasLiberadas < FILAS * COLUMNAS - TOTAL_MINAS) {
            mostrarTablero();

            int filaSeleccionada = -1;
            int columnaSeleccionada = -1;

            while (true) {
                System.out.println("Ingrese fila (X) entre 1 y " + FILAS + ":");
                if (scanner.hasNextInt()) {
                    filaSeleccionada = scanner.nextInt() - 1;
                } else {
                    scanner.next();
                    System.out.println("Entrada inválida. Debe ser un número.");
                    continue;
                }

                System.out.println("Ingrese columna (Y) entre 1 y " + COLUMNAS + ":");
                if (scanner.hasNextInt()) {
                    columnaSeleccionada = scanner.nextInt() - 1;
                } else {
                    scanner.next();
                    System.out.println("Entrada inválida. Debe ser un número.");
                    continue;
                }

                if (filaSeleccionada < 0 || filaSeleccionada >= FILAS || columnaSeleccionada < 0 || columnaSeleccionada >= COLUMNAS) {
                    System.out.println("Posición fuera de rango. Intente de nuevo.");
                    continue;
                }

                if (tableroVisible[filaSeleccionada][columnaSeleccionada] != '-') {
                    System.out.println("Casilla ya revelada. Intente de nuevo.");
                    continue;
                }

                break;
            }

            if (tableroMinas[filaSeleccionada][columnaSeleccionada]) {
                tableroVisible[filaSeleccionada][columnaSeleccionada] = '*';
                contadorExplosiones++;
                System.out.println("Mina!");
            } else {
                tableroVisible[filaSeleccionada][columnaSeleccionada] = '.';
                contadorCeldasLiberadas++;
                System.out.println("Libre!");
            }
        }

        mostrarTablero();

        if (contadorExplosiones == MAX_EXPLOSIONES) {
            System.out.println("Has perdido");
        } else {
            System.out.println("Felicidades, has ganado");
        }
    }

    private static void mostrarTablero() {
        System.out.println("===============");
        System.out.print("  ");
        for (int columna = 1; columna <= COLUMNAS; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();
        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print(tableroVisible[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }
}
