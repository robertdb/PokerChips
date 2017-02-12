package ram.pokerChips.modelo;

import java.util.ArrayList;

/**
 * Created by Marcos on 09/02/2017.
 */

public class EstructuraDeCiegas {
    private int cantidadDeFichasIniciales = 1500; // Por ahora...
    private ArrayList<NivelDeCiegas> nivelesDeCiegas;
    private int nivelActual;

    public EstructuraDeCiegas() {
        nivelesDeCiegas = new ArrayList<>();
        cargarNivelesDeCiegaChica();
        nivelActual = 1;
    }

    /*
     * Sacado de un sit and go turbo de PokerStars con 1500 fichas iniciales
     */
    private void cargarNivelesDeCiegaChica() {
        nivelesDeCiegas.add(new NivelDeCiegas(1, 10, 20, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(2, 15, 30, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(3, 25, 50, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(4, 50, 100, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(5, 75, 150, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(6, 100, 200, 0, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(7, 100, 200, 25, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(8, 150, 300, 25, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(9, 200, 400, 25, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(10, 300, 600, 50, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(11, 400, 800, 50, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(12, 600, 1200, 75, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(13, 800, 1600, 75, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(14, 1000, 2000, 100, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(15, 1500, 3000, 150, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(16, 2000, 4000, 200, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(17, 3000, 6000, 300, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(18, 4000, 8000, 400, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(19, 6000, 12000, 600, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(20, 8000, 16000, 800, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(21, 10000, 20000, 1000, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(22, 15000, 30000, 1500, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(23, 20000, 40000, 2000, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(24, 25000, 50000, 2500, 5));
        nivelesDeCiegas.add(new NivelDeCiegas(25, 30000, 60000, 3000, 5));
    }

    public NivelDeCiegas getNivelDeCiegasActual() {
        return nivelesDeCiegas.get(nivelActual - 1);
    }

    public void avanzarDeNivelDeCiegas() {
        if (nivelesDeCiegas.size() > nivelActual) {
            nivelActual++;
        }
    }
}
