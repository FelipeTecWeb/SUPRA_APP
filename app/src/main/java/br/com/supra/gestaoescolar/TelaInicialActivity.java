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
    public void chamaCadastro(View view){
        Intent intent2 = new Intent(this, AddAlunoActivity.class);
        startActivity( intent2 );
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
