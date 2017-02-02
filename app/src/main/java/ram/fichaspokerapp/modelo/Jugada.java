package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.NoSePuedeIgualarSiNoHuboSubidaError;
import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Jugada {

    private Pozo pozo;
    private int apuestaMinima;
    private int ciegaGrande;


    public Jugada(Pozo pozo, int ciegaGrande) {

        this.pozo = pozo;
        this.apuestaMinima = ciegaGrande;
        this.ciegaGrande = ciegaGrande;

    }

    public int getApuestaMinima() {
        return apuestaMinima;
    }

    public void pasar() {

        if (this.apuestaMinima > 0){
            throw new NoSePuedePasarSiSeSubeError();

        }

    }

    private int calcularSubidaMinima(){

        return (this.apuestaMinima + this.ciegaGrande);
    }

    public void subir(int apuesta) {
        if (this.calcularSubidaMinima() > apuesta ){

            throw new NoSePuedeSubirMenosQueLaSubidaMinimaError();

        }
        this.pozo.agregarFichas(apuesta);
        this.apuestaMinima = apuesta;

    }



    public void igualar() {
        if (this.apuestaMinima == 0 ){

            throw new NoSePuedeIgualarSiNoHuboSubidaError();

        }
        this.pozo.agregarFichas(this.apuestaMinima);

    }

    public void apuestaMinimaNula() {

        this.apuestaMinima = 0;

    }
}
