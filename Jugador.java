/**
 * Clase Main
 * Universidad del Valle de Guatemala
 * Facultad de ingeniería
 * Programacion orientada a objetos
 * Segundo ciclo
 * Estudiante: Julio Fernando Ortiz Alvarado - 251190
 * Instructor: Ing. Erick Francisco Marroquìn Rodríguez
 * Ejercicio 3: Arreglos dinámicos
 * Fecha de creación: 31/08/2025
 * Fecha de última modificación
 * Descripción: Interfaz de usuario en consola para manejar el sistema del gimnasio.
 */
import java.util.*;

class Jugador {
    private int idJugador;
    private String nomJugador;
    private int puntJugador;
    private boolean turnoActivo;

    public Jugador(int id, String nombre) {
        this.idJugador = id;
        this.nomJugador = nombre;
        this.puntJugador = 0;
        this.turnoActivo = false;
    }

    public void sumarPunto() {
        this.puntJugador++;
    }

    public void activarTurno() {
        this.turnoActivo = true;
    }

    public void desactivarTurno() {
        this.turnoActivo = false;
    }

    public int getPuntaje() {
        return this.puntJugador;
    }

    public String getNombre() {
        return this.nomJugador;
    }

    @Override
    public String toString() {
        return "Jugador: " + nomJugador + " | Puntos: " + puntJugador;
    }
}