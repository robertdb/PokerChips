package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.UltimaRondaTerminadaNoHayProximaError;

/**
 * Created by Robert on 2/2/17.
 */
public class Mano {

    private Pozo pozo;

    private Crupier crupier;

    private Ronda ronda;

    private Agresor agresor;

    public Mano(Pozo pozo, Crupier crupier) {

        this.pozo = pozo;

        this.crupier = crupier;

        this.ronda = new PreFlop(crupier);

        this.agresor = new AgresorPasivo();

    }


    public boolean cambiarRonda() {

        return ronda.cambiarRonda(agresor, crupier.getProximoJugador());

    }

    public void nuevoAgresor(Jugador jugador){

        agresor = new AgresorActivo(jugador);

    }

    public void verificarEstadoDeLaMano(){

        ronda.comprobarGanador(crupier.getCandidatos(), pozo);

        if(cambiarRonda()){

            try{

                ronda = ronda.rondaTerminada();

                agresor = new AgresorPasivo();

            }catch(UltimaRondaTerminadaNoHayProximaError e){

                determinarGanadores();

            }

        }

    }

    public void determinarGanadores(){

    }
}
