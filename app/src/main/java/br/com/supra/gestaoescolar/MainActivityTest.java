package br.com.supra.gestaoescolar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by felip on 14/04/2018.
 */

public class MainActivityTest extends AppCompatActivity {
    String items [] = new String [] { "Apple","Orange","Banana","Grapes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.noticia );

        ListView listView = (ListView) findViewById( R.id.list );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, items );
        listView.setAdapter( adapter );
    }

}
