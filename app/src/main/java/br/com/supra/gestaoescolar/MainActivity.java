package br.com.supra.gestaoescolar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btcadastro, btentrar;
    EditText txtnome, txtsobrenome, txtsenha, txtemail, txtphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_cadastro );

        openHelper = new CadastroActivity(this);
        txtnome = (EditText)findViewById(R.id.txtnome);
        txtsobrenome = (EditText)findViewById(R.id.txtsobrenome);
        txtsenha = (EditText)findViewById(R.id.txtsenha);
        txtemail = (EditText)findViewById(R.id.txtemail);
        txtphone = (EditText)findViewById(R.id.txtphone);
        btcadastro=(Button)findViewById(R.id.btcadastro);
        btentrar = (Button) findViewById( R.id.btentrar );


        btcadastro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();
                String nome = txtnome.getText().toString();
                String sobrenome = txtsobrenome.getText().toString();
                String senha = txtsenha.getText().toString();
                String email = txtemail.getText().toString();
                String phone = txtphone.getText().toString();
                insertdata(nome, sobrenome, senha, email, phone);
                Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!!", Toast.LENGTH_LONG).show();


            }
        } );

        btentrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, login.class);
                startActivity(it);
            }
        } );
    }


    public void insertdata(String nome, String sobrenome, String senha, String email, String phone){
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( CadastroActivity.COL_2, nome);
        contentValues.put( CadastroActivity.COL_3, sobrenome);
        contentValues.put( CadastroActivity.COL_4, senha);
        contentValues.put( CadastroActivity.COL_5, email);
        contentValues.put( CadastroActivity.COL_6, phone);
        long id = db.insert( CadastroActivity.TABLE_NAME, null, contentValues);
    }
}