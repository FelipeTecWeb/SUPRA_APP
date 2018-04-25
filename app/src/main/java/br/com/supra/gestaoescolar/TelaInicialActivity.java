package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaInicialActivity extends DebugActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_inicial );

        Button botaoNoticia =  findViewById( R.id.botaoNoticia );
        Button botaoMensagem = findViewById( R.id.botaoMensagem );
        Button botaoBoletim =  findViewById( R.id.botaoBoletim );
        Button botaoDiario =   findViewById( R.id.botaoDiario);
        Button botaoinformacoes = findViewById( R.id.botaoinformacoes);
        Button botaoSair =     findViewById( R.id.botaoSair );

        botaoNoticia.setOnClickListener( this );
        botaoMensagem.setOnClickListener( this );
        botaoBoletim.setOnClickListener( this );
        botaoDiario.setOnClickListener( this );
        botaoinformacoes.setOnClickListener( this );


        botaoSair.setOnClickListener(clickSair());


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botaoNoticia:
                setContentView( R.layout.noticia );
                Toast.makeText( this, "Noticia", Toast.LENGTH_SHORT ).show();
                break;
        }
        switch (v.getId()) {
            case R.id.botaoMensagem:
                setContentView( R.layout.mensagem );
                Toast.makeText( this, "Mensagem", Toast.LENGTH_SHORT ).show();
                break;

        }
        switch (v.getId()) {
            case R.id.botaoBoletim:
                setContentView( R.layout.boletim );
                Toast.makeText( this, "Boletim", Toast.LENGTH_SHORT ).show();
                break;

        }
        switch (v.getId()) {
            case R.id.botaoDiario:
                setContentView( R.layout.diario );
                Toast.makeText( this, "Diario", Toast.LENGTH_SHORT ).show();
                break;

        }
        switch (v.getId()) {
            case R.id.botaoinformacoes:
                setContentView( R.layout.informacoes );
                Toast.makeText( this, "Informações", Toast.LENGTH_SHORT ).show();
                break;

        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate( R.menu.menu_main, menu );

        return true;
    }

}
