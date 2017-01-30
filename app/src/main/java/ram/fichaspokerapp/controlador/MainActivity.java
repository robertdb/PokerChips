package ram.fichaspokerapp.controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import ram.fichaspokerapp.R;

import static ram.fichaspokerapp.R.id.laCantidad;
import static ram.fichaspokerapp.R.id.seekBar1;
import static ram.fichaspokerapp.R.id.textView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewCantidad;
    private int cantidad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializarVariables();
        textViewCantidad.setText(String.valueOf(seekBar.getProgress()));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress =0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                this.progress = progress;
                textViewCantidad.setText(String.valueOf(progress));
                Toast.makeText(getApplicationContext(), "Que tocas?",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textViewCantidad.setText(String.valueOf(progress));
                Toast.makeText(getApplicationContext(), "Bueno, bueno",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewCantidad.setText(String.valueOf(progress));
                Toast.makeText(getApplicationContext(), "Asi mejor",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textViewCantidad = (TextView) findViewById(R.id.laCantidad);
    }

    public void subir(View vista) {
        this.cantidad++;
        mostrar(cantidad);
    }

    private void mostrar(int numero) {
//        TextView quantityTextView = (TextView) findViewById(R.id.laCantidad);
//        textViewCantidad.setText(NumberFormat.getCurrencyInstance().format(numero));
        textViewCantidad.setText(String.valueOf(numero));
    }

}
