package com.app.iot.nac_questao1;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String> {

    private TextView txtNome;
    private TextView txtSobrenome;
    private TextView txtMensagem;

    public DataGetter(TextView txtNome, TextView txtSobrenome, TextView txtMensagem) {
        this.txtNome = txtNome;
        this.txtSobrenome = txtSobrenome;
        this.txtMensagem = txtMensagem;

        txtMensagem.setText("Pesquisando...");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);


        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        txtMensagem.setText("Encontrado!");

        try{
            JSONObject jsonResponse = new JSONObject(s);

            String title = jsonResponse.getString("title");
            String completed = jsonResponse.getString("completed");

            txtNome.setText(title);
            txtSobrenome.setText(completed);

        }
        catch(JSONException e){
            this.txtMensagem.setText(e.toString());
        }
    }
}