package id.co.horveno.mobilelearning;

/**
 * Created by fikriimaduddin on 8/29/17.
 */

public class mSearch {
    private String id, judul_video, gambar, duration, id_kategori;

    public mSearch() {
    }

    public mSearch(String id, String judul_video,String gambar,String duration,String id_kategori) {
        this.id = id;
        this.judul_video = judul_video;
        this.gambar = gambar;
        this.duration = duration;
        this.id_kategori = id_kategori;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul_video() {
        return judul_video;
    }

    public void setJudul_video(String judul_video) {
        this.judul_video = judul_video;
    }
    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getId_kategori() {
        return judul_video;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }
}
