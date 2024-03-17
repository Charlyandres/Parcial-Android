package co.edu.unisangil.parcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class RegistroActivity extends AppCompatActivity {

    EditText edNombre, edCorreo, edDireccion, edTelefono, edFecha, edContra;

    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edNombre = findViewById(R.id.edNombre);
        edCorreo = findViewById(R.id.edCorreo);
        edDireccion = findViewById(R.id.edDireccion);
        edTelefono = findViewById(R.id.edTelefono);
        edFecha = findViewById(R.id.edFecha);
        edContra = findViewById(R.id.edContra);
        btnEnviar = findViewById(R.id.btnEnviar);

        edFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCLickEnviar();
            }
        });

    }

    private void onCLickEnviar(){
        String nombre = edNombre.getText().toString();
        String correo = edCorreo.getText().toString();
        String direccion = edDireccion.getText().toString();
        String telefono = edTelefono.getText().toString();
        String fecha = edFecha.getText().toString();
        String contra = edContra.getText().toString();

        if(!nombre.isEmpty()){
            if(!correo.isEmpty()){
                if(!direccion.isEmpty()){
                    if(!telefono.isEmpty()){
                        if(!fecha.isEmpty()){
                            if(!contra.isEmpty()){
                                AlertDialog.Builder alert = new AlertDialog.Builder(RegistroActivity.this);
                                alert.setTitle("Confirmar")
                                        .setMessage("¿Sus datos son correctos?")
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(RegistroActivity.this, InicioActivity.class);
                                                intent.putExtra("correo",correo);
                                                startActivity(intent);
                                            }
                                        })
                                        .setNegativeButton("No", null)
                                        .setCancelable(false)
                                        //.setIcon(R.drawable.klipartz)
                                        .show();
                            }else{edContra.setError("Contraseña Requerida");}
                        }else{edFecha.setError("Fecha Requerida");}
                    }else{edTelefono.setError("Telefono Requerido");}
                }else{edDireccion.setError("Direccion Requerida");}
            }else{edCorreo.setError("Correo Requerido");}
        }else{edNombre.setError("Nombre Requerido");}
    }
    private void showDate(){
        Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(RegistroActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int año, int mes, int dia) {
                edFecha.setText(año+"/"+(mes+1)+"/"+dia);
            }
        },año, mes,dia);
        dialog.show();
    }
}