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

class Tablero {
    private int tamaño;
    private ArrayList<Ficha> fichas;

    public Tablero(int tamaño) throws IllegalArgumentException {
        if (!esCompatible(tamaño)) {
            throw new IllegalArgumentException("El tamaño debe ser par y mayor a 2.");
        }
        this.tamaño = tamaño;
        this.fichas = new ArrayList<>();
        generarTablero(tamaño);
    }

    public boolean esCompatible(int tamaño) {
        return tamaño > 2 && tamaño % 2 == 0;
    }

    private void generarTablero(int tamaño) {
        String[] emojis = {"🐶","🐱","🐭","🐹","🐰","🦊","🐻","🐼",
                           "🐨","🐯","🦁","🐮","🐷","🐸","🐵","🐤"};

        Collections.shuffle(Arrays.asList(emojis)); 
        int numPairs = (tamaño * tamaño) / 2;
        int id = 0;

        for (int i = 0; i < numPairs; i++) {
            String emoji = emojis[i % emojis.length];
            fichas.add(new Ficha(id++, emoji));
            fichas.add(new Ficha(id++, emoji));
        }

        Collections.shuffle(fichas);
    }

    public Ficha obtenerFicha(int pos) {
        if (pos < 0 || pos >= fichas.size()) {
            throw new IndexOutOfBoundsException("Posición inválida.");
        }
        return fichas.get(pos);
    }

    public boolean quedanFichasOcultas() {
        for (Ficha f : fichas) {
            if (!f.isEmparejada()) return true;
        }
        return false;
    }

    public void mostrarTablero() {
        int n = tamaño;
        for (int i = 0; i < fichas.size(); i++) {
            System.out.print(fichas.get(i) + " ");
            if ((i+1) % n == 0) System.out.println();
        }
    }

    public int getTamaño() {
        return tamaño;
    }
}