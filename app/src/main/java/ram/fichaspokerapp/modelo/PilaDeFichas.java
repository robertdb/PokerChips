package ram.fichaspokerapp.modelo;

import ram.fichaspokerapp.error.NoHaySuficientesFichasError;

/**
 * Created by Samsung on 05/02/2017.
 */
public class PilaDeFichas {

    private int cantidadDeFichas;
    private int fichasEnJuego;


    public PilaDeFichas(int fichas) {

        this.cantidadDeFichas = 0;
        acreditar(fichas);
        this.fichasEnJuego = 0;
    }

    // TODO conflicto
    public int debitar(int fichas) {

        int fichasADebitar = fichas - fichasEnJuego;

        if (fichasADebitar >= cantidadDeFichas) {
            fichasEnJuego += cantidadDeFichas;
            cantidadDeFichas = 0;
        } else {
            this.cantidadDeFichas -= fichasADebitar;
            this.fichasEnJuego += fichasADebitar;
        }

        return fichasEnJuego;
    }

    public int getCantidadDeFichas() {
        return cantidadDeFichas;
    }

    public void acreditar(int fichas) {

        this.cantidadDeFichas += fichas;

    }

}
