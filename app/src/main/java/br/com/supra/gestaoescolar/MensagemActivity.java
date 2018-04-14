package br.com.supra.gestaoescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by felip on 14/04/2018.
 */

public class MensagemActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.mensagem );

        Button botaoVoltar = (Button) findViewById( R.id.botaoVoltar );

        botaoVoltar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.activity_tela_inicial);
            }
        } );
    }


}
