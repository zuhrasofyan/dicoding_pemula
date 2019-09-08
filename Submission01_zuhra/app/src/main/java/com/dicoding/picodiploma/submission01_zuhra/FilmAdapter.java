package com.dicoding.picodiploma.submission01_zuhra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private TextView txtJudul;
        private TextView txtDetail;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtJudul = view.findViewById(R.id.txt_judul);
            txtDetail = view.findViewById(R.id.txt_detail);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind (Film film) {
            txtJudul.setText(film.getJudul());
            txtDetail.setText(film.getDetail());
            imgPoster.setImageResource(film.getPoster());
        }
    }


}
