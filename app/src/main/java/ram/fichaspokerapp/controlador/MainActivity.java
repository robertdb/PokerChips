package ram.fichaspokerapp.controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ram.fichaspokerapp.R;

public class MainActivity extends AppCompatActivity {

    private int cantidad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void apostar(View vista) {
        this.cantidad ++;
        mostrar(cantidad);
    }

    private void mostrar(int numero) {
        TextView quantityTextView = (TextView) findViewById(R.id.laCantidad);
        quantityTextView.setText("" + numero);
    }
}
