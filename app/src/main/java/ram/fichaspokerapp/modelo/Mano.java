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

    public Mano(Crupier crupier) {


        this.crupier = crupier;
        this.pozo = new Pozo(crupier.getFichasTotales());
        this.ronda = new PreFlop(crupier);

        this.agresor = new AgresorPasivo();

    }


    public boolean cambiarRonda() {

        return ronda.cambiarRonda(agresor, crupier.verProximoJugador());

    }

    public void nuevoAgresor(Jugador jugador){

        agresor = new AgresorActivo(jugador);

    }

    public void comprobarSiGanadores(){

        //ronda.comprobarGanador(crupier.getCandidatos(), pozo);

    }

    public void determinarGanadores(){

    }

    public void terminarRonda() {

        try{

            ronda = ronda.rondaTerminada();

            agresor = new AgresorPasivo();

        }catch(UltimaRondaTerminadaNoHayProximaError e){

            determinarGanadores();

        }
    }
}
