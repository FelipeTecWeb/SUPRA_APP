package br.com.supra.gestaoescolar;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class PostAutenticacao extends AsyncTask<String, Void, String> {

    private Context contexto;

    public PostAutenticacao(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    protected String doInBackground(String... auth) {
        String url = "http://supra.educandarioanjinhofeliz.com/oauth/token";
        HttpHelper http = new HttpHelper();
        String json = "";

        Map<String, String> parametros = new HashMap<String, String>();

        parametros.put( "grant_type", "password" );
        parametros.put( "client_id", "3" );
        parametros.put( "client_secret", "8H4tW3wo4G8pAmbDMMfl6uKtyYY23588rOH8QRux" );
        parametros.put( "username", auth[0] );
        parametros.put( "password", auth[1] );
        parametros.put( "scope", "" );

        try {
            json = http.doPost( url, parametros );
        } catch (IOException ex) {
        }
        return json;
    }

    protected void onPostExecute(String retorno) {
        String result = parseJsonAuth( retorno ).getAccess_token();
        SharedPreferences TOKEN = contexto.getSharedPreferences( "autenticacao", 0 );

        if (result == null || result.isEmpty()) {
            Toast.makeText( contexto, "Não foi possivel realizar a autenticação!", Toast.LENGTH_LONG ).show();
        } else {
            Toast.makeText( contexto, "Login realizado com sucesso", Toast.LENGTH_LONG ).show();
            Intent intent2 = new Intent( contexto, TelaInicialActivity.class );
            contexto.startActivity( intent2 );
        }


    }

    public Auth parseJsonAuth(String json) {
        Log.d( "MYAPP", "Retorno: " + json );
        Auth autenticacao = new Auth();

        try {
            JSONObject autenticacaoJson = new JSONObject( json );

            autenticacao.setToken_type( autenticacaoJson.optString( "token_type" ) );
            autenticacao.setExpires_in( autenticacaoJson.optString( "expires_in" ) );
            autenticacao.setAccess_token( autenticacaoJson.optString( "access_token" ) );
            autenticacao.setRefresh_tokenString( autenticacaoJson.optString( "refresh_tokenString" ) );

            SharedPreferences TOKEN = contexto.getSharedPreferences( "autenticacao", 0 );

            SharedPreferences.Editor edit = TOKEN.edit();
            edit.putString( "token", "Bearer " + autenticacao.getAccess_token() );
            edit.putString( "expires_in", autenticacao.getExpires_in() );
            edit.commit();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return autenticacao;
    }


}
