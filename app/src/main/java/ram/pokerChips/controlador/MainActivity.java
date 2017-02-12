package ram.pokerChips.controlador;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import ram.pokerChips.R;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewCantidad;
    private CheckBox checkBox;
    private EditText editText;
    private int pote = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inicializarVariables();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                this.progress = progress;
                textViewCantidad.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textViewCantidad.setText(String.valueOf(progress));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewCantidad.setText(String.valueOf(progress));
            }
        });
    }

    private void inicializarVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textViewCantidad = (TextView) findViewById(R.id.laCantidad);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        editText = (EditText) findViewById(R.id.nombre);
    }

    public void medioPote(View vista) {
        actualizarProgresoSeekBar(pote / 2);
    }

    public void tresCuartosPote(View vista) {
        actualizarProgresoSeekBar(pote * 3 / 4);
    }

    public void pote(View vista) {
        actualizarProgresoSeekBar(pote);
    }

    public void allIn(View vista) {
        actualizarProgresoSeekBar(seekBar.getMax());
    }

    private void actualizarProgresoSeekBar(int progreso) {
        seekBar.setProgress(progreso);
        textViewCantidad.setText(String.valueOf(seekBar.getProgress()));
    }

    public void setPrueba(View view) {
        boolean prueba = checkBox.isChecked();
        pote++;
        searchWeb(editText.getText().toString());
    }

    private void searchWeb(String query) {
        Uri uri = Uri.parse("http://www.google.com/#q=" + query);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}