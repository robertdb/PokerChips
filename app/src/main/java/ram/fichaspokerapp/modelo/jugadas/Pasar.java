package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Pasar extends Jugada {

    private Jugada jugadaAnterior;

    public Pasar(Jugada jugadaAnterior) {

        this.jugadaAnterior = jugadaAnterior;

    }

    @Override
    public void pasar() {

        jugadaAnterior.pasar();

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
}
