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
 * Descripción: Representa cada ficha del tablero.
 */

class Ficha {
    private int idFicha;
    private String emogiFicha;
    private boolean emparejada;
    private boolean visible;

    public Ficha(int id, String emoji) {
        this.idFicha = id;
        this.emogiFicha = emoji;
        this.emparejada = false;
        this.visible = false;
    }

    public void revelar() {
        if (!emparejada) visible = true;
    }

    public void ocultar() {
        if (!emparejada) visible = false;
    }

    public void emparejar() {
        this.emparejada = true;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getEmoji() {
        return emogiFicha;
    }

    @Override
    public String toString() {
        return (visible || emparejada) ? emogiFicha : "❓";
    }
}
