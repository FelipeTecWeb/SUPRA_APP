package br.com.supra.gestaoescolar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button btentrar;
    EditText txEmail, txSenha;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela_login );

        openHelper = new CadastroActivity( this );
        db = openHelper.getReadableDatabase();
        btentrar = (Button) findViewById( R.id.btentrar );
        txEmail = (EditText)findViewById( R.id.txEmail );
        txSenha = (EditText) findViewById( R.id.txSenha );

        btentrar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = txEmail.getText().toString();
                String senha = txSenha.getText().toString();
                cursor = db.rawQuery( "SELECT * FROM"+ CadastroActivity.TABLE_NAME + "WHERE" + CadastroActivity.COL_5 + " =? AND" + CadastroActivity.COL_4 +" =?", new String[]{email, senha});
                if(cursor!=null){
                    if(cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText( getApplicationContext(),"Menu", Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText( getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } );

    }
}
