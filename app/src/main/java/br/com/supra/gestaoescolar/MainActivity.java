package br.com.supra.gestaoescolar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela_login );
    }

    public void chamaMenu(View view) {
        Intent intent = new Intent( MainActivity.this, TelaInicialActivity.class );
        startActivity( intent );
    }
}
