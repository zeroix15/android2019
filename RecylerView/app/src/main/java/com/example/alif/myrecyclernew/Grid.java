package com.example.alif.myrecyclernew;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;

import java.util.ArrayList;

public class Grid extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    private ArrayList<Hero> heroes;

    private RecyclerView rvHeroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepare();
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        showListRecycler();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, MainActivity.class));
        } else if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, Grid.class));
        } else if (item.getItemId() == R.id.help) {
            startActivity(new Intent(this, Card.class));
        }

        return true;
    }

    private void showListRecycler() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this,2));
        ListHeroAdapter adapter = new ListHeroAdapter(this);
        addItem();
        adapter.setHeroes(heroes);
        rvHeroes.setAdapter(adapter);
    }

    private void addItem(){
        heroes = new ArrayList<>();
        for(int i = 0; i < dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i,-1));
            heroes.add(hero);
        }

    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}
