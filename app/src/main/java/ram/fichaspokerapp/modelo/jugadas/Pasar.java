package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Pasar extends Jugada {

    public Pasar () {
    }

    public Pasar(Jugada jugadaAnterior) {

        this.actuar(jugadaAnterior);

    }

    @Override
    public void pasar() {

    }

    @Override
    public void subir() {


    }

    @Override
    public void igualar() {

    }

    @Override
    public void retirar() {

    }

    @Override
    public void actuar(Jugada jugadaAnterior) {
        jugadaAnterior.pasar();
    }
}
