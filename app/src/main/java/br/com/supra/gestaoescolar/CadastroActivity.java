package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_cadastro_anotacoes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button botao  = (Button)findViewById(R.id.btCadastro);
        botao.setOnClickListener(clickCadastro());
    }

    public View.OnClickListener clickCadastro(){
        return new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                EditText anotacoes = (EditText)findViewById(R.id.anotacoes);

                String textoAnotacoes = anotacoes.getText().toString();


                Intent returnIntent = new Intent();
                returnIntent.putExtra("anotacoes",textoAnotacoes);


                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
