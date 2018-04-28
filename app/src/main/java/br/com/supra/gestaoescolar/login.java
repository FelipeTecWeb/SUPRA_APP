package br.com.supra.gestaoescolar;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static br.com.supra.gestaoescolar.CadastroActivity.TABLE_NAME;


public class login extends AppCompatActivity {

    CadastroActivity helper = new CadastroActivity( this  );
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button botao;
    EditText txEmail, txSenha;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela_login);
        openHelper = new CadastroActivity( this );
        db = openHelper.getReadableDatabase();
        botao = (Button) findViewById( R.id.btLogin );
        EditText a = (EditText)findViewById( R.id.txEmail );
        final String str = a.getText().toString();
        EditText b = (EditText) findViewById( R.id.txSenha );
        String senha = b.getText().toString();

        botao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String senha = helper.searchPass(str);
                if(senha.equals(senha)){
                    Intent god2 = new Intent( login.this, TelaInicialActivity.class );
                    god2.putExtra( "Nome", str );
                    startActivity( god2 );
                }else{
                    Toast msg = Toast.makeText( login.this, "usuario ou senha nao confere!", Toast.LENGTH_SHORT );
                    msg.show();
                }

                /*cursor = db.rawQuery("SELECT *FROM "+CadastroActivity.TABLE_NAME+" WHERE "+CadastroActivity.COLUMN_EMAIL+"=? AND "+CadastroActivity.COLUMN_SENHA+"=?",new String[] {email,senha});
                if (cursor != null) {
                    if(cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        //Retrieving User FullName and Email after successfull login and passing to LoginSucessActivity
                        String _fname = cursor.getString(cursor.getColumnIndex(CadastroActivity.COLUMN_N0ME));
                        String _email= cursor.getString(cursor.getColumnIndex(CadastroActivity.COLUMN_EMAIL));
                        Toast.makeText(login.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this,TelaInicialActivity.class);
                        intent.putExtra("fullname",_fname);
                        intent.putExtra("email",_email);
                        startActivity(intent);

                        //Removing MainActivity[Login Screen] from the stack for preventing back button press.
                        finish();
                    }
                    else {

                        //I am showing Alert Dialog Box here for alerting user about wrong credentials
                        final AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                        builder.setTitle("Alert");
                        builder.setMessage("Username or Password is wrong.");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        //-------Alert Dialog Code Snippet End Here
                    }
                }*/

            }
        });
                    }
            }