package co.edu.unisangil.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InicioActivity extends AppCompatActivity {


    ImageView imagen;

    TextView Texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        imagen = findViewById(R.id.imagen);
        Texto = findViewById(R.id.Texto);

        Intent intent = getIntent();
        String co = Texto.getText().toString();
        String correo = intent.getStringExtra("correo");
        Texto.setText(co +" "+correo);

        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/primer-proyecto-b27bf.appspot.com/o/descarga.png?alt=media&token=25c46eb9-55a2-4c48-a31e-31198e8874d2")
                .into(imagen);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemMenu = item.getItemId();
        if(itemMenu == R.id.itemNosotros){
            Intent intent = new Intent(this, InformacionActivity.class);
            startActivity(intent);
        } else if (itemMenu == R.id.itemCerrar) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}