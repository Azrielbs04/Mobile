package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private HeroAdapter adapter;
    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.tv_list);
        adapter = new HeroAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,heroes.get(i).getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

        private void addItem(){
        heroes = new ArrayList<>();
        for(int i = 0;i<dataName.length; i++){
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i,-1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
        private void prepare(){
            dataName = getResources().getStringArray(R.array.data_name);
            datadescription = getResources().getStringArray(R.array.data_description);
            dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}