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
        String url = "http://supra.educandarioanjinhofeliz.com/api/aluno/turmas";
        HttpHelper http = new HttpHelper();
        String json = null;
        SharedPreferences TOKEN = contexto.getSharedPreferences( "autenticacao", 0 );
        List<Turma> turma = null;
        try {
            json = http.doGetApi( url, null, TOKEN.getString( "token", "" ) );
        } catch (IOException ex) {

        }
        Log.d( "MYAPP", "Retorno: " + json );

        return parseJSON( json );

    }

    private List<Turma> parseJSON(String json) {
        List<Turma> turmas = new ArrayList<Turma>();
        try {

            JSONArray jsonTurmas = new JSONObject(json).optJSONArray("turmas");
            for(int i = 0; i < jsonTurmas.length(); i++) {
                JSONObject jsonTurma = jsonTurmas.getJSONObject(i);
                Turma c = new Turma();


                c.sala = jsonTurma.optString("sala");
                c.inicia = jsonTurma.optString("inicia");
                c.encerra = jsonTurma.optString("encerra");
                c.professor = jsonTurma.optString("professor");
                c.materia = jsonTurma.optString("materia");
                c.lockStatus = jsonTurma.optString("lockStatus");


                turmas.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return turmas;
    }

    protected void onPostExecute(List<Turma> retorno) {
        Toast.makeText( contexto, retorno.toString(), Toast.LENGTH_LONG ).show();
        ListView lista = (ListView) ((Activity) contexto).findViewById( R.id.lista );
        lista.setAdapter( new TurmasAdapter( contexto, retorno ) );
    }

  /*  private List<Turma> parseJSON(String json) {
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            JSONArray jsonTurmas = new JSONObject( json ).optJSONArray( "Turmas" );
            for (int i = 0; i < jsonTurmas.length(); i++) {
                JSONObject jsonTurma = jsonTurmas.getJSONObject( i );
                Turma turma = new Turma();
                turma.setSala( jsonTurma.optString( "sala" ) );
                turma.setInicia( jsonTurma.optString( "inicia" ) );
                turma.setEncerra( jsonTurma.optString( "encerra" ) );
                turma.setProfessor( jsonTurma.optString( "professor" ) );
                turma.setMateria( jsonTurma.optString( "materia" ) );
                turma.setLockStatus( jsonTurma.optInt( "lockStatus" ) );

                turmas.add( turma );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return turmas;
    }*/

}
