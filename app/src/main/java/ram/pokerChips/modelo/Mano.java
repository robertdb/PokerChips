package ram.pokerChips.modelo;

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

        this.pozo = new Pozo(crupier.getFichasTotales()); //TODO test

        this.ronda = new PreFlop(crupier);

        this.agresor = new AgresorPreFlop();

    }

    public boolean cambiarRonda() {

        return ronda.cambiarRonda(agresor, crupier.verProximoJugador());

    }

    public void nuevoAgresor(Jugador jugador) {

        agresor = new AgresorActivo(jugador);

    }

    private boolean comprobarSiHayUnGanador() {

        //ronda.comprobarGanador(crupier.getCandidatos(), pozo);
        return true;
    }

    public void determinarGanadores() {

    }

    public void terminarRonda() {

        comprobarSiHayUnGanador();

        ronda = ronda.rondaTerminada();

        agresor = new AgresorApuestaNula(crupier);

    }

    public void acumularAlPozo(int apuesta) {
        pozo.agregarFichas(apuesta);
    }

    public int getFichasEnElPozo() {
        return pozo.getCantidadDeFichas();
    }
}
