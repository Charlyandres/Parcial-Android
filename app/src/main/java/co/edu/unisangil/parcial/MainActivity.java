package co.edu.unisangil.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edCorreo, edContra;

    Button btnIniciar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCorreo = findViewById(R.id.edCorreo);
        edContra = findViewById(R.id.edContra);
        btnIniciar = findViewById(R.id.bntIniciar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickIniciar();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCLickRegistrar();
            }
        });
    }

    private void onClickIniciar(){
        String correo = edCorreo.getText().toString();
        String contra = edContra.getText().toString();
        if(!correo.isEmpty()){
            if(!contra.isEmpty()){
                if(correo.equals("carlosrobayocabra@gmail.com") && contra.equals("carlos27")){
                    Intent intent = new Intent(this, InicioActivity.class);
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "¡Datos incorrectos!", Toast.LENGTH_SHORT).show();
                }
            }else{
                edContra.setError("Campo Requerido");
            }
        }else{
            edCorreo.setError("Campo Requerido");
        }
    }
    private void onCLickRegistrar(){
        String correo = edCorreo.getText().toString();
        Intent intent = new Intent(this, RegistroActivity.class);
        intent.putExtra("correo",correo);
        startActivity(intent);
    }
}