package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by felip on 24/04/2018.
 */

public class MensagemActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.mensagem );
        Button botaoVoltar = findViewById( R.id.botaoVoltar );

        botaoVoltar.setOnClickListener( onClickVoltar() );

    }

    public View.OnClickListener onClickVoltar() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra( "result", "Inicio" );
                setResult( Activity.RESULT_OK, returnIntent );
                finish();
            }
        };
    }
}