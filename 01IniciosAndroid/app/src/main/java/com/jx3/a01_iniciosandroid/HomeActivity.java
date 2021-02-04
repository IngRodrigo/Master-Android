package com.jx3.a01_iniciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
private ListView lista;
private List<String> androidVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //capturamos los parametros que llegan por el intent
        Bundle extras=getIntent().getExtras();
        String usuario=extras.getString("valorEmail");
        //tituloBienvenido.setText("Bienvenido: "+usuario);
        setTitle(usuario);
        conectarVista();
        pintarListaEnPantalla();
    }
    private void conectarVista(){
        this.lista=findViewById(R.id._home_lista);
    }
    private void pintarListaEnPantalla() {
        //1 establecer los datos a pintar en la lista
        androidVersion= new ArrayList<>();
        androidVersion.add("Oreo");
        androidVersion.add("Pie");
        androidVersion.add("Kitkat");
        androidVersion.add("Lollipop");
        androidVersion.add("...");

        //2 Establecer un adaptador
        ArrayAdapter adaptadorAndroidVerison= new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                androidVersion
        );

        // 3 vincular el adaptador con el listView
        this.lista.setAdapter(adaptadorAndroidVerison);

        //4 gestionar el envento click
        this.lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String androidVersionSelect=androidVersion.get(position);
        Log.i("INFO", androidVersionSelect);
        System.out.println("Version andorid: "+androidVersionSelect);
    }
}