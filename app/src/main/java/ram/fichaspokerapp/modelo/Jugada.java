package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Jugada {

    private Pozo pozo;
    private int apuestaMinima;
    private int ciegaGrande;


    public Jugada(Pozo pozo, int apuestaMinima, int ciegaGrande) {

        this.pozo = pozo;
        this.apuestaMinima = apuestaMinima;
        this.ciegaGrande = ciegaGrande;

    }

    public void actualizar(int apuesta) {


    }

    public int getApuestaMinima() {
        return apuestaMinima;
    }

    public void pasar() {

        if (this.apuestaMinima>0){
            throw new NoSePuedePasarSiSeSubeError();

        }

    }

    public void subir(int apuesta) {

        this.pozo.agregarFichas(apuesta);
        this.apuestaMinima = apuesta;

    }
}
