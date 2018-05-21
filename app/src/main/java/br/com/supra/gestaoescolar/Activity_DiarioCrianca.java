package br.com.supra.gestaoescolar;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by felip on 14/05/2018.
 */

public class Activity_DiarioCrianca extends AppCompatActivity {

    private String TAG = Activity_DiarioCrianca.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://api.myjson.com/bins/or916";

    ArrayList<HashMap<String, String>> diarioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario_crianca);

        diarioList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list_diario);

        new Activity_DiarioCrianca.GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Activity_DiarioCrianca.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray diarios = jsonObj.getJSONArray("Diario");

                    // looping through All Contacts
                    for (int i = 0; i < diarios.length(); i++) {
                        JSONObject diario = diarios.getJSONObject(i);


                        String aluno = diario.getString("Aluno");
                        String atividades = diario.getString("Atividades");
                        String recado = diario.getString("Recado");
                        String evento = diario.getString("Eventos");



                        // Phone node is JSON Object

                        // tmp hash map for single contact
                        HashMap<String, String> diario_crianca = new HashMap<>();

                        // adding each child node to HashMap key => value

                        diario_crianca.put("Aluno", "ALUNO: " +  aluno);
                        diario_crianca.put("Atividades", "ATIVIDADES: " + atividades);
                        diario_crianca.put("Recado", "RECADO: " + recado);
                        diario_crianca.put( "Eventos", "EVENTOS: " + evento );


                        // adding contact to contact list
                        diarioList.add(diario_crianca);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    Activity_DiarioCrianca.this, diarioList,
                    R.layout.list_item_diario, new String[]{"Aluno", "Atividades",
                    "Recado", "Eventos"}, new int[]{R.id.aluno,
                    R.id.atividade, R.id.recado, R.id.evento});

            lv.setAdapter(adapter);
        }

    }
}