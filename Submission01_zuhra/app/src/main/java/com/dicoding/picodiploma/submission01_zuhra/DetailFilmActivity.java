package com.dicoding.picodiploma.submission01_zuhra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilmActivity extends AppCompatActivity {
    TextView tvJudul;
    TextView tvDetail;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvJudul = findViewById(R.id.txt_judul);
        tvDetail = findViewById(R.id.txt_detail);
        ivPoster = findViewById(R.id.img_poster);

        Intent intent = getIntent();
        Film film = ((Intent) intent).getParcelableExtra("Film");

        String judul = film.getJudul();
        String detail = film.getDetail();
        Integer poster = film.getPoster();

        tvJudul.setText(judul);
        tvDetail.setText(detail);
        ivPoster.setImageResource(poster);
    }
}
