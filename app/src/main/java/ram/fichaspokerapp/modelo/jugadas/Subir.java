package ram.fichaspokerapp.modelo.jugadas;

import ram.fichaspokerapp.error.NoSePuedePasarSiSeSubeError;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Subir extends Jugada {
    @Override
    public void pasar() {
        throw new NoSePuedePasarSiSeSubeError();
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
