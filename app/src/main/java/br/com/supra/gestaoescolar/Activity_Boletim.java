package br.com.supra.gestaoescolar;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;


/**
 * Created by felip on 14/05/2018.
 */

public class Activity_Boletim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_boletim );


         String url = "http://supra.educandarioanjinhofeliz.com/api/aluno/turmas";

       try {
            new GetDadosAluno( this ).execute( url ).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        Toast.makeText( contexto, retorno, Toast.LENGTH_LONG ).show();

    }

    }

