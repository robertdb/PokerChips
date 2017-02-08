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


    public void asignarJuego(Mesa mesa) {

        this.mesa = mesa;

        // que la mesa maneje el tiempo de las ciegas.
        int apuestaCiegachica = mesa.getApuestaCiegaChica();

        this.jugada = new Jugada(apuestaCiegachica * 2);

        this.ciegaChica = mesa.getCiegaChica();

        this.ciegaGrande = mesa.getCiegaGrande();

        this.ciegaChica.apuestaObligatoria(apuestaCiegachica);

        this.ciegaGrande.apuestaObligatoria(apuestaCiegachica * 2);

        this.iterJugadoresActivos = new IteradorListaCircular(mesa.getListaClonadaDeActivos());

        iterJugadoresActivos.moveActual(ciegaGrande);

        iterJugadoresActivos.next();

        mano = new Mano(this);

    }
    /* // Todo
    // asignarJuego() y este metedo probablemte se hagan un solo metedo despues
    // por ahora lo dejo asi
    public void crearMano() {

        mano = new Mano(this);

    }*/

    @Override
    public void subir(int apuesta) {

        //this.mesa.actualizarVista(jugada);

        mano.nuevoAgresor(getJugadorActual());

        mano.comprobarSiGanadores();

        iterJugadoresActivos.next();

    }

    @Override
    public void pasar() {

        if(mano.cambiarRonda()){

            mano.terminarRonda();

        }
        else{
            iterJugadoresActivos.next();
        }

        mano.comprobarSiGanadores();

    }

    @Override
    public void igualar(int debitar) {

        if(mano.cambiarRonda()){

            mano.terminarRonda();

        }
        else{
            iterJugadoresActivos.next();
        }

        mano.comprobarSiGanadores();

    }

    // Si el jugador actual se retira el actual pasa a ser su siguiente.
    @Override
    public void retirar() {

        if(iterJugadoresActivos.actual() == ciegaChica)
            ciegaChica = (Jugador) iterJugadoresActivos.seeNext();

        iterJugadoresActivos.removeActual();

        mano.comprobarSiGanadores();

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

    @Override
    public Jugada getJugada() {

        return jugada;

    }

    public Jugador verProximoJugador() {

        return (Jugador) iterJugadoresActivos.seeNext();

    }

    public IteradorListaCircular getCandidatos() {

        return null;

    }

    public int getFichasTotales() {

        return mesa.getFichasTotales();
    }
}
