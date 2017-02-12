package ram.pokerChips.modelo;

import ram.pokerChips.error.PozoDesbordadoPorFichasError;

/**
 * Created by Robert on 27/1/17.
 */
public class Pozo {

    private int maximoFichas;

    private int fichasActuales = 0;

    public Pozo(int cantidadMaximaDeFichas) {

        this.maximoFichas = cantidadMaximaDeFichas;

    }

    // Este constructor es opcional, se carga con las apuestas obligatorias.
    public Pozo(int cantidadMaximaDeFichas, int cantidadCiegaChica) {

        this.maximoFichas = cantidadMaximaDeFichas;

        this.agregarFichas(cantidadCiegaChica + (cantidadCiegaChica * 2));

    }

    public void agregarFichas(int fichas) {

        if(pozoDesbordado(fichas))
            throw new PozoDesbordadoPorFichasError();

        fichasActuales += fichas;

    }

    private boolean pozoDesbordado(int fichas) {

        return( fichasActuales + fichas > maximoFichas);


    }

    public int getCantidadDeFichas(){

        return fichasActuales;

    }

    public void reiniciar() {

        fichasActuales = 0;
    }
}
