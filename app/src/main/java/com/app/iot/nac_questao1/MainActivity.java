package com.app.iot.nac_questao1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view){

        String response;
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText txtConsulta = findViewById(R.id.editTextId);
        url += txtConsulta.getText().toString();

        //NetworkToolkit.getJSONFromAPI(url);
        TextView txtNome = findViewById(R.id.editTextTitle);
        TextView txtSobrenome = findViewById(R.id.editTextCompleted);
        TextView txtMensagem = findViewById(R.id.viewMensagem);

        new DataGetter(txtNome,txtSobrenome,txtMensagem).execute(url);

    }

}
