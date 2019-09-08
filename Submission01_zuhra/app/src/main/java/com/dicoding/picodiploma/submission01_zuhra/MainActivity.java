package com.dicoding.picodiploma.submission01_zuhra;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataJudul;
    private String[] dataDetail;
    private TypedArray dataPoster;
    private FilmAdapter adapter;
    private ArrayList<Film> films;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView =findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, films.get(i).getJudul(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDetail = getResources().getStringArray(R.array.data_detail);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i<dataJudul.length; i++) {
            Film film = new Film();
            film.setPoster(dataPoster.getResourceId(i, -1));
            film.setJudul(dataJudul[i]);
            film.setDetail(dataDetail[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }

}
