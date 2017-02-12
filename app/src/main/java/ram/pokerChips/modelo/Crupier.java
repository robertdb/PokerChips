package ram.pokerChips.modelo;

import ram.pokerChips.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier implements CrupierMediador{

    private final static int CANTIDAD_DE_JUGADORES_MINIMA_EN_MANO = 2;

    //Todo harcodeo de unico ganador
    private Jugador unicoGanador = null;

    private IteradorListaCircular iterJugadoresActivos;

    private Mesa mesa;

    private Jugada jugada;

    private Jugador jugadorCiegaChica;

    private Jugador jugadorCiegaGrande;

    private Mano mano;

    public Crupier() {

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.iterJugadoresActivos.actual();
    }


    public void iniciarMano(Mesa mesa) {

        this.mesa = mesa;

        // que la mesa maneje el tiempo de las ciegas.
        int apuestaCiegaChica = mesa.getApuestaCiegaChica();

        this.jugada = new Jugada(apuestaCiegaChica * 2);

        this.jugadorCiegaChica = mesa.getJugadorCiegaChica();

        this.jugadorCiegaGrande = mesa.getJugadorCiegaGrande();

        this.jugadorCiegaChica.apuestaObligatoria(apuestaCiegaChica);

        this.jugadorCiegaGrande.apuestaObligatoria(apuestaCiegaChica * 2);

        this.iterJugadoresActivos = new IteradorListaCircular(mesa.getListaClonadaDeActivos());

        iterJugadoresActivos.moverActual(jugadorCiegaGrande);

        iterJugadoresActivos.siguiente();

        mano = new Mano(this);

    }
    
    @Override
    public void subir(int apuesta) {

        //this.mesa.actualizarVista(jugada);

        jugada.subir(apuesta);

        Jugador jugadoActual = getJugadorActual();

        jugadoActual.debitarFichas(apuesta);

        mano.nuevoAgresor(jugadoActual);

        iterJugadoresActivos.siguiente();

    }

    @Override
    public void pasar() {

        Jugador jugadoActual = getJugadorActual();

        jugada.pasar(jugadoActual.getFichasEnJuego());

        controlarMano();

    }

    @Override
    public void igualar() {

        jugada.igualar();

        Jugador jugadoActual = getJugadorActual();

        jugadoActual.debitarFichas(jugada.getApuestaMinima());

        controlarMano();

    }

    // Si el jugador actual se retira el actual pasa a ser su anterior.
    @Override
    public void retirar() {

        if(iterJugadoresActivos.actual() == jugadorCiegaChica)
            jugadorCiegaChica = verProximoJugador();

        jugadorActualSeRetira();

        controlarMano();

    }

    public Jugador getJugadorCiegaGrande() {

        return jugadorCiegaGrande;
    }

    public void nuevaRonda() {

        jugada.apuestaMinimaNula();
        
        ciegaChicaIniciaNuevaRonda();

    }

    private void ciegaChicaIniciaNuevaRonda() {

        iterJugadoresActivos.moverActual(jugadorCiegaChica);

    }

    public int getApuestaMinima() {

        return jugada.getApuestaMinima();

    }

    public Jugador verProximoJugador() {

        return (Jugador) iterJugadoresActivos.verSiguiente();

    }

    public IteradorListaCircular getCandidatos() {

        return null;

    }

    public int getFichasTotales() {

        return mesa.getFichasTotales();
    }

    private void controlarMano(){
        if(terminarMano()){
           // Todo
            unicoGanador = getJugadorActual();
        }
        else
        if(mano.cambiarRonda()){

            mano.terminarRonda();

        }
        else{
            siguienteJugador();
        }

    }

    private void jugadorActualSeRetira(){

        iterJugadoresActivos.removerActual();

    }

    private void siguienteJugador(){

        iterJugadoresActivos.siguiente();

    }

    private boolean terminarMano(){

        return iterJugadoresActivos.listaSize() < CANTIDAD_DE_JUGADORES_MINIMA_EN_MANO ;

    }

    // Todo harcodeo de ganador unico
    public Jugador getGanador() {

        return this.unicoGanador;

    }
}
