package com.jx3.academico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new tarea().execute();
    }
    class tarea extends AsyncTask<Void, String , Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            consumirApi();
            return null;
        }
    }
    private void consumirApi(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://190.211.242.174/unit_app/rest_alumno/consulta.php?ci=4346988&cbx_sede=1")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String resultadoStringUnico = response.body().string();
            System.out.println("resultadoStringUnico = " + resultadoStringUnico);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}