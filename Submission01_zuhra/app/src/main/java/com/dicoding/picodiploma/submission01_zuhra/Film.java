package com.dicoding.picodiploma.submission01_zuhra;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int poster;
    private String judul;
    private String detail;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.judul);
        dest.writeString(this.detail);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.poster = in.readInt();
        this.judul = in.readString();
        this.detail = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
