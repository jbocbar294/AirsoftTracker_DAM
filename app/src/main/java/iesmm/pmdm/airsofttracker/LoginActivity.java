package iesmm.pmdm.airsofttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import iesmm.pmdm.airsofttracker.dao.DaoImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin, btnRegistrar;
    private EditText etUsuario, etContrasenya;
    private String usuario, contrasenya;
    DaoImpl dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        etUsuario = findViewById(R.id.etUsuario);
        etContrasenya = findViewById(R.id.etContrasenya);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == btnLogin.getId()) {
            usuario = etUsuario.getText().toString();
            contrasenya = etContrasenya.getText().toString();
            /*if (usuario.equals("") || contrasenya.equals("")) {
                Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                iniciarSesion();
            }*/
            iniciarSesion();
        } else {
            // Intent para el registro
        }
    }

    // Método para iniciar sesión
    private void iniciarSesion() {
        /*AsyncTask.execute(() -> {
            // Instancia de la clase DaoImpl
            dao = new DaoImpl();

            // Comprobar si el inicio es correcto y pasar a la segunda actividad mediante un Intent
            int id = dao.authenticateUser(usuario, contrasenya);
            if (id > -1) {
                //Si el inicio de sesion es correcto
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("usuario", usuario);
                bundle.putString("contrasenya", contrasenya);
                // Llamar siguiente actividad
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Snackbar.make(findViewById(android.R.id.content), "Usuario no registrado", Snackbar.LENGTH_LONG).show();
            }
        });*/
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("usuario", usuario);
        bundle.putString("contrasenya", contrasenya);
        // Llamar siguiente actividad
        intent.putExtras(bundle);
        startActivity(intent);
    }
}