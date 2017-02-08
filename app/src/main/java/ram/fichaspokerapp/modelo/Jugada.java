package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.NoSePuedeIgualarSiNoHuboSubidaError;
import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;
import ram.fichaspokerapp.error.NoSePuedeSubirMenosQueLaSubidaMinimaError;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Jugada {

    private int apuestaMinima;
    private int ciegaGrande;


    public Jugada(int ciegaGrande) {

        this.apuestaMinima = ciegaGrande;
        this.ciegaGrande = ciegaGrande;

    }

    public int getApuestaMinima() {
        return apuestaMinima;
    }

    public void pasar(int fichasEnJuego) {

        if (this.apuestaMinima > fichasEnJuego){
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

        this.apuestaMinima = apuesta;

    }



    public void igualar() {
        if (this.apuestaMinima == 0 ){

            throw new NoSePuedeIgualarSiNoHuboSubidaError();

        }

    }

    public void apuestaMinimaNula() {

        this.apuestaMinima = 0;

    }

}
