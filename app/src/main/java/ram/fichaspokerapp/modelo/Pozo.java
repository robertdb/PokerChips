package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.PozoDesbordadoPorFichasError;

/**
 * Created by Robert on 27/1/17.
 */
public class Pozo {

    private int maximoFichas;

    private int fichasActuales;

    public Pozo(int cantidadMaximaDeFichas) {

        this.maximoFichas = cantidadMaximaDeFichas;

        this.fichasActuales = 0;

    }

    public void agregarFichas(int fichas) {

        if(pozoDesbordado(fichas))
            throw new PozoDesbordadoPorFichasError();

        fichasActuales += fichas;

    }

    private boolean pozoDesbordado(int fichas) {

        return( fichasActuales + fichas > maximoFichas);


    }

    public int getCantidadDeFichasActuales(){

        return fichasActuales;

    }

    public void reiniciar() {

        fichasActuales = 0;
    }
}
