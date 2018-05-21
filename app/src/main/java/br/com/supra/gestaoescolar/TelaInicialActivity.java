package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TelaInicialActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_inicial );


        Button botaoSair = findViewById( R.id.botaoSair );


        botaoSair.setOnClickListener(clickSair());


    }
    public void chamaDiario(View view){
        Intent chamaDiario = new Intent(this, Activity_DiarioCrianca.class);
        startActivity( chamaDiario );
    }
    public void chamaBoletim(View view){
        Intent chamaBoletim = new Intent(this, Activity_Boletim.class);
        startActivity( chamaBoletim );
    }
    public void chamaMensagem(View view){
        Intent chamaMensagem = new Intent(this, Activity_Mensagem.class);
        startActivity( chamaMensagem );
    }

    public View.OnClickListener clickSair() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra( "result", "Saida do SUPRA" );
                setResult( Activity.RESULT_OK, returnIntent );
                finish();
            }
        };
    }



}
