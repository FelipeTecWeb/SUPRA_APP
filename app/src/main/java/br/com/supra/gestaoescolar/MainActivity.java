package br.com.supra.gestaoescolar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context contexto;
    private Button addTodoBtn;
    private EditText email;
    private EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela_login );

        SharedPreferences TOKEN = getSharedPreferences( "autenticacao", 0 );

//        if (!(TOKEN.getString( "token", "" ) == null) || !(TOKEN.getString( "token", "" ).isEmpty())) {
//            Intent intent2 = new Intent( this, TelaInicialActivity.class );
//            startActivity( intent2 );
//        }

        addTodoBtn = findViewById( R.id.btLogin );
        email = findViewById( R.id.txEmail );
        senha = findViewById( R.id.txSenha );

        addTodoBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                autenticacao( email.getText().toString(), senha.getText().toString() );
            }
        } );

    }


    public void autenticacao(String email, String senha) {
        new PostAutenticacao( MainActivity.this ).execute( email, senha );
    }

    public void chamaMenu(View view) {
        Intent intent = new Intent( MainActivity.this, TelaInicialActivity.class );
        startActivity( intent );

    }
}
