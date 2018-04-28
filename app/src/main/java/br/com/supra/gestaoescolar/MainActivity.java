package br.com.supra.gestaoescolar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    CadastroActivity helper = new CadastroActivity( this );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_cadastro );

    }

    public void onSingUpClick(View v) {

        if (v.getId() == R.id.btcadastro) {

            EditText nome = (EditText) findViewById( R.id.txtnome );
            EditText sobrenome = (EditText) findViewById( R.id.txtsobrenome );
            EditText senha = (EditText) findViewById( R.id.txtsenha );
            EditText email = (EditText) findViewById( R.id.txtemail );
            EditText senha2 = (EditText) findViewById( R.id.txtsenha2 );


            String nomestr = nome.getText().toString();
            String sobrenomestr = sobrenome.getText().toString();
            String senhastr = senha.getText().toString();
            String emailstr = email.getText().toString();
            String senhastr2 = senha2.getText().toString();

            if(!senhastr.equals( senhastr2 )){
                Toast msg = Toast.makeText( MainActivity.this, "senha não confere!", Toast.LENGTH_SHORT );
                msg.show();
            }else{
                CadastroMethods cadastroMethods = new CadastroMethods();
                cadastroMethods.setNome( nomestr );
                cadastroMethods.setNome( sobrenomestr );
                cadastroMethods.setNome( senhastr );
                cadastroMethods.setNome( emailstr );
                helper.InsertData( cadastroMethods );


            }

        }

    }
    public void onLoginClick(View v){
        Intent god = new Intent( MainActivity.this, login.class );
        startActivity( god );
    }

}


/*public class MainActivity extends AppCompatActivity {
    private Button botao;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btcadastro;
    EditText txtnome, txtsobrenome, txtsenha, txtemail, txtphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_tela_cadastro );

        openHelper = new CadastroActivity( this );
        txtnome = (EditText) findViewById( R.id.txtnome );
        txtsobrenome = (EditText) findViewById( R.id.txtsobrenome );
        txtsenha = (EditText) findViewById( R.id.txtsenha );
        txtemail = (EditText) findViewById( R.id.txtemail );
        btcadastro = (Button) findViewById( R.id.btcadastro );
        botao = (Button) findViewById( R.id.btentrar );


        btcadastro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();
                String nome = txtnome.getText().toString();
                String sobrenome = txtsobrenome.getText().toString();
                String senha = txtsenha.getText().toString();
                String email = txtemail.getText().toString();
                String phone = txtphone.getText().toString();
                insertdata( nome, sobrenome, senha, email, phone );
                Toast.makeText( getApplicationContext(), "Cadastrado com sucesso!!", Toast.LENGTH_LONG ).show();


            }
        } );
        botao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.activity_tela_login );
            }
        } );
    }




    public void insertdata(String nome, String sobrenome, String senha, String email, String phone){
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( CadastroActivity.COL_2, nome);
        contentValues.put( CadastroActivity.COL_3, sobrenome);
        contentValues.put( CadastroActivity.COL_4, senha);
        contentValues.put( CadastroActivity.COL_5, email);
        long id = db.insert( CadastroActivity.TABLE_NAME, null, contentValues);
    }
}*/
