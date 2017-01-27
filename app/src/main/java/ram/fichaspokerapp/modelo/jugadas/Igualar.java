package ram.fichaspokerapp.modelo.jugadas;

import ram.fichaspokerapp.error.NoSePuedePasarSiSeIgualaError;

/**
 * Created by Marcos on 22/01/2017.
 */

public class Igualar extends Jugada {
    @Override
    public void pasar() {
        throw new NoSePuedePasarSiSeIgualaError();
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
        jugadaAnterior.igualar();
    }
}
