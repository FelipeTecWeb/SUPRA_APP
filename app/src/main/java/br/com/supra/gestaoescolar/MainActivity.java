package br.com.supra.gestaoescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        TextView cUsuario = (TextView) findViewById( R.id.cUsuario);
        TextView cSenha = (TextView) findViewById(R.id.cSenha);

        String txtUsuario = cUsuario.toString();
        String txtSenha = cSenha.toString();

        Button botao = (Button)findViewById(R.id.btLogin);

        botao.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                TextView cUsuario = (TextView) findViewById(R.id.cUsuario);
                TextView cSenha = (TextView) findViewById(R.id.cSenha);

                String txtUsuario = cUsuario.getText().toString();
                String txtSenha = cSenha.getText().toString();

                Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);

                Bundle params = new Bundle();
                params.putString("nome", txtUsuario);
                intent.putExtras(params);

                startActivityForResult(intent, 1);
            }
        };
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            String result=data.getStringExtra("result");
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }
    public void signUpActivity(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity( intent );
    }
}
