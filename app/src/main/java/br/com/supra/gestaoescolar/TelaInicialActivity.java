package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class TelaInicialActivity extends DebugActivity {

    private String [] listaAnotacoes = new String[]{"Anotações disponiveis:","Nota","Avaliações","Noticias"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_tela_inicial);


        Intent intent = getIntent();
        Bundle params = intent.getExtras();


        if (params != null) {
            String nome = params.getString("nome");


            Log.d(DEBUG_TAG, "Nome do usuário: " + nome);
            Toast.makeText(TelaInicialActivity.this, "Nome do usuário: " + nome, Toast.LENGTH_LONG).show();

        }



        Button botaoSair = (Button) findViewById( R.id.botaoSair);
        botaoSair.setOnClickListener(clickSair());


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Início");


    }


    public View.OnClickListener clickSair() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "Saida do SUPRA");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        };
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_adicionar) {
            Toast.makeText(TelaInicialActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
            Intent it = new Intent(TelaInicialActivity.this, CadastroActivity.class);
            startActivityForResult(it, 1);
        }
        if (id == R.id.action_buscar){
            Toast.makeText(TelaInicialActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
            Intent it = new Intent(TelaInicialActivity.this, ActionBarSearchView.class);
            startActivityForResult(it, 1);


        }
        if (id == R.id.action_share){
            Toast.makeText(TelaInicialActivity.this,
                    "Compartilhar",
                    Toast.LENGTH_SHORT).show();
            Intent it = new Intent(TelaInicialActivity.this, ActionBarShare.class);
            startActivityForResult(it, 1);


        }

        return super.onOptionsItemSelected(item);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("anotacoes"));
                textoRetorno.append("\n");
                TextView texto = (TextView) findViewById(R.id.textoInicial);
                texto.setText(textoRetorno.toString());

            }
        }
    }


    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override

            public boolean onQueryTextSubmit(String query) {
                query = query.toLowerCase();
                Toast.makeText(TelaInicialActivity.this, query, Toast.LENGTH_SHORT).show();
                String results = "";
                for (String anotacao: listaAnotacoes) {
                    if(anotacao.toLowerCase().contains(query)){
                        results += anotacao +"\n";
                    }
                }

                return false;
            }

            @Override

            public boolean onQueryTextChange(String newText) {
                Toast.makeText(TelaInicialActivity.this, newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
    }


    private Intent getDefautIntent() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        String textoShare = "supra \n";

        for (String anotacao: listaAnotacoes) {
            textoShare += anotacao +"\n";
        }
        intent.putExtra(Intent.EXTRA_TEXT, textoShare);
        return intent;
    }


}
