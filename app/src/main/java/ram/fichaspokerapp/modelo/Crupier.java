package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.modelo.linkedList.IteradorListaCircular;

/**
 * Created by Samsung on 27/01/2017.
 */
public class Crupier implements CrupierMediador{

    private IteradorListaCircular iterJugadoresActivos;

    private Mesa mesa;

    private Jugada jugada;

    private Jugador ciegaChica;

    private Jugador ciegaGrande;

    private Mano mano;

    public Crupier() {

    }

    public Jugador getJugadorActual(){
        return (Jugador) this.iterJugadoresActivos.actual();
    }


    public void asignarJuego(IteradorListaCircular iter, Mesa mesa, Jugada jugada) {

        this.iterJugadoresActivos = iter;

        this.mesa = mesa;

        this.jugada = jugada;

        this.ciegaChica = mesa.getCiegaChica();

        this.ciegaGrande = mesa.getCiegaGrande();

    }

    // asignarJuego() y este metedo probablemte se hagan un solo metedo despues
    // por ahora lo dejo asi
    public void crearMano() {

        mano = new Mano(jugada.getFalopaPozo(), this);

    }

    @Override
    public void subir() {

        this.mesa.actualizarVista(jugada);

        mano.nuevoAgresor(getJugadorActual());

        mano.comprobarSiGanadores();

        iterJugadoresActivos.next();

    }

    @Override
    public void pasar() {

        // FALTA VER COMO VA MANEJAR LA MANO AL PASAR.
        // QUE PASA SI EN UNA RONDA COMO EL FLOP TURN RIVER TODOS DECIDEN PASAR
        iterJugadoresActivos.next();

    }

    @Override
    public void igualar() {

        if(mano.cambiarRonda()){

            mano.terminarRonda();

            return;
        }

        mano.comprobarSiGanadores();

        iterJugadoresActivos.next();

    }

    // Si el jugador actual se retira el actual pasa a ser su siguiente.
    @Override
    public void retirar() {

        if(iterJugadoresActivos.actual() == ciegaChica)
            ciegaChica = (Jugador) iterJugadoresActivos.seeNext();

        iterJugadoresActivos.removeActual();

    }

    public Jugador getJugadorCiegaGrande() {

        return ciegaGrande;
    }

    public void nuevaRonda() {

        jugada.apuestaMinimaNula();
        
        ciegaChicaIniciaNuevaRonda();

    }

    private void ciegaChicaIniciaNuevaRonda() {

        iterJugadoresActivos.moveActual(ciegaChica);

    }

    public int getApuestaMinima() {

        return jugada.getApuestaMinima();

    }

    public Jugada getJugada() {

        return jugada;

    }

    public Jugador verProximoJugador() {

        return (Jugador) iterJugadoresActivos.seeNext();

    }

    public IteradorListaCircular getCandidatos() {

        return null;

    }

}
