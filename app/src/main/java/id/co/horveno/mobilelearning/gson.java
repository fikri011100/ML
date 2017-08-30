package id.co.horveno.mobilelearning;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fikriimaduddin on 8/28/17.
 */

public class gson {
    @SerializedName("data")
    public List<KumpulanDataList> kumpulanDataList;

    public class KumpulanDataList {
        @SerializedName("id")
        public String id;

        @SerializedName("judul_video")
        public String judulVideo;

        @SerializedName("duration")
        public String duration;

        @SerializedName("video")
        public String video;

        @SerializedName("id_kategori")
        public String idKategori;
    }
}
