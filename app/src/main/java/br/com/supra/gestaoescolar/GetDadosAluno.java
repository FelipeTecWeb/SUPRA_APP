package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class GetDadosAluno extends AsyncTask<String, Void, List<Turma>> {

    private Context contexto;

    public GetDadosAluno(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    protected List<Turma> doInBackground(String... auth) {
        String url = auth[0];
        HttpHelper http = new HttpHelper();
        String json = null;
        SharedPreferences TOKEN = contexto.getSharedPreferences( "autenticacao", 0 );

        try {
            json = http.doGetApi( url, null, TOKEN.getString( "token", "" ) );
        } catch (IOException ex) {

        }
        Log.d( "MYAPP", "Retorno: " + json );
        return parseJSON( json );
    }

    protected void onPostExecute(List<Turma> retorno) {
        Toast.makeText( contexto, retorno.toString(), Toast.LENGTH_LONG ).show();
        ListView lista = (ListView) ((Activity) contexto).findViewById( R.id.lista );
        lista.setAdapter( new TurmasAdapter( contexto, retorno ) );
    }

    private List<Turma> parseJSON(String json) {
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            JSONArray jsonCervejas = new JSONObject( json ).optJSONArray( "cervejas" );
            for (int i = 0; i < jsonCervejas.length(); i++) {
                JSONObject jsonTurmas = jsonCervejas.getJSONObject( i );
                Turma turma = new Turma();
                turma.setSala( jsonTurmas.optString( "sala" ) );
                turma.setInicia( jsonTurmas.optString( "inicia" ) );
                turma.setEncerra( jsonTurmas.optString( "encerra" ) );
                turma.setProfessor( jsonTurmas.optString( "professor" ) );
                turma.setMateria( jsonTurmas.optString( "materia" ) );
                turma.setLockStatus( jsonTurmas.optInt( "lockStatus" ) );

                turmas.add( turma );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return turmas;
    }

}
