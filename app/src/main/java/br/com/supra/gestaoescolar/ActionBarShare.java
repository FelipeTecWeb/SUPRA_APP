package br.com.supra.gestaoescolar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by felip on 31/03/2018.
 */

public class ActionBarShare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_share );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.menu_main, menu );
        return super.onCreateOptionsMenu( menu );

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==R.id.action_share){
            Toast.makeText(getApplicationContext(),"share is clicked",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected( item );

    }
}
