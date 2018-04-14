package br.com.supra.gestaoescolar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Created by felip on 30/03/2018.
 */

/*public class ActionBarSearchView extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_searchview);
        ListView lv = (ListView) findViewById(R.id.listView);
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.addAll(Arrays.asList(getResources().getStringArray(R.array.arraylist)));

        adapter = new ArrayAdapter<>(ActionBarSearchView.this, android.R.layout.simple_list_item_1, arraylist);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem((R.id.action_buscar));
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}*/
