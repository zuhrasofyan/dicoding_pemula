package com.dicoding.picodiploma.submission_02;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String judul;
    private String detail;
    private int poster;

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

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.detail);
        dest.writeInt(this.poster);
    }

    Film() {
    }

    private Film(Parcel in) {
        this.judul = in.readString();
        this.detail = in.readString();
        this.poster = in.readInt();
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
