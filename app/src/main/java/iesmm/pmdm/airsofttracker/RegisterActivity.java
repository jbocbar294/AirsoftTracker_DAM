package iesmm.pmdm.airsofttracker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import iesmm.pmdm.airsofttracker.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvUsuario;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // Recibir datos del Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            usuario = bundle.getString("usuario");

            // Mostrar el valor recibido en un TextView
            TextView textView = findViewById(R.id.tv1);
            textView.setText(usuario);
        }
        tvUsuario = findViewById(R.id.tv1);
        tvUsuario.setText(usuario);
    }
}