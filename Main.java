/**
 * Clase Ficha
 * Universidad del Valle de Guatemala
 * Facultad de ingeniería
 * Programacion orientada a objetos
 * Segundo ciclo
 * Estudiante: Julio Fernando Ortiz Alvarado - 251190
 * Instructor: Ing. Erick Francisco Marroquìn Rodríguez
 * Laboratorio 2. Arreglos y excepciones
 * Fecha de creación: 07/09/2025
 * Fecha de última modificación: 08/09/2025
 * Descripción: Clase principal que maneja la interacción en consola con el usuario
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("=== JUEGO DE MEMORIA ===");

            System.out.print("Nombre Jugador 1: ");
            Jugador j1 = new Jugador(1, sc.nextLine());

            System.out.print("Nombre Jugador 2: ");
            Jugador j2 = new Jugador(2, sc.nextLine());

            int tamaño = 0;
            boolean valido = false;
            while (!valido) {
                try {
                    System.out.print("Ingrese tamaño del tablero (par, mayor a 2): ");
                    tamaño = sc.nextInt();
                    new Tablero(tamaño);
                    valido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            Partida partida = new Partida(j1, j2, tamaño);

            while (!partida.partidaFinalizada()) {
                System.out.println("\nTurno de: " + partida.getTurnoActual().getNombre());
                partida.mostrarTablero();

                try {
                    System.out.print("Seleccione ficha (0 - " + (tamaño*tamaño-1) + "): ");
                    int pos = sc.nextInt();
                    partida.revelarFicha(pos);
                } catch (Exception e) {
                    System.out.println("Movimiento inválido: " + e.getMessage());
                }
            }

            System.out.println("\n=== RESULTADOS FINALES ===");
            partida.mostrarResultados();
            Jugador ganador = partida.declararGanador();
            if (ganador != null)
                System.out.println("Ganador: " + ganador.getNombre());
            else
                System.out.println("La partida terminó en empate.");

        } finally {
            sc.close();
        }
    }
}

