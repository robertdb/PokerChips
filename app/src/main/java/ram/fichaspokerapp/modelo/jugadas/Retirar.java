package ram.fichaspokerapp.modelo.jugadas;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Retirar extends Jugada {

    private Jugada jugada;

    public Retirar(Jugada anterior) {

        this.jugada = anterior;

    }

    @Override
    public void pasar() {

        jugada.pasar();

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

    }
}
