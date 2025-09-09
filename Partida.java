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

class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private Jugador turnoActual;
    private ArrayList<Ficha> revealFichas;

    public Partida(Jugador j1, Jugador j2, int tamañoTablero) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.turnoActual = j1;
        this.revealFichas = new ArrayList<>();
        this.tablero = new Tablero(tamañoTablero);
    }

    public void revelarFicha(int pos) {
        Ficha f = tablero.obtenerFicha(pos);
        if (f.isEmparejada() || f.isVisible()) {
            throw new IllegalStateException("Ficha inválida para revelar.");
        }
        f.revelar();
        revealFichas.add(f);

        if (revealFichas.size() == 2) {
            evaluarPareja();
        }
    }

    private void evaluarPareja() {
        Ficha f1 = revealFichas.get(0);
        Ficha f2 = revealFichas.get(1);

        if (f1.getEmoji().equals(f2.getEmoji())) {
            f1.emparejar();
            f2.emparejar();
            turnoActual.sumarPunto();
        } else {
            f1.ocultar();
            f2.ocultar();
            cambiarTurno();
        }
        revealFichas.clear();
    }

    private void cambiarTurno() {
        if (turnoActual == jugador1) turnoActual = jugador2;
        else turnoActual = jugador1;
    }

    public boolean partidaFinalizada() {
        return !tablero.quedanFichasOcultas();
    }

    public void mostrarResultados() {
        System.out.println(jugador1);
        System.out.println(jugador2);
    }

    public Jugador declararGanador() {
        if (jugador1.getPuntaje() > jugador2.getPuntaje()) return jugador1;
        else if (jugador2.getPuntaje() > jugador1.getPuntaje()) return jugador2;
        else return null; // empate
    }

    public void mostrarTablero() {
        tablero.mostrarTablero();
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }
}