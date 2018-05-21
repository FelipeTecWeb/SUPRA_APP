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

public class Activity_Mensagem extends AppCompatActivity {

    private String TAG = Activity_Mensagem.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    private static String url = "https://api.myjson.com/bins/vkgyq";

    ArrayList<HashMap<String, String>> mensagemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        mensagemList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list_mensagem);

        new Activity_Mensagem.GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Activity_Mensagem.this);
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
                    JSONArray mensagens = jsonObj.getJSONArray("Mensagem");

                    // looping through All Contacts
                    for (int i = 0; i < mensagens.length(); i++) {
                        JSONObject mensagem = mensagens.getJSONObject(i);


                        String nome = mensagem.getString("Nome");
                        String para = mensagem.getString("Para");
                        String assunto = mensagem.getString("Assunto");




                        // Phone node is JSON Object

                        // tmp hash map for single contact
                        HashMap<String, String> mensagems = new HashMap<>();

                        // adding each child node to HashMap key => value

                        mensagems.put("Nome", "NOME: " +  nome);
                        mensagems.put("Para", "PARA: " + para);
                        mensagems.put("Assunto", "ASSUNTO: " + assunto);


                        // adding contact to contact list
                        mensagemList.add(mensagems);
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
                    Activity_Mensagem.this, mensagemList,
                    R.layout.list_item_mensagem, new String[]{"Nome", "Para",
                    "Assunto"}, new int[]{R.id.nome,
                    R.id.para, R.id.assunto});

            lv.setAdapter(adapter);
        }

    }
}