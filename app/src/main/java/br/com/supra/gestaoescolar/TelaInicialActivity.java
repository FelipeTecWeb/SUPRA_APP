package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaInicialActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_inicial );

        Button botaoNoticia = (Button) findViewById( R.id.botaoNoticia );
        botaoNoticia.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.activity_main);
                Toast.makeText( TelaInicialActivity.this, "Noticia", Toast.LENGTH_SHORT ).show();

            }

        } );

        Button botaoMensagem = (Button) findViewById( R.id.botaoMensagem );
        botaoMensagem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.mensagem );
                Toast.makeText( TelaInicialActivity.this, "Mensagem", Toast.LENGTH_SHORT ).show();
            }
        } );

        Button botaoBoletim = (Button) findViewById( R.id.botaoBoletim );
        botaoBoletim.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.boletim );
                Toast.makeText( TelaInicialActivity.this, "Boletim", Toast.LENGTH_SHORT ).show();
            }
        } );

        Button botaoDiario = (Button) findViewById( R.id.botaoDiario);
        botaoDiario.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.diario );
                Toast.makeText( TelaInicialActivity.this, "Diario", Toast.LENGTH_SHORT ).show();
            }
        } );

        Button botaoinformacoes = (Button) findViewById( R.id.botaoinformacoes);
        botaoinformacoes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.informacoes );
                Toast.makeText( TelaInicialActivity.this, "Informações", Toast.LENGTH_SHORT ).show();
            }
        } );

        Button botaoSair = (Button) findViewById( R.id.botaoSair );
        botaoSair.setOnClickListener( clickSair() );


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


    /*public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_buscar) {
            Toast.makeText( TelaInicialActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT ).show();
            Intent it = new Intent( TelaInicialActivity.this, ActionBarSearchView.class );
            startActivityForResult( it, 1 );

        }

        return super.onOptionsItemSelected( item );

    }*/




}
